package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeckGenerator {

    private static final List<Card> cards = Arrays.asList(
            new Card("Spitfire", 25, AttackType.HEAT),
            new Card("Blindside", 30, AttackType.ENERGY),
            new Card("Freeze Fire", 40, AttackType.ICE),
            new Card("Blazing Fury", 80, AttackType.FURY),
            new Card("Firestorm", 24, AttackType.HEAT),
            new Card("Shield of Steel", 24, AttackType.PROTECTOR),
            new Card("Icicle", 10, AttackType.ICE),
            new Card("Iceberg", 15, AttackType.ICE),
            new Card("Showdown", 60, AttackType.FURY),
            new Card("Blindside", 30, AttackType.ENERGY),
            new Card("Icicle", 10, AttackType.ICE),
            new Card("Firestorm", 24, AttackType.HEAT),
            new Card("Shutdown", 100, AttackType.FURY),
            new Card("Blazing Fury", 80, AttackType.FURY),
            new Card("Blindside", 30, AttackType.ENERGY),
            new Card("Icicle", 10, AttackType.ICE),
            new Card("Cloak of Darkness", 24, AttackType.PROTECTOR),
            new Card("Firestorm", 24, AttackType.HEAT),
            new Card("Shutdown", 100, AttackType.FURY),
            new Card("Blazing Fury", 80, AttackType.FURY),
            new Card("Blindside", 30, AttackType.ENERGY),
            new Card("Icicle", 10, AttackType.ICE)
    );

    public static List<Card> generate(int amount) {
        return cards.subList(0, Math.min(amount, cards.size())).stream().map(Card::copy).collect(Collectors.toCollection(ArrayList::new));
    }
}
