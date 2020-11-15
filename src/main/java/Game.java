import hero.Hero;
import hero.impl.HeroFromFileImpl;
import level.field.position.impl.PositionXYImpl;
import level.gamemap.GameMap;
import level.gamemap.impl.GameMapFromFileImpl;

import java.util.Scanner;
import java.util.logging.Logger;

public class Game {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Game.class.getName());
        String finalPosition = "";
        try {
            log.info("--Start Game--");
            log.info("Enter file path of MAP:");
            Scanner scanner = new Scanner(System.in);
            String mapFilePath = scanner.nextLine();
            GameMap gameMap = new GameMapFromFileImpl(mapFilePath);
            log.info("Your MAP has been loaded from:" + mapFilePath + " successfully");
            log.info("Enter file path of HERO:");
            String heroFilePath = scanner.nextLine();
            Hero hero = new HeroFromFileImpl(gameMap, heroFilePath);
            log.info("Your HERO has been loaded from:" + heroFilePath + " successfully");
            hero.play();
            log.info("You WIN!");
            log.info(hero.printCurrentPosition());
        } catch (Exception e) {
            log.warning("Error:" + e.getMessage());
        }

        //gameMap.printMap();
    }
}
