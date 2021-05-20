package com.example.and3lesson1.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.and3lesson1.R;
import com.example.and3lesson1.domain.Card;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmojiAdapter emojiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.cards);
        emojiAdapter = new EmojiAdapter();
        recyclerView.setAdapter(emojiAdapter);
    }
}