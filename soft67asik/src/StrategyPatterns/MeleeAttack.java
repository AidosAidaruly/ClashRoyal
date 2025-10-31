package StrategyPatterns;

public class MeleeAttack implements AttackStrategy {
    @Override
    public void attack(String attacker, String target) {
        System.out.print(attacker + " smashes " + target + " with a heavy melee attack! ");
    }

    @Override
    public double getDamageMultiplier() {
        return 1.1;
    }
}