import Game.Card;
import StrategyPatterns.AttackStrategy;

public class CardBuilder {
    private String name;
    private int health;
    private int baseDamage;
    private AttackStrategy attackStrategy;

    public CardBuilder(String name) {
        this.name = name;
    }
    public CardBuilder withHealth(int health) {
        this.health = health;
        return this;
    }
    public CardBuilder withBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
        return this;
    }

    public CardBuilder withAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
        return this;
    }

    public Card build() {
        if (attackStrategy == null) {
            throw new IllegalStateException("Attack Strategy must be set.");
        }
        return new Card(name, health, attackStrategy, baseDamage);
    }
}
