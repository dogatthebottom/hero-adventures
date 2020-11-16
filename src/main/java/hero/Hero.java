package hero;

import movements.MovementTypes;

/**
 * Hero is a interface of player of the game
 */
public interface Hero {
    void move(MovementTypes mv) throws Exception;

    void play() throws Exception;

    String printRespawnPosition();

    String printCurrentPosition();

    void printRoute();
}
