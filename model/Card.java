package model;

import javafx.beans.property.*;

public class Card {

    private final String name;
    private final IntegerProperty strength;
    private final AttackType type;

    public Card(String name, int strength, AttackType type) {
        this.name = name;
        this.strength = new SimpleIntegerProperty(strength);
        this.type = type;
    }

    public ReadOnlyStringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }
    public IntegerProperty strengthProperty() {
        return this.strength;
    }
    public AttackType getType() {
        return type;
    }

    public void weaken(int amount) {
        this.strength.set(this.strength.get() - amount);
        if (this.strength.get() < 0) {
            this.strength.set(0);
        }
    }

    public int getStrength() {
        return this.strength.get();
    }

    public boolean isProtector() {
        return this.type == AttackType.PROTECTOR;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.strength.get() + ")";
    }

    //Do not remove this. You do not need to use this in your implementation.
    public static Card copy(Card card) {
        return new Card(card.name, card.strength.get(), card.type);
    }
}
