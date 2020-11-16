package level.gamemap;

import level.field.Field;
import level.field.position.Position;

import java.util.Map;

/**
 * An Object contains java.util.Map of map fields
 */
public interface GameMap {
    /**
     *
     * @return the java.util.Map of game map fields
     */
    Map<Position, Field> getFields();
}
