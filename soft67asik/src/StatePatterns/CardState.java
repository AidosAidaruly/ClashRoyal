package StatePatterns;

public interface CardState {

    void handleAttack(Game.Card card, Game.Card target, int baseDamage);
    void handleTakeDamage(Game.Card card, int damage);
    String status();
}