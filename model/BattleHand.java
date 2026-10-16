package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Objects;

public class BattleHand implements Hand {

    private final ObservableList<Card> cards;
    private final IntegerProperty strength;

    public BattleHand() {
        this.cards = FXCollections.observableArrayList();
        this.strength = new SimpleIntegerProperty(0);

        for (int i = 0; i < AttackType.values().length; i++) {
            this.cards.add(null);
        }

        cards.addListener((ListChangeListener<Card>) change -> {
            strength.set(cards.stream().filter(Objects::nonNull).mapToInt(Card::getStrength).sum());
        });
    }

    public ObservableList<Card> getCards() { return this.cards; }
    public ReadOnlyIntegerProperty strengthProperty() { return strength; }

    @Override
    public boolean isFull() {
        for (Card card : cards) {
            if (card == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void place(Card card) {
        cards.set(card.getType().slot(), card);
    }

    public boolean canPlace(Card card) {
        return cards.get(card.getType().slot()) == null;
    }

}
