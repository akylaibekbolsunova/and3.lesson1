package com.example.and3lesson1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {
    private final List<Card<CardContent>> cards = new ArrayList<>();
    private boolean endGame = false;

    public Game(List<CardContent> cardContents) {
        for (int i = 0; i < cardContents.size(); i++) {
            cards.add(new Card<>(i + 1, false, false, cardContents.get(i)));
            cards.add(new Card<>(i + 2, false, false, cardContents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void cardClick(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        for (int i = 0; i < cards.size(); i++) {
            if (card.isFaceUp() && cards.get(i).isFaceUp() &&
                    cards.get(i).getId() != card.getId() &&
                    card.getContent().equals(cards.get(i).getContent())) {
                Log.d("TAG", "TRUE CHOOSE!!!");
                card.setMatched(true);
                cards.get(i).setMatched(true);
                removeCardInYourPosition();
            } else if (card.isFaceUp() &&
                    cards.get(i).isFaceUp() &&
                    card.getId() != cards.get(i).getId() &&
                    !card.getContent().equals(cards.get(i).getContent())) {
                card.setFaceUp(false);
                cards.get(i).setFaceUp(false);
                Log.d("TAG", "WRONG CHOOSE!!!");
            }
        }
        finish();
    }

    private void removeCardInYourPosition() {
        List<Card<CardContent>> cardArrayList = new ArrayList<>(cards);
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isMatched()) cardArrayList.remove(cards.get(i));
        }
        cards.clear();
        cards.addAll(cardArrayList);
    }

    public void finish() {
        if (cards.isEmpty()) setEndGame(true);
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }
}