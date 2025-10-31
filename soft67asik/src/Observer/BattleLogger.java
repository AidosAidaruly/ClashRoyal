package Observer;

public class BattleLogger implements CardObserver {
    @Override
    public void onEvent(String event) {
        System.out.println(" [LOG] " + event);
    }
}
