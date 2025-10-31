package StatePatterns;

import Game.Card;

public class EvolutionState implements CardState {
    private static final double EVO_MULTIPLIER = 1.5;
    private static final int LOW_HP_THRESHOLD = 20;

    @Override
    public void handleAttack(Card card, Card target, int baseDamage) {
        double strategyMultiplier = card.getAttackStrategy().getDamageMultiplier();
        int finalDamage = (int) (baseDamage * EVO_MULTIPLIER * strategyMultiplier);

        System.out.println(" EVO BOOST " + card.getName() + " deals increased damage: " + finalDamage);
        card.getAttackStrategy().attack(card.getName(), target.getName());
        target.takeDamage(finalDamage);
    }

    @Override
    public void handleTakeDamage(Card card, int damage) {
        int effectiveDamage = (int) (damage * 0.9);
        card.setHealth(card.getHealth() - effectiveDamage);

        if (card.getHealth() <= LOW_HP_THRESHOLD) {
            System.out.println("---" + card.getName() + " TOO WOUNDED! Evolution Complete. ---");
            card.changeState(new BasicState());
        }
    }

    @Override
    public String status(){
        return "Evolution";
    }
}