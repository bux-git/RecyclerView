package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.recyclerview.listener.OnStartDragSwipeListener;

import java.util.List;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-31 10:26
 */

public class MulAdapter extends RecyclerView.Adapter<MulViewHolder> {
    private List<Visitable> mList;
    private TypeFactory mTypeFactory;
    private OnStartDragSwipeListener mDragSwipeListener;

    public MulAdapter(List<Visitable> list) {
        this.mList = list;
        mTypeFactory = new TypeFactoryList();
    }

    @Override
    public MulViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return mTypeFactory.createViewHolder(viewType, itemView);
    }

    @Override
    public void onBindViewHolder(MulViewHolder holder, int position) {
        holder.setUpView(mList.get(position), position, this);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type(mTypeFactory);
    }

    public void setDragSwipeListener(OnStartDragSwipeListener dragSwipeListener) {
        mDragSwipeListener = dragSwipeListener;
    }

    public OnStartDragSwipeListener getDragSwipeListener() {
        return mDragSwipeListener;
    }

    public int getSpanSize(int position) {
        return mList.get(position).getSpanSize(mTypeFactory);
    }
}
