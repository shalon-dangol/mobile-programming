package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.test.movie.MovieContainer;
import com.example.test.movie.Results;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView productRecycler;
    private ProductAdapter adapter;
    private ArrayList<Product> productList = new ArrayList<>();
    private MovieContainer movieData;

    private ArrayList<Results> movieResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initToolbar();
        findViews();
        setData();
    }
    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Product List");
    }

    private void findViews(){

        productRecycler = findViewById(R.id.productRecycler);
        adapter = new ProductAdapter(RecyclerActivity.this, productList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        productRecycler.setLayoutManager(layoutManager);
        productRecycler.setAdapter(adapter);
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
    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
        ProgressDialog p = new ProgressDialog(RecyclerActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            p.setMessage("Please wait...");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();

        }

        @Override
        protected Boolean doInBackground(String... urls) {

            //------------------>>
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://api.themoviedb.org/3/movie/upcoming?api_key=ef8f48b43832a9e95b87408bf739ed51")
                    .build();
            Response responses = null;


            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("Page Vale", String.valueOf(e.getLocalizedMessage()));
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    p.dismiss();
                    if (response.isSuccessful()) {
                        String jsonData = response.body().string();
                        JSONObject Jobject = null;

                        Gson gsonObj = new Gson();

                        movieData = gsonObj.fromJson(jsonData, MovieContainer.class);
                        movieResult.clear();
                        movieResult.addAll(movieData.getResultsList());
//                        try {
//                            Jobject = new JSONObject(jsonData);
//                            JSONArray Jarray = Jobject.getJSONArray("results");
//
//                            for (int i = 0; i < Jarray.length(); i++) {
//                                JSONObject object = Jarray.getJSONObject(i);
//                                Log.d("Title", object.getString("title"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }


                    }
                }
            });


            return false;
        }

        protected void onPostExecute(Boolean result) {

        }
    }
}