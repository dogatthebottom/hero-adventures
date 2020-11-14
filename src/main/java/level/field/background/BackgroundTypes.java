package level.field.background;

import java.util.HashMap;
import java.util.Map;

public enum BackgroundTypes {

    SPACE(" "),
    FOREST("#");

    public String getBackgroundType() {
        return backgroundType;
    }

    private String backgroundType;

    BackgroundTypes(String backgroundType) {
        this.backgroundType = backgroundType;
    }

    private static final Map<String, BackgroundTypes> lookup = new HashMap<>();

    static {
        for (BackgroundTypes bt : BackgroundTypes.values()) {
            lookup.put(bt.getBackgroundType(), bt);
        }
    }

    public static BackgroundTypes get(String bt) {
        return lookup.get(bt);
    }


}
