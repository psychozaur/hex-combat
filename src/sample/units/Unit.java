package sample.units;

import javafx.scene.paint.Color;
import sample.hexagons.Hexagon;
import sample.hexagons.IHexagonClickedCallback;

import java.util.List;
import java.util.Optional;

public class Unit {

    private final String name;
    private final int minDmg;
    private final int maxDmg;
    private final int totalHp;
    private final int movementRangeInHexes;
    private boolean isSelected;
    private Hexagon currentHex;
    private Color color;

    public Unit(String name, int minDmg, int maxDmg, int totalHp, int movementRangeInHexes, Hexagon hex, Color color) {
        this.name = name;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.totalHp = totalHp;
        this.movementRangeInHexes = movementRangeInHexes;
        this.isSelected = false;
        this.currentHex = hex;
        this.color = color;
        currentHex.setBackgroundColor(color);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public int getTotalHp() {
        return totalHp;
    }

    public int getMovementRangeInHexes() {
        return movementRangeInHexes;
    }

    public Hexagon getCurrentHex() {
        return currentHex;
    }

    public Color getColor() {
        return color;
    }

    public IHexagonClickedCallback selectAndShowMovementRange(Color selectionColor, List<Unit> unitList) {
        return hexagon -> {
            if (this.isSelected){

                this.setSelected(false);
            } else {
                if (this.getCurrentHex().getQ() == hexagon.getQ() &&
                        this.getCurrentHex().getR() == hexagon.getR()) {
                    hexagon.setFill(selectionColor);
                    this.setSelected(true);
                    hexagon.getVisibleHexes(movementRangeInHexes).forEach(hexagon1 -> {
                        if (hexagon1.getMaybeUnitOwner(unitList).equals(Optional.empty()))
                            hexagon1.setFill(Color.LIGHTGRAY);
                    });
                }
            }
        };
    }

    public void move(){
        //TODO
        //if click is within movement range, change current hex to hex clicked
//        currentHex = ???

        //reset colours to transparent and unit colours
    }

}
