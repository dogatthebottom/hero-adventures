package movements;

import java.util.HashMap;
import java.util.Map;

public enum MovementTypes {

    NORTH("N"),
    SOUTH("S"),
    WEST("O"),
    EAST("E");

    private String movement;

    MovementTypes(String movement) {
        this.movement = movement;
    }

    public String getMovement() {
        return movement;
    }

    private static final Map<String, MovementTypes> lookup = new HashMap<>();

    static {
        for (MovementTypes mt : MovementTypes.values()) {
            lookup.put(mt.getMovement(), mt);
        }
    }

    public static MovementTypes get(String mt) {
        return lookup.get(mt);
    }
}
