package com.example.rodrigo.examenml.adapter;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.rodrigo.examenml.R;
import com.example.rodrigo.examenml.model.CuotasCosts;
import com.example.rodrigo.examenml.util.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by L0663298 on 26/01/2018.
 */

public class CuotasAdapter extends RecyclerView.Adapter<CuotasAdapter.ViewHolder> {


    private List<CuotasCosts> costsList;
    private RecyclerViewItemClickListener<CuotasCosts> itemClickListener;


    public CuotasAdapter(List<CuotasCosts> costsList, RecyclerViewItemClickListener<CuotasCosts> itemClickListener) {
        this.costsList = costsList;
        this.itemClickListener = itemClickListener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cuotas_costs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.checkBox.setText(costsList.get(position).getCuotasValue());
    }

    @Override
    public int getItemCount() {
        return costsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

        AppCompatCheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            checkBox = (AppCompatCheckBox) itemView.findViewById(R.id.adapter_cuotas_costs_item);
            checkBox.setOnCheckedChangeListener(this);
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(itemClickListener != null) {
                itemClickListener.onItemClicked(costsList.get(getAdapterPosition()), getAdapterPosition());
            }
        }
    }


}
