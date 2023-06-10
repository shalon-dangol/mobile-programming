package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductDataVH> {
    private ArrayList<Product> productList = new ArrayList<>();
    private Context context;
    ProductAdapter(Context mContext, ArrayList<Product> dataList){
        productList.clear();
        productList.addAll(dataList);
        context = mContext;
    }
    @NonNull
    @Override
    public ProductDataVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_item, parent,false);
        return new ProductDataVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDataVH holder, int position) {
        holder.txtProductTitle.setText(productList.get(position).getTitle());
        holder.txtProductDescription.setText(productList.get(position).getDescription());
        holder.txtProductQuantity.setText(productList.get(position).getQuantity());
        holder.txtProductUnit.setText(productList.get(position).getUnit());
        holder.imgProduct.setImageDrawable(context.getResources().getDrawable(productList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
