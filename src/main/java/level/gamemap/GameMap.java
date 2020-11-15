package level.gamemap;

import level.field.Field;
import level.field.position.Position;

import java.util.Map;

public interface GameMap {
    String printMap();
    Map<Position, Field> getFields();
}
