package com.dqr.www.recyclerview.recyclerview.muladapter;

import android.view.MotionEvent;
import android.view.View;

import com.dqr.www.recyclerview.R;
import com.dqr.www.recyclerview.bean.WelfareBean;

/**
 * Description：
 * Author：LiuYM
 * Date： 2017-03-30 15:55
 */

public class GirlViewHolder extends MulViewHolder<WelfareBean> {



    public GirlViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setUpVew(WelfareBean model, int position,final MultiTypeAdapter multiTypeAdapter) {
        setImageResource(R.id.iv_btn, model.getUrl());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(multiTypeAdapter.getDragSwipeListener()!=null){
                    multiTypeAdapter.getDragSwipeListener().onStartDrag(GirlViewHolder.this);
                }
                return false;
            }
        });


        itemView.setOnTouchListener(new View.OnTouchListener() {
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
                            if (multiTypeAdapter.getDragSwipeListener() != null) {
                                multiTypeAdapter.getDragSwipeListener().onStartSwipe(GirlViewHolder.this);
                            }
                        }
                        break;
                }
                return false;
            }
        });

    }
}
