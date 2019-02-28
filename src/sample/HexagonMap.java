package sample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HexagonMap {

    private int height;
    private int width;
    private Map hexMap;

    private double initialCenterX;
    private double initialCenterY;
    private double radius;

    private Set<Point> pointsThusFar;

    private Axial firstKey;

    // initial centerPos [50.0, 50.0], radius: 25.0
    // 6x6 rectangle
    // or 6x6 rhombus (easier)

    public HexagonMap(int height, int width, double initialCenterX, double initialCenterY, double radius) {
        this.height = height;
        this.width = width;
        this.hexMap = new HashMap<Axial,Hexagon>();

        this.initialCenterX = initialCenterX;
        this.initialCenterY = initialCenterY;
        this.radius = radius;

        pointsThusFar = new HashSet<>();

        this.firstKey = new Axial(new int[]{0,0});

        populateHexagonMap();
    }

    public Map getHexMap() {
        return hexMap;
    }

    public Set getKeySet() {
        return hexMap.keySet();
    }

    public Axial getFirstKey() {
        return firstKey;
    }

    private void putRowOfHexToMap(int r) {
        for (int q = 0; q < width; q++){
            hexMap.put(newKey(q,r), new Hexagon(initialCenterX + (r * radius * Math.sqrt(3) / 2.0) + (q * radius * Math.sqrt(3)),
                    initialCenterY + (r * radius * Math.sqrt(3)),
                    radius,
                    pointsThusFar));
        }
    }

    private void populateHexagonMap() {
            for (int r = 0; r < height; r++){
                putRowOfHexToMap(r);
                System.out.println(pointsThusFar.size());
            }
        }
//        hexMap.put(new Axial(new int[]{0,0}),new Hexagon(initialCenterX,initialCenterY,radius));
//        hexMap.put(new Axial(new int[]{0,1}),new Hexagon(initialCenterX + (radius * Math.sqrt(3) / 2.0),initialCenterY + (radius * Math.sqrt(3)),radius));
//        hexMap.put(new Axial(new int[]{1,0}),new Hexagon(initialCenterX + (radius * Math.sqrt(3)),initialCenterY,radius));
//        hexMap.put(new Axial(new int[]{-1,2}),new Hexagon(initialCenterX,initialCenterY + (2 * radius * Math.sqrt(3)),radius));


    public Axial newKey(int q, int r){
        return new Axial(new int[]{q,r});
    }

    public Hexagon getHexagonFromMap(int q, int r){
        return (Hexagon) this.hexMap.get(newKey(q,r));
    }
}
