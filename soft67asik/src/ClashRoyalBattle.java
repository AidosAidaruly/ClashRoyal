import Game.Card;
import Observer.ArenaAnnouncer;
import Observer.BattleLogger;
import StrategyPatterns.RangedAttack;
import java.util.Scanner;

public class ClashRoyalBattle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClashArena arena = ClashArena.getInstance();

        BattleLogger logger = new BattleLogger();
        ArenaAnnouncer announcer = new ArenaAnnouncer();

        System.out.println("AVAILABLE CARDS:");
        System.out.println("MegaKnight, IceWizard, Musketeers, PEKKA, Witch, Executioner, GiantSkeleton, ElectroWizard, MagicArcher");


        Card player1Card;
        Card player2Card;
        try {
            System.out.print("\nSelect a card for Player 1: ");
            String card1Name = scanner.nextLine().trim();
            player1Card = CardFactory.createCard(card1Name);

            System.out.print("Select a card for Player 2: ");
            String card2Name = scanner.nextLine().trim();
            player2Card = CardFactory.createCard(card2Name);
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating map: " + e.getMessage());
            scanner.close();
            return;
        }


        player1Card.addObserver(logger);
        player1Card.addObserver(announcer);
        player2Card.addObserver(logger);
        player2Card.addObserver(announcer);

        arena.startBattle(player1Card.getName(), player2Card.getName());

        System.out.println("\n The Battle Begins: " + player1Card.getName() + " vs " + player2Card.getName() + " ---");

        runInteractiveBattle(scanner, player1Card, player2Card);

        scanner.close();
    }


    private static void runInteractiveBattle(Scanner scanner, Card card1, Card card2) {
        Card attacker = card1;
        Card defender = card2;
        int turn = 1;

        while (card1.getHealth() > 0 && card2.getHealth() > 0) {
            System.out.println("\n*** Progress " + turn + " ***");
            System.out.println("HP: " + card1.getName() + "=" + card1.getHealth() + " | " + card2.getName() + "=" + card2.getHealth());
            System.out.println("Current attacker: " + attacker.getName());

            System.out.println("[1] Attack\n[2] Change strategy \n[3] Complete the simulation");
            System.out.print("Select action: ");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "1":
                    attacker.attack(defender);
                    break;
                case "2":

                    System.out.println("Change of strategy: " + attacker.getName() + " switches to RangedAttack! ");
                    attacker.setAttackStrategy(new RangedAttack());
                    attacker.attack(defender);
                    break;
                case "3":
                    System.out.println("The simulation was completed by the user.");
                    return;
                default:
                    System.out.println("Incorrect action. Move missed.");
                    break;
            }


            Card temp = attacker;
            attacker = defender;
            defender = temp;
            turn++;
        }

        System.out.println("\n The fight is over ");
        String winner = card1.getHealth() > 0 ? card1.getName() : card2.getName();
        System.out.println("Winner: " + winner + "!");
    }
}