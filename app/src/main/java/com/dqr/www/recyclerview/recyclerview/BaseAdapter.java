package com.dqr.www.recyclerview.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description：适配器基类
 * Author：LiuYM
 * Date： 2017-03-30 13:39
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected List<T> realData;
    protected final int mItemLayoutId;
    protected boolean isScrolling;
    protected Context mContext;
    protected OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(View view,Object data,int position);
    }

    public void setScrolling(boolean scrolling) {
        isScrolling = scrolling;
    }

    public BaseAdapter(RecyclerView recyclerView, Collection<T> data, int itemLayoutId){
        mItemLayoutId=itemLayoutId;
        mContext=recyclerView.getContext();
        if(data==null){
            realData = new ArrayList<>();
        }else if(data instanceof List){
            realData= (List<T>) data;
        }else{
            realData = new ArrayList<>(data);
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                isScrolling=!(newState==RecyclerView.SCROLL_STATE_IDLE);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(mItemLayoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final T obj=realData.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(v,obj,position);
                }
            }
        });

        bindData(holder,obj,position,isScrolling);
    }

    @Override
    public int getItemCount() {
        return realData.size();
    }

    /**
     * 刷新数据源
     * @param data
     * @return
     */
    public BaseAdapter<T> refresh(Collection<T> data){
        if(data==null){
            realData = new ArrayList<>();
        }else if(data instanceof  List){
            realData= (List<T>) data;
        }else{
            realData = new ArrayList<>(data);
        }
        return this;
    }

    /**
     * 绑定数据 填充方法
     * @param holder ViewHolder
     * @param item 数据对象
     * @param position 位置
     * @param isScrolling 是否在滑动
     */
    public abstract void bindData(ViewHolder holder,T item,int position,boolean isScrolling);
}
