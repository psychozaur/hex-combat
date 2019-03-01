package sample.hexagons;

import javafx.scene.paint.Color;

public interface IHexagonCreator {
    void createHexagon(int q, int r, Color imagePixelColor, HexagonMap map);
}
