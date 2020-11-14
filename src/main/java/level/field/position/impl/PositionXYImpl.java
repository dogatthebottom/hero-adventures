package level.field.position.impl;

import level.field.position.Position;
import java.util.Objects;

public class PositionXYImpl implements Position {

    private final int xCoordinate;
    private final int yCoordinate;

    public PositionXYImpl(int xCoordinate, int yCoordinate) throws Exception {
        if (xCoordinate < 0 || yCoordinate < 0) {
            throw new Exception("X-coordinate or Y-coordinate could not be less than zero");
        }else {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }
    }

    @Override
    public String printPosition() {
        return "XY_Coordinates=={" + xCoordinate + ":" + yCoordinate + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionXYImpl that = (PositionXYImpl) o;
        return xCoordinate == that.xCoordinate &&
                yCoordinate == that.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
