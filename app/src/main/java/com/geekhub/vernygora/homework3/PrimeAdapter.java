package com.geekhub.vernygora.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class PrimeAdapter extends RecyclerView.Adapter<PrimeAdapter.ViewHolder> {

    public List<String> mData;
    private LayoutInflater mInflater;

    PrimeAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String primeNumber = mData.get(position);
        holder.tvPrimeNumber.setText(primeNumber);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrimeNumber;

        ViewHolder(View itemView) {
            super(itemView);
            tvPrimeNumber = itemView.findViewById(R.id.textPrime);
        }
    }
}
