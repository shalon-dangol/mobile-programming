package com.example.test;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private GridView gridview;
    private ArrayList<Product> productList = new ArrayList<>();
    private ProductListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initToolbar();
        findViews();
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Product List");
    }

    private void findViews(){

        gridview = findViewById(R.id.gridview);
        setData();
        adapter = new ProductListAdapter(productList, GridActivity.this);
        gridview.setAdapter(adapter);
    }

    private void setData(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setTitle("test");
        p1.setDescription("test");
        p1.setUnit("pcs");
        p1.setPrice("200");
        p1.setQuantity("3");
        p1.setImage(R.drawable.ic_house);

        p2.setTitle("test2");
        p2.setDescription("test2");
        p2.setUnit("pcs");
        p2.setPrice("200");
        p2.setQuantity("3");
        p2.setImage(R.drawable.ic_search);

        p3.setTitle("test3");
        p3.setDescription("test3");
        p3.setUnit("pcs");
        p3.setPrice("200");
        p3.setQuantity("3");
        p3.setImage(R.drawable.ic_user);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

    }
}
