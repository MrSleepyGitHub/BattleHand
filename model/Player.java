package model;

import model.exception.*;

public class Player {
    private final PlayerHand hand;
    private final BattleHand battleHand;
    private final Deck discardPile;

    public Player(BattleHand battleHand, Deck discardPile) {
        this.hand = new PlayerHand();
        this.battleHand = battleHand;
        this.discardPile = discardPile;
    }

    public PlayerHand getHand() { return hand; }

    public void place(Card card) {
        hand.place(card);
    }

    public void battle(Card card) throws BattleException, FullHandException {
        if (!battleHand.canPlace(card)) {
            throw new BattleException("Slot taken");
        }
        if (hand.isFull()) {
            throw new FullHandException("Your hand is full");
        }
        hand.draw(card);
        battleHand.place(card);
    }

    public void discard(Card card) {
        this.hand.draw(card);
        this.discardPile.add(card);
    }

    public void weaken(int amount) {
        if (!hand.isProtected()) {
            hand.weaken(amount);
        }
    }
}
