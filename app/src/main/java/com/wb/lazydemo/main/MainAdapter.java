package com.wb.lazydemo.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wb.lazydemo.R;

import java.util.List;

/**
 * Created by lazydemo on 2017/05/20 0020.
 * email: lazydemo@163.com
 */

public class MainAdapter extends RecyclerView.Adapter implements View.OnClickListener,View.OnLongClickListener{

    private Context context;
    private List<String> list;//功能选项

    private OnRecycleViewItemClickListener listener = null;

    public MainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    //自定义监听事件
    public static interface OnRecycleViewItemClickListener{
        void onItemClick(View view);
        void onItemLongClick(View view);
    }
    public void setListener(OnRecycleViewItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        MainViewHolder holder = new MainViewHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MainViewHolder){
            ((MainViewHolder) holder).textView.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onItemClick(view);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (listener!=null){
            listener.onItemLongClick(view);
        }

        return false;
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MainViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.main_item);
        }
    }
}
