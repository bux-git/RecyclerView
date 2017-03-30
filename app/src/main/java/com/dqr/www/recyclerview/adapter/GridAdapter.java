package com.dqr.www.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.WelfareBean;
import com.dqr.www.recyclerview.listener.OnRecyclerItemClickListener;
import com.dqr.www.recyclerview.listener.OnStartDragSwipeListener;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-29 9:46
 */

public class GridAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<WelfareBean> mList;
    private OnRecyclerItemClickListener mListener;
    private OnStartDragSwipeListener mDragSwipeListener;


    public GridAdapter(Context context, List<WelfareBean> list) {
        mContext = context;
        mList = list;
    }

    public void setDragSwipeListener(OnStartDragSwipeListener dragSwipeListener) {
        mDragSwipeListener = dragSwipeListener;
    }

    public void setListener(OnRecyclerItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        //判断item类别，是图还是显示页数(图片有URL)
        if (!TextUtils.isEmpty(mList.get(position).getUrl())) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.grid_meizi_item, parent, false);
            final ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.page_item, parent, false);
            ViewHolder2 viewHolder2 = new ViewHolder2(view);
            return viewHolder2;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder holder1 = (ViewHolder) holder;
            Glide.with(mContext).load(mList.get(position).getUrl()).into(holder1.mImageButton);
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mDragSwipeListener != null) {
                        mDragSwipeListener.onStartDrag(holder);
                    }
                    return false;
                }
            });

            holder.itemView.setOnTouchListener(new View.OnTouchListener() {
                int oldX;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            oldX = (int) event.getX();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            int danceX = (int) Math.abs(event.getX() - oldX);
                            if (danceX > 50) {
                                if (mDragSwipeListener != null) {
                                    mDragSwipeListener.onStartSwipe(holder);
                                }
                            }
                            break;
                    }
                    return false;
                }
            });

        } else if (holder instanceof ViewHolder2) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.mTextView.setText(mList.get(position).getPage() + "");
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton mImageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageButton = (ImageButton) itemView.findViewById(R.id.iv_btn);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder2(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_page);
        }
    }
}
