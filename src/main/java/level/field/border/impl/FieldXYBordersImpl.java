package level.field.border.impl;

import level.field.border.FieldBorders;
import java.util.Objects;

public class FieldXYBordersImpl implements FieldBorders {

    private boolean northBorder;
    private boolean westBorder;
    private boolean eastBorder;
    private boolean southBorder;

    public boolean isNorthBorder() {
        return northBorder;
    }

    public void setNorthBorder(boolean northBorder) {
        this.northBorder = northBorder;
    }

    public boolean isWestBorder() {
        return westBorder;
    }

    public void setWestBorder(boolean westBorder) {
        this.westBorder = westBorder;
    }

    public boolean isEastBorder() {
        return eastBorder;
    }

    public void setEastBorder(boolean eastBorder) {
        this.eastBorder = eastBorder;
    }

    public boolean isSouthBorder() {
        return southBorder;
    }

    public void setSouthBorder(boolean southBorder) {
        this.southBorder = southBorder;
    }

    @Override
    public String drawBorders() {
        return "Borders_XY=={" + "N:" + this.isNorthBorder() + " E:" + this.isEastBorder() + " S:" + this.isSouthBorder() + " W:" + this.isWestBorder() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldXYBordersImpl that = (FieldXYBordersImpl) o;
        return northBorder == that.northBorder &&
                westBorder == that.westBorder &&
                eastBorder == that.eastBorder &&
                southBorder == that.southBorder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(northBorder, westBorder, eastBorder, southBorder);
    }
}
