package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.Random;
import java.util.Collections;

public class Deck {
    private final ObservableList<Card> cards;
    private final Random random;
    private final BooleanProperty isEmpty;

    public Deck(int amount, Random random) {
        this.cards = FXCollections.observableArrayList(DeckGenerator.generate(amount));
        this.random = random;
        this.isEmpty = new SimpleBooleanProperty(cards.isEmpty());

        cards.addListener((ListChangeListener<Card>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved()) {
                    isEmpty.set(cards.isEmpty());
                }
            }
        });
    }

    public ObservableList<Card> getCards() {
        return this.cards;
    }
    public ReadOnlyBooleanProperty emptyProperty() {
        return isEmpty;
    }
    public boolean isEmpty() {
        return emptyProperty().get();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card draw() {
        return cards.remove(0);
    }

    public boolean hasEnough(int amount) {
        return cards.size() >= amount;
    }

    public void merge(Deck deck) {
        LinkedList<Card> toRemove = new LinkedList<>();
        for (Card card : deck.cards) {
            toRemove.add(card);
            this.cards.add(card);
        }
        for (Card card : toRemove) {
            deck.cards.remove(card);
        }
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards, random);
    }

}
