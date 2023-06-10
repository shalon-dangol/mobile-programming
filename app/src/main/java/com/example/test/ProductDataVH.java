package com.example.test;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductDataVH extends RecyclerView.ViewHolder {

    TextView txtProductTitle, txtProductDescription, txtProductUnit, txtProductQuantity;
    ImageView imgProduct;
    public ProductDataVH(@NonNull View view) {
        super(view);
            txtProductTitle = view.findViewById(R.id.txtProductTitle);
            txtProductDescription = view.findViewById(R.id.txtProductDescription);
            txtProductUnit = view.findViewById(R.id.txtProductUnit);
            txtProductQuantity = view.findViewById(R.id.txtProductQuantity);
            imgProduct = view.findViewById(R.id.imgProduct);
    }
}
