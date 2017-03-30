package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dqr.www.recyclerview.listener.OnStartDragSwipeListener;

import java.util.List;

/**
 * Description：多类型Adapter
 * Author：LiuYM
 * Date： 2017-03-30 15:27
 */

public class MultiTypeAdapter extends RecyclerView.Adapter<MulViewHolder> {

    private TypeFactory mTypeFactory;
    private List<Visitable> models;

    private OnStartDragSwipeListener mDragSwipeListener;

    public void setDragSwipeListener(OnStartDragSwipeListener dragSwipeListener) {
        mDragSwipeListener = dragSwipeListener;
    }

    public OnStartDragSwipeListener getDragSwipeListener() {
        return mDragSwipeListener;
    }

    public MultiTypeAdapter(List<Visitable> models) {
        this.models = models;
        this.mTypeFactory = new TypeFactoryForList();

    }

    @Override
    public MulViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(viewType, parent,false);
        return mTypeFactory.createViewHolder(viewType,itemView);
    }

    @Override
    public void onBindViewHolder(MulViewHolder holder, int position) {
        holder.setUpVew(models.get(position),position,this);

    }

    @Override
    public int getItemCount() {
        if(null==models) {
            return 0;
        }
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position).type(mTypeFactory);
    }
}
