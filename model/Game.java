package model;

import model.exception.EmptyDeckException;

import java.util.Random;

public class Game {
    private final Player[] players;
    private final Deck mainDeck;
    private final Deck specialDeck;
    private final Deck discardPile;
    private final BattleHand battleHand;
    private int turnCounter;

    public Game(Random random) {
        this.mainDeck = new Deck(20, random);
        this.specialDeck = new Deck(8, random);
        this.discardPile = new Deck(0, random);
        this.battleHand = new BattleHand();

        this.players = new Player[] {
                new Player(battleHand, discardPile),
                new Player(battleHand, discardPile),
                new Player(battleHand, discardPile)
        };

        this.turnCounter = 0;
    }

    public Deck getMainDeck() { return mainDeck; }
    public Deck getSpecialDeck() { return specialDeck; }
    public Deck getDiscardPile() { return discardPile; }
    public Player[] getPlayers() { return players; }
    public BattleHand getBattleHand() { return battleHand; }

    public void weaken(int amount) {
        for (Player player : players) {
            player.weaken(amount);
        }
    }

    public void deal() throws EmptyDeckException  {
        if (!canPlay()) {
            throw new EmptyDeckException("Not enough cards in the deck");
        }
        for (Player player : players) {
            turnCounter++;
            Card card = pickCard();
            player.place(card);
        }
    }

    public void restore() throws EmptyDeckException {
        if (discardPile.isEmpty()) {
            throw new EmptyDeckException("Discard pile is empty");
        }
        this.mainDeck.merge(discardPile);
    }

    private boolean canPlay() {
        return mainDeck.hasEnough(3) && specialDeck.hasEnough(1);
    }

    private Card pickCard(){
        if (turnCounter % 4 == 0) {
            return specialDeck.draw();
        }
        return mainDeck.draw();
    }
}
