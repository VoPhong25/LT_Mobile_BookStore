package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductsCardActivity extends AppCompatActivity {

    RecyclerView rv;
    private ProductAdapter adapter;
    public static final String PRODUCT_ID_KEY = "product_key";
    public static final String TABLE_NAME_KEY = "table_name_key";
    TextView tv_product_name;
    ShoppingDatabase db;
    private String table_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_card);

        rv = findViewById(R.id.rv_products);
        tv_product_name = findViewById(R.id.tv_product_name);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.zoom_element);
        tv_product_name.setAnimation(animation);

        db = new ShoppingDatabase(this);

        Intent intent = getIntent();
        String name;
        switch (MainActivity.name_data){
            case "History":
                name = intent.getStringExtra(MainActivity.BOOK_HISTORY_KEY);
                tv_product_name.setText(name);
                table_name = ShoppingDatabase.TB_BOOK_HISTORY;
                break;
            case "Novel":
                name = intent.getStringExtra(MainActivity.BOOK_NOVEL_KEY);
                tv_product_name.setText(name);
                table_name = ShoppingDatabase.TB_BOOK_NOVEL;
                break;
            case "Thrillers":
                name = intent.getStringExtra(MainActivity.BOOK_THRILLERS_KEY);
                tv_product_name.setText(name);
                table_name = ShoppingDatabase.TB_BOOK_THRILLERS;
                break;
            case "Self-Help":
                name = intent.getStringExtra(MainActivity.BOOK_SELF_HELP_KEY);
                tv_product_name.setText(name);
                table_name = ShoppingDatabase.TB_BOOK_SELF_HELP;
                break;
        }
        MainActivity.name_data = "";

        ArrayList<Products> products = new ArrayList<>();
        products = db.getAllProducts(table_name);
        adapter = new ProductAdapter(products, new OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int productId) {
                Intent i = new Intent(getBaseContext(),DisplayProductsActivity.class);
                i.putExtra(PRODUCT_ID_KEY,productId);
                i.putExtra(TABLE_NAME_KEY,table_name);
                HomeActivity.flag = false;
                startActivity(i);
            }
        });
        RecyclerView.LayoutManager lm = new GridLayoutManager(this,2);
        rv.setLayoutManager(lm);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

    }

    @SuppressLint("ResourceAsColor")
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.main_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<Products> product = db.getProductForSearch(query,table_name);
                adapter.setProducts(product);
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Products> product = db.getProductForSearch(newText,table_name);
                adapter.setProducts(product);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                ArrayList<Products> product = db.getAllProducts(table_name);
                adapter.setProducts(product);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        return true;
    }

}