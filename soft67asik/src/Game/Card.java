package Game;

import StrategyPatterns.AttackStrategy;
import Observer.*;
import StatePatterns.BasicState;
import StatePatterns.CardState;

import java.util.*;

public class Card {
    private String name;
    private int health;
    private int baseDamage;
    private AttackStrategy attackStrategy;
    private List<CardObserver> observers = new ArrayList<>();
    private AttackStrategy strategy;

    private CardState currentState;
    private int attackCount = 0;



    public Card(String name, int health, AttackStrategy attackStrategy, int baseDamage) {
        this.name = name;
        this.health = health;
        this.attackStrategy = attackStrategy;
        this.baseDamage = baseDamage;
        this.currentState = new BasicState();
    }


    public void changeState(CardState newState) {
        this.currentState = newState;
        this.attackCount = 0;
        notifyObservers(name + " went into the state: " + newState.status());
    }

    public void incrementAttackCount() {
        this.attackCount++;
    }


    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
        notifyObservers(name + " switched attack strategy!");
    }

    public void attack(Card target) {
        currentState.handleAttack(this, target, this.baseDamage);
        notifyObservers(name + " attacked " + target.name + " (State: " + currentState.status() + ")");
    }


    public void takeDamage(int damage) {

        int initialHealth = health;
        currentState.handleTakeDamage(this, damage);

        int damageTaken = initialHealth - health;

        notifyObservers(name + " received " + damageTaken + " damage. HP = " + health);

        if (health <= 0) {
            notifyObservers(name + " was defeated!");


        }
    }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public String getName() { return name; }
    public AttackStrategy getAttackStrategy() { return attackStrategy; }
    public int getAttackCount() { return attackCount; }


    public void addObserver(CardObserver o) { observers.add(o); }
    public void removeObserver(CardObserver o) { observers.remove(o); }

    private void notifyObservers(String event) {
        for (CardObserver o : observers) {
            o.onEvent(event);
        }
    }






}