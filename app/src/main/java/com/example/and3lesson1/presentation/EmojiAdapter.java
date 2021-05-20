package com.example.and3lesson1.presentation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and3lesson1.R;
import com.example.and3lesson1.domain.Card;

import org.jetbrains.annotations.NotNull;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiVH> {

    private final EmojiGame emojiGame = new EmojiGame();

    @NonNull
    @Override
    public EmojiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiAdapter.EmojiVH holder, int position) {
        holder.onBind(emojiGame.getCards().get(position),position);
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class EmojiVH extends RecyclerView.ViewHolder {
        public TextView cardTv;

        public EmojiVH(@NonNull @NotNull View itemView) {
            super(itemView);
            cardTv = itemView.findViewById(R.id.card_txt);
        }

        public void onBind(Card<String> card, int pos) {
            if (card.isFaceUp()) {
                cardTv.setText(card.getContent());
                cardTv.setBackgroundColor(Color.WHITE);
            } else {
                cardTv.setText("");
                cardTv.setBackgroundColor(Color.MAGENTA);
            }
            cardTv.setOnClickListener(v -> {
                emojiGame.cardClick(card);
                notifyDataSetChanged();
            });
        }
    }

}
