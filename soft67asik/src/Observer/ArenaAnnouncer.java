package Observer;

public class ArenaAnnouncer implements CardObserver {
    @Override
    public void onEvent(String event) {
        System.out.println(" [Announcer] " + event);
    }
}
