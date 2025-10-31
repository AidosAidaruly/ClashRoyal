package StrategyPatterns;

public class RangedAttack implements AttackStrategy {
    @Override
    public void attack(String attacker, String target) {
        System.out.print(attacker + " shoots " + target + " from a distance! ");
    }

    @Override
    public double getDamageMultiplier() {
        return 1.0;
    }
}