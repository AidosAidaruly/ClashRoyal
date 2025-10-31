public class ClashArena {
    private static ClashArena instance;

    private ClashArena() {
        System.out.println("Arena is ready for battle!");
    }
    public static ClashArena getInstance() {
        if (instance == null) {
            instance = new ClashArena();
        }
        return instance;
    }
    public void startBattle(String card1, String card2) {
        System.out.println("Battle starts between " + card1 + " and " + card2);
    }
}
