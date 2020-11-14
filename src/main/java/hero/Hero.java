package hero;

import level.field.Field;
import movements.MovementTypes;

public interface Hero {
    Field move(MovementTypes mv);
}
