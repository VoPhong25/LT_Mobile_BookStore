package com.example.bookstore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView history_card, novel_card, thrillers_card, self_help_card;
    TextView tv_history_card,tv_novel_card,tv_thrillers_card,tv_self_help_card;
    public static final String BOOK_HISTORY_KEY = "book_history_key";
    public static final String BOOK_NOVEL_KEY = "book_novel_key";
    public static final String BOOK_THRILLERS_KEY = "book_thrillerskey";
    public static final String BOOK_SELF_HELP_KEY = "book_self_help_key";
    public static String name_data ="";


    ShoppingDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history_card = findViewById(R.id.history_card);
        novel_card = findViewById(R.id.novel_card);
        thrillers_card = findViewById(R.id.thrillers_card);
        self_help_card = findViewById(R.id.self_help_card);

        tv_history_card = findViewById(R.id.tv_history_card);
        tv_novel_card = findViewById(R.id.tv_novel_card);
        tv_thrillers_card = findViewById(R.id.tv_thrillers_card);
        tv_self_help_card = findViewById(R.id.tv_self_help_card);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Book Category");


        db = new ShoppingDatabase(this);
        db.deleteDatabase(this);
//        db.deleteAllFashionProducts();
        db.getWritableDatabase();
        db.insertSampleData();
//        db.insertSampleDataIntoPurchases();


        history_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_history_card.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BOOK_HISTORY_KEY,tv_history_card.getText().toString());
                startActivity(intent);
            }
        });

        novel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_novel_card.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BOOK_NOVEL_KEY,tv_novel_card.getText().toString());
                startActivity(intent);
            }
        });

        thrillers_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_thrillers_card.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BOOK_THRILLERS_KEY,tv_thrillers_card.getText().toString());
                startActivity(intent);
            }
        });

        self_help_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_data = tv_self_help_card.getText().toString();
                Intent intent = new Intent(getBaseContext(),ProductsCardActivity.class);
                intent.putExtra(BOOK_SELF_HELP_KEY,tv_self_help_card.getText().toString());
                startActivity(intent);
            }
        });


    }
}