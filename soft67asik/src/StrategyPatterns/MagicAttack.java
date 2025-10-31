package StrategyPatterns;

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack(String attacker, String target) {
        System.out.print(attacker + " zaps " + target + " with a magical beam! ");
    }

    @Override
    public double getDamageMultiplier() {
        return 0.9; //
    }
}