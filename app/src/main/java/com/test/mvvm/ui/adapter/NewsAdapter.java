package com.test.mvvm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.test.mvvm.R;
import com.test.mvvm.databinding.ItemNewsBinding;
import com.test.mvvm.model.New;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 类描述
 * @Author: ganqiubo
 * @CreateDate: 2022/8/12 16:21
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private List<New> datas = new ArrayList<>();
    private ItemClickListener itemClickListener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        New data = datas.get(position);
        holder.bind(data, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void addData(List<New> datas){
        if(datas==null||datas.size()<=0){
            return;
        }
        int positionStart = this.datas.size() + 1;
        this.datas.addAll(datas);
        notifyItemRangeInserted(positionStart, datas.size());
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemNewsBinding mBinding;

        public MyViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(@NonNull New data, ItemClickListener itemClickListener) {
            mBinding.setData(data);
            mBinding.setItemclidk(itemClickListener);
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void click(New item);
    }

}