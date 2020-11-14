import level.gamemap.GameMap;
import level.gamemap.impl.GameMapFromFileImpl;

import java.util.Scanner;
import java.util.logging.Logger;

public class Game {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Game.class.getName());
        try {
            log.info("--Start Game--");
            log.info("Enter file path of MAP:");
            Scanner scanner = new Scanner(System.in);
            String mapFilePath = scanner.nextLine();
            GameMap gameMap = new GameMapFromFileImpl(mapFilePath);
            log.info(gameMap.printMap());
            log.info("Your MAP has been loaded from:" + mapFilePath + " successfully");
            log.info("Enter file path of ROUTE:");
            String routeFilePath = scanner.nextLine();
            log.info("Your ROUTE has been loaded from:" + mapFilePath + " successfully");
        } catch (Exception e) {
            log.warning("Error:" + e.getMessage());
            log.warning("The game was finished with the error");
        }

        //gameMap.printMap();
    }
}
