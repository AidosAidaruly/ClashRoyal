package VisitorPatterns;

import Game.Card;

public class CardInfoVisitor implements CardVisitor {
    @Override
    public void visit(Card card) {
        System.out.println("Card Info:");
        System.out.println("Name: " + card.getName());
        System.out.println("Health: " + card.getHealth());
        System.out.println("Attack Count: " + card.getAttackCount());
        System.out.println("Current State: " + card.getClass().getSimpleName());
        System.out.println("-----------------------------------");
    }
}
