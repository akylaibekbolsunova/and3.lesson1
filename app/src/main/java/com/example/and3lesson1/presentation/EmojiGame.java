package com.example.and3lesson1.presentation;

import com.example.and3lesson1.domain.Card;
import com.example.and3lesson1.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {
    private Game<String> game;

    public EmojiGame(){
        List<String> cardContent = new ArrayList<>();
        cardContent.add("\uD83D\uDE0D");
        cardContent.add("\uD83E\uDD8A");
        cardContent.add("\uD83E\uDD84");
        game = new Game<>(cardContent);
    }
    public void cardClick(Card<String> card){
        game.cardClick(card);
    }
    public List<Card<String>> getCards(){
        return game.getCards();
    }
}
