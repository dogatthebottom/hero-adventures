package level.field;

/**
 * The interface is used to draw Background, borders and field position of game map field
 */
public interface Field {
    String drawFieldBackground();

    String drawFieldBorders();

    String printFieldPosition();

}
