package hero.impl;

import hero.Hero;
import level.field.Field;
import level.field.border.impl.FieldXYBordersImpl;
import level.field.impl.FieldXYImpl;
import level.field.position.Position;
import level.field.position.impl.PositionXYImpl;
import level.gamemap.GameMap;
import movements.MovementTypes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HeroFromFileImpl implements Hero {
    private Field respawnField;
    private Field currentField;
    private List<MovementTypes> route = new ArrayList<MovementTypes>();
    private GameMap gameMap;

    public HeroFromFileImpl(GameMap gameMap, String heroFilePath) throws Exception {
        this.gameMap = gameMap;
        this.readFileAndInitHero(heroFilePath);
    }

    public Field getRespawnField() {
        return respawnField;
    }

    public void setRespawnField(Field respawnField) {
        this.respawnField = respawnField;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public List<MovementTypes> getRoute() {
        return route;
    }

    public void setRoute(List<MovementTypes> route) {
        this.route = route;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    @Override
    public void move(MovementTypes mv) throws Exception {
        FieldXYBordersImpl fieldXYBorders = (FieldXYBordersImpl) ((FieldXYImpl) this.currentField).getBorders();
        if (fieldXYBorders == null) {
            throw new Exception("Error: Field Borders is null");
        } else {
            switch (mv) {
                case NORTH:
                    if (fieldXYBorders.isNorthBorder()) {
                        System.out.println("You LOOSE!");
                        System.out.println(this.printCurrentPosition());
                        throw new Exception("You can not go to the " + mv + " cause FIELD has " + mv + " border.");
                    } else {
                        checkNextFieldAndGo(mv);
                    }
                    break;
                case SOUTH:
                    if (fieldXYBorders.isSouthBorder()) {
                        System.out.println("You LOOSE!");
                        System.out.println(this.printCurrentPosition());
                        throw new Exception("You can not go to the " + mv + " cause FIELD has " + mv + " border.");
                    } else {
                        checkNextFieldAndGo(mv);
                    }
                    break;
                case EAST:
                    if (fieldXYBorders.isEastBorder()) {
                        System.out.println("You LOOSE!");
                        System.out.println(this.printCurrentPosition());
                        throw new Exception("You can not go to the " + mv + " cause FIELD has " + mv + " border.");
                    } else {
                        checkNextFieldAndGo(mv);
                    }
                    break;
                case WEST:
                    if (fieldXYBorders.isWestBorder()) {
                        System.out.println("You LOOSE!");
                        System.out.println(this.printCurrentPosition());
                        throw new Exception("You can not go to the " + mv + " cause FIELD has " + mv + " border.");
                    } else {
                        checkNextFieldAndGo(mv);
                    }
                    break;
            }
        }
    }

    private void checkNextFieldAndGo(MovementTypes mv) throws Exception {
        FieldXYImpl currentFieldXY = (FieldXYImpl) this.getCurrentField();
        PositionXYImpl currentPositionXY = (PositionXYImpl) currentFieldXY.getPosition();
        Field checkField;
        switch (mv) {
            case NORTH:
                checkField = this.getGameMap().getFields().get(new PositionXYImpl(currentPositionXY.getXCoordinate(), currentPositionXY.getYCoordinate() - 1));
                if (checkField.drawFieldBackground().equals("#")) {
                    System.out.println("You LOOSE!");
                    System.out.println("END GAME POSITION=="+currentFieldXY.printFieldPosition());
                    throw new Exception("You can not go to next field because of there is FORREST field");
                } else {
                    this.setCurrentField(checkField);
                }
                break;
            case EAST:
                checkField = this.getGameMap().getFields().get(new PositionXYImpl(currentPositionXY.getXCoordinate() + 1, currentPositionXY.getYCoordinate()));
                if (checkField.drawFieldBackground().equals("#")) {
                    System.out.println("You LOOSE!");
                    System.out.println("END GAME POSITION=="+currentFieldXY.printFieldPosition());
                    throw new Exception("You can not go to next field because of there is FORREST field");
                } else {
                    this.setCurrentField(checkField);
                }
                break;
            case SOUTH:
                checkField = this.getGameMap().getFields().get(new PositionXYImpl(currentPositionXY.getXCoordinate(), currentPositionXY.getYCoordinate() + 1));
                if (checkField.drawFieldBackground().equals("#")) {
                    System.out.println("You LOOSE!");
                    System.out.println("END GAME POSITION=="+currentFieldXY.printFieldPosition());
                    throw new Exception("You can not go to next field because of there is FORREST field");
                } else {
                    this.setCurrentField(checkField);
                }
                break;
            case WEST:
                checkField = this.getGameMap().getFields().get(new PositionXYImpl(currentPositionXY.getXCoordinate() - 1, currentPositionXY.getYCoordinate()));
                if (checkField.drawFieldBackground().equals("#")) {
                    System.out.println("You LOOSE!");
                    System.out.println(currentFieldXY.printFieldPosition());
                    throw new Exception("You can not go to next field because of there is FORREST field");
                } else {
                    this.setCurrentField(checkField);
                }
                break;


        }
    }

    @Override
    public void play() throws Exception {
        for (MovementTypes mt : this.getRoute()) {
            move(mt);
        }
    }

    @Override
    public String printRespawnPosition() {
        return this.getRespawnField().printFieldPosition();
    }

    @Override
    public String printCurrentPosition() {
        return this.getCurrentField().printFieldPosition();
    }

    @Override
    public void printRoute() {
        this.getRoute().forEach(e -> System.out.println(e));
    }

    private void readFileAndInitHero(String heroFilePath) throws Exception {
        File heroFile = new File(heroFilePath);
        if (heroFile.isDirectory() || !heroFile.exists()) {
            throw new FileNotFoundException("The file of the HERO is a directory or does not exist.");
        } else {
            if (heroFile.length() <= 0) {
                throw new Exception("The HERO file has zero length.");
            }
            FileReader fr = new FileReader(heroFile);
            BufferedReader reader = new BufferedReader(fr);
            String lineCoordinates = reader.readLine();
            if (lineCoordinates == null || lineCoordinates.length() == 0) {
                throw new Exception("The COORDINATES line is null or has zero length");
            } else {
                System.out.println("Start coordinates=="+lineCoordinates);
                String[] coordinates = lineCoordinates.split(",");
                if (coordinates.length != 2) {
                    throw new Exception("Wrong coordinates line format.");
                } else {
                    Position position = new PositionXYImpl(Integer.valueOf(coordinates[0].trim()), Integer.valueOf(coordinates[1].trim()));
                    Field start = gameMap.getFields().get(position);
                    if (start == null) {
                        throw new Exception("Wrong the start field. The start field is out of the GAME MAP.");
                    } else {
                        this.setRespawnField(start);
                        if (this.getRespawnField().drawFieldBackground().equals("#")){
                            throw new Exception("Wrong ths start field. The start field is the FORREST");
                        }
                        this.setCurrentField(start);
                    }
                }
            }
            String lineRoute = reader.readLine();
            if (lineRoute == null || lineRoute.length() == 0) {
                throw new Exception("The ROUTE line is null or has zero length");
            } else {
                System.out.println("Route=="+lineRoute);
                for (char c : lineRoute.trim().toCharArray()) {
                    MovementTypes mt = MovementTypes.get(String.valueOf(c));
                    if (mt != null) {
                        this.route.add(mt);
                    } else {
                        throw new Exception("The ROUTE line has wrong format");
                    }
                }
            }
            reader.close();
        }
    }

}
