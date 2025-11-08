package VisitorPatterns;

import Game.Card;

public interface CardVisitor {
    void visit(Card card);
}
