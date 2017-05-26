package com.wb.lazydemo.main;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by LazyDemo on 2017/5/26.
 */

public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private IAdapterMove move;

    public MyItemTouchHelperCallback(){}

    public MyItemTouchHelperCallback(IAdapterMove move){
       this.move = move;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
//        return false;
    }

    //移动adapter数据
    public interface IAdapterMove{
        public void move(int oldPosition, int newPosition);
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN
                |ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,dragFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        move.move(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

        super.onSelectedChanged(viewHolder, actionState);
    }

    /**
     * 移动过程中绘制item
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    /**
     * 用户操作完毕或者动画完毕后会被调用
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {


        super.clearView(recyclerView, viewHolder);
    }
}
