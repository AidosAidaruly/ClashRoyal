package StrategyPatterns;

public interface AttackStrategy {
    void attack(String attacker, String target);

    double getDamageMultiplier();

}
