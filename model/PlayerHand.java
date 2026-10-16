package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerHand implements Hand{

    private final ObservableList<Card> cards;
    private static final int MAX_SIZE = 4;

    public PlayerHand() {
        this.cards = FXCollections.observableArrayList();
    }

    public ObservableList<Card> getCards() { return cards; }

    public boolean isFull() {
        return cards.size() >= MAX_SIZE;
    }

    public boolean isProtected() {
        for (Card card : cards) {
            if (card.isProtector()) {
                return true;
            }
        }
        return false;
    }

    public void weaken(int amount) {
        for (Card card : cards) {
            card.weaken(amount);
        }
    }

    public void place(Card card) {
        cards.add(card);
    }

    public void draw(Card card) {
        this.cards.remove(card);
    }

}
