package VisitorPatterns;

import Game.Card;

public class CardUpgradeVisitor implements CardVisitor {
    @Override
    public void visit(Card card) {
        card.setHealth(card.getHealth() + 20);
        System.out.println("✨ " + card.getName() + " upgraded! New HP: " + card.getHealth());
    }
}
