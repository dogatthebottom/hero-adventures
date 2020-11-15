package hero;

import movements.MovementTypes;

public interface Hero {
    void move(MovementTypes mv) throws Exception;

    void play() throws Exception;

    String printRespawnPosition();

    String printCurrentPosition();

    void printRoute();
}
