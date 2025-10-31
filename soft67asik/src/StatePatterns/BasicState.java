package StatePatterns;
import Game.Card;


public class BasicState implements CardState {

    @Override
    public void handleAttack(Card card, Card target, int baseDamage) {


        double strategyMultiplier = card.getAttackStrategy().getDamageMultiplier();


        int finalDamage = (int) (baseDamage * strategyMultiplier);
        card.getAttackStrategy().attack(card.getName(), target.getName());
        target.takeDamage(finalDamage);
        card.incrementAttackCount();
        if (card.getAttackCount() >= 3) {
            System.out.println("---" + card.getName() + " completed! ---" );
            card.changeState(new EvolutionState());
        }
    }

    @Override
    public void handleTakeDamage(Card card, int damage) {
        card.setHealth(card.getHealth() - damage);
    }

    @Override
    public String status() {
        return "Basic";
    }
}