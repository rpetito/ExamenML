package com.example.rodrigo.examenml.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rodrigo.examenml.util.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by L0663298 on 22/01/2018.
 */

public abstract class BaseAdapter<T extends List<T>, VH extends BaseAdapter.BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected abstract int getLayout();
    protected abstract VH getViewHolder(View view);
    protected abstract boolean listenItemClicked();

    private Context context;
    private T itemList;
    private RecyclerViewItemClickListener itemClickListener;


    public BaseAdapter(Context context, T itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    public void setItemClickListener(RecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayout(), parent, false);
        VH holder = getViewHolder(view);
        view.setOnClickListener(holder);
        return holder;
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }



    public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClicked(itemList.get(getAdapterPosition()), getAdapterPosition());
            }
        }

    }

}
