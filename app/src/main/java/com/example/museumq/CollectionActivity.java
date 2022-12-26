package com.example.museumq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        ImageButton buttonBack = findViewById(R.id.BackCollection);
        ImageButton Treh_lichinaButton = findViewById(R.id.TrehLichina);
        ImageButton BoyarskayaButton = findViewById(R.id.BoyarskayaButton);
        ImageButton Olenii_blyahi = findViewById(R.id.OleniBlyahiButton);
        ImageButton Ohothik = findViewById(R.id.Ohotnik);

        buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Treh_lichinaButton.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, PageExponat.class);

            intent.putExtra("Title", "Трёхчастная личина");
            intent.putExtra("SubArticle", "");
            intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.lichina3_1block));
            intent.putExtra("Picture",R.drawable._2_tryokhchastnaya_lichina_v_1);
            intent.putExtra("PictureMap",R.drawable.mapoflichina);

            startActivity(intent);
        });

        BoyarskayaButton.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, PageExponat.class);

            intent.putExtra("Title", "Боярская писаница");
            intent.putExtra("SubArticle", "");
            intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.boyarskaya_1block));
            intent.putExtra("Picture",R.drawable._10_boyarskaya_pisanitsa);
            intent.putExtra("PictureMap",R.drawable.boyarskyamap);

            startActivity(intent);
        });

        Olenii_blyahi.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, PageExponat.class);

            intent.putExtra("Title", "Оленьи Бляхи");
            intent.putExtra("SubArticle", "");
            intent.putExtra("ArticleFirstBlock",getResources().getString(R.string.olenii_1block));
            intent.putExtra("Picture",R.drawable.blyahi_oleni);
            intent.putExtra("PictureMap",R.drawable.boyarskyamap);

            startActivity(intent);
        });

        Ohothik.setOnClickListener(view -> {
            Intent intent = new Intent(CollectionActivity.this, MapOfExponat.class);
            intent.putExtra("Picture",R.drawable.ohotniknew);
            startActivity(intent);
        });



    }
}