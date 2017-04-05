package com.dqr.www.recyclerview;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.util.TypedValue;

import com.dqr.www.recyclerview.api.ApiService;
import com.dqr.www.recyclerview.api.BaseCallBack;
import com.dqr.www.recyclerview.api.RetrofitUtils;
import com.dqr.www.recyclerview.bean.BaseBean;
import com.dqr.www.recyclerview.bean.PageBen;
import com.dqr.www.recyclerview.bean.WelfareBean;
import com.dqr.www.recyclerview.bean.WelfareBean2;
import com.dqr.www.recyclerview.constant.ApiConstant;
import com.dqr.www.recyclerview.listener.OnStartDragSwipeListener;
import com.dqr.www.recyclerview.recyclerview.muladapter.MulAdapter;
import com.dqr.www.recyclerview.recyclerview.muladapter.Visitable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private List<Visitable> mList;
    private MulAdapter mAdapter;
    private GridLayoutManager mManager;
    private int lastVisibleItem;
    private int page = 1;
    private ItemTouchHelper mItemTouchHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);
        initView();//初始化布局
        setListener();//设置监听事件
    }


    private void initView() {
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sw_refresh);
        mRecyclerView = (RecyclerView) findViewById(R.id.rl_content);
        mManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mManager);
        mSwipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

        mList = new ArrayList<>();
        mAdapter = new MulAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.post(new Runnable() {//第一次进入显示刷新球
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                getTypeData();
            }
        });

    }

    private void setListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getTypeData();
            }

        });
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem >= mManager.getItemCount() - 2) {
                    getTypeData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //获取加载的最后一个可见视图在适配器的位置
                lastVisibleItem = mManager.findLastVisibleItemPosition();
            }
        });

        mItemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags=ItemTouchHelper.UP|ItemTouchHelper.DOWN;
                int swipeFlags=ItemTouchHelper.START|ItemTouchHelper.END;
                return makeMovementFlags(dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                mAdapter.notifyItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mList.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return false;
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                if(actionState== ItemTouchHelper.ACTION_STATE_DRAG){
                    viewHolder.itemView.setAlpha(1-Math.abs(dY)/getResources().getDisplayMetrics().heightPixels);
                }else if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE){
                    viewHolder.itemView.setAlpha(1-Math.abs(dX)/getResources().getDisplayMetrics().widthPixels);
                }
            }
        });
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        mAdapter.setDragSwipeListener(new OnStartDragSwipeListener() {
            @Override
            public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
                mItemTouchHelper.startDrag(viewHolder);
            }

            @Override
            public void onStartSwipe(RecyclerView.ViewHolder viewHolder) {
                mItemTouchHelper.startSwipe(viewHolder);
            }
        });

        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int size=mAdapter.getSpanSize(position);
                Log.d(TAG, "getSpanSize: "+size);
                return size;
            }
        });
    }

    private void getTypeData() {
        RetrofitUtils.getInstance(MainActivity.this).create(ApiService.class)
                .getSubData("福利", ApiConstant.PAGE_COUNT, page)
                .enqueue(new BaseCallBack<BaseBean<List<WelfareBean>>>() {
                    @Override
                    protected void onSuccess(BaseBean<List<WelfareBean>> result) {
                        List<WelfareBean> welList=result.getResults();
                        if (page == 1) {//刷新
                            mList.clear();
                        }
                        if (welList != null) {//有数据时
                            PageBen pageBen = new PageBen();
                            pageBen.setPage(page);
                            mList.add(pageBen);//增加页
                            if(page%2==0){
                                mList.addAll(welList);
                            }else{

                                for(int i=0;i<welList.size();i++){
                                    WelfareBean2 bean2 = new WelfareBean2();
                                    bean2.setUrl(welList.get(i).getUrl());
                                    mList.add(bean2);
                                }
                            }
                            page++;
                        }
                        mAdapter.notifyDataSetChanged();

                    }

                    @Override
                    protected void onFail(String msg) {

                    }

                    @Override
                    protected void onAfter() {
                        super.onAfter();
                        mSwipeRefreshLayout.setRefreshing(false);

                    }
                });
    }


}
