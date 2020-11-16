package level.gamemap.impl;

import level.field.Field;
import level.field.background.BackgroundTypes;
import level.field.border.FieldBorders;
import level.field.border.impl.FieldXYBordersImpl;
import level.field.impl.FieldXYImpl;
import level.field.position.Position;
import level.field.position.impl.PositionXYImpl;
import level.gamemap.GameMap;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * An object implements GameMap interface.
 * An object reads the property file during construction faze to init its fields.
 */
public class GameMapFromFileImpl implements GameMap {

    private Map<Position, Field> gameMap;

    public GameMapFromFileImpl(String mapFilePath) throws Exception {
        this.gameMap = this.readFileAndInitMap(mapFilePath);
    }

    public Map<Position, Field> getGameMap() {
        return gameMap;
    }

    private Map<Position, Field> readFileAndInitMap(String filePath) throws Exception {
        Map<Position, Field> ret = new HashMap<>();
        File mapFile = new File(filePath);
        if (mapFile.isDirectory() || !mapFile.exists()) {
            throw new FileNotFoundException("The file of the MAP is a directory or does not exist.");
        } else {
            if (mapFile.length() <= 0) {
                throw new Exception("The MAP file has zero length.");
            }
            int lineCount = this.lineCount(mapFile);
            FileReader fr = new FileReader(mapFile);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int x = 0;
            int y = 0;
            while (line != null) {
                System.out.println(line);
                int lLength = line.length();
                for (char c : line.toCharArray()) {
                    if (c != ' ' && c != '#') {
                        throw new Exception("There is wrong symbol with position(x:" + x + " y:" + y + ")");
                    } else {
                        Position position = new PositionXYImpl(x, y);
                        FieldBorders borders = this.resolveBorders(lLength, lineCount, x, y);
                        BackgroundTypes bg = BackgroundTypes.get(String.valueOf(c));
                        Field field = new FieldXYImpl(position, borders, bg);
                        ret.put(position, field);
                    }
                    x++;
                }
                line = reader.readLine();
                x = 0;
                y++;
            }
            reader.close();
        }

        return ret;
    }

    private int lineCount(File mapFile) throws IOException {
        int ret = 0;
        FileReader fr = new FileReader(mapFile);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (reader.readLine() != null) {
            ret++;
        }
        reader.close();
        return ret;
    }

    private FieldBorders resolveBorders(int lLength, int lineCount, int x, int y) {
        FieldXYBordersImpl ret = new FieldXYBordersImpl();
        boolean n = false;
        boolean e = false;
        boolean s = false;
        boolean w = false;

        if (y == 0) {
            n = true;
        }
        if (x == 0) {
            w = true;
        }
        if (x == lLength - 1) {
            e = true;
        }
        if (y == lineCount) {
            s = true;
        }

        ret.setNorthBorder(n);
        ret.setEastBorder(e);
        ret.setSouthBorder(s);
        ret.setWestBorder(w);

        return ret;
    }

    @Override
    public Map<Position, Field> getFields() {
        return this.getGameMap();
    }
}
