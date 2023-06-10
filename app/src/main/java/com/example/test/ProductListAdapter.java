package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {

    private ArrayList<Product> productList = new ArrayList<>();
    private Context context;
    ProductListAdapter(ArrayList<Product> dataList, Context mContext){
        productList.clear();
        productList.addAll(dataList);
        context = mContext;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.adapter_product_item, null);
        ProductListVH holder = new ProductListVH(view);
        holder.txtProductTitle.setText(productList.get(position).getTitle());
        holder.txtProductDescription.setText(productList.get(position).getDescription());
        holder.txtProductQuantity.setText(productList.get(position).getQuantity());
        holder.txtProductUnit.setText(productList.get(position).getUnit());
        holder.imgProduct.setImageDrawable(context.getResources().getDrawable(productList.get(position).getImage()));


        return view;
    }

    public static class ProductListVH {
        TextView txtProductTitle, txtProductDescription, txtProductUnit, txtProductQuantity;
        ImageView imgProduct;
        ProductListVH(View view) {
            txtProductTitle = view.findViewById(R.id.txtProductTitle);
            txtProductDescription = view.findViewById(R.id.txtProductDescription);
            txtProductUnit = view.findViewById(R.id.txtProductUnit);
            txtProductQuantity = view.findViewById(R.id.txtProductQuantity);
            imgProduct = view.findViewById(R.id.imgProduct);
        }
    }
}
