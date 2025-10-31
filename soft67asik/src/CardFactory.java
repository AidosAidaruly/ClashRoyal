import Game.Card;
import StrategyPatterns.MagicAttack;
import StrategyPatterns.MeleeAttack;
import StrategyPatterns.RangedAttack;

public class CardFactory {
    public static Card createCard(String type) {
        switch (type) {
            case "MegaKnight":
                return new CardBuilder("MegaKnight")
                        .withHealth(150)
                        .withBaseDamage(30)
                        .withAttackStrategy(new MeleeAttack())
                        .build();
                case "IceWizard":
                    return new CardBuilder("IceWizard")
                            .withHealth(75)
                            .withBaseDamage(15)
                            .withAttackStrategy(new MeleeAttack())
                            .build();
            case "Musketeers":
                return new CardBuilder("Musketeer")
                        .withHealth(85)
                        .withBaseDamage(20)
                        .withAttackStrategy(new RangedAttack())
                        .build();
            case "PEKKA":
                return new CardBuilder("PEKKA")
                        .withHealth(180)
                        .withBaseDamage(40)
                        .withAttackStrategy(new MeleeAttack())
                        .build();
                case "Witch":
                    return new CardBuilder("Witch")
                            .withHealth(90)
                            .withBaseDamage(20)
                            .withAttackStrategy(new MagicAttack())
                            .build();
            case "Executioner":
                return new CardBuilder("Executioner")
                        .withHealth(105)
                        .withBaseDamage(25)
                        .withAttackStrategy(new RangedAttack())
                        .build();

            case "GiantSkeleton":
                return new CardBuilder("GiantSkeleton")
                        .withHealth(150)
                        .withBaseDamage(25)
                        .withAttackStrategy(new MeleeAttack())
                        .build();

            case "ElectroWizard":
                return new CardBuilder("ElectroWizard")
                        .withHealth(80)
                        .withBaseDamage(20)
                        .withAttackStrategy(new MagicAttack())
                        .build();

            case "MagicArcher":
                return new CardBuilder("MagicArcher")
                        .withHealth(70)
                        .withBaseDamage(15)
                        .withAttackStrategy(new RangedAttack())
                        .build();

            default:
                throw new IllegalArgumentException("Unknown card type");
        }
    }

}
