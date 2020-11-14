package level.field.impl;

import level.field.background.BackgroundTypes;
import level.field.border.FieldBorders;
import level.field.border.impl.FieldXYBordersImpl;
import level.field.Field;
import level.field.position.Position;
import level.field.position.impl.PositionXYImpl;

import java.util.Objects;

public class FieldXYImpl implements Field {

    private final Position position;
    private final FieldBorders borders;
    private final BackgroundTypes background;

    public FieldXYImpl(Position position, FieldBorders borders, BackgroundTypes background) throws NullPointerException {
        this.position = Objects.requireNonNull(position,"Position could not be NULL");
        this.borders = Objects.requireNonNull(borders,"Borders could not be NULL");
        this.background = Objects.requireNonNull(background,"Background could not be NULL");
    }

    public Position getPosition() {
        return position;
    }

    public FieldBorders getBorders() {
        return borders;
    }

    public BackgroundTypes getBackground() {
        return background;
    }

    @Override
    public String drawFieldBackground() {
        return this.getBackground().getBackgroundType();
    }

    @Override
    public String drawFieldBorders() {
        return this.getBorders().drawBorders();
    }

    @Override
    public String printFieldPosition() {
        return this.getPosition().printPosition();
    }
}
