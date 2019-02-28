package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hexagon extends Path {

    private double centerX;
    private double centerY;
    private double radius;
    private Hexagon instance;
    private List<Point> points;

    private Set<Point> pointsThusFar;

    public Set<Point> getPointsThusFar() {
        return pointsThusFar;
    }

    public void setPointsThusFar(Set<Point> pointsThusFar) {
        this.pointsThusFar = pointsThusFar;
    }

    public Hexagon(double centerX, double centerY, double radius, Set<Point> existingPoints) {
        super();

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
//        this.adjacentVertices = new ArrayList<>();
        setPointsThusFar(existingPoints);
        instance = this;

        setStyle();

        points = getPointyHexCorners();

        MoveTo moveTo = null;
        LineTo line = null;

        for (Point p : points){
            if (p.equals(points.get(0))){
                moveTo = new MoveTo(p.x,p.y);
                this.getPointsThusFar().add(p);
                this.getElements().add(moveTo);
                System.out.println(p.x + "; " + p.y + " ---- 0 ");
            } else{
                line = new LineTo(p.x, p.y);
                this.getPointsThusFar().add(p);
                this.getElements().add(line);
                System.out.println(p.x + "; " + p.y);
            }
        }
        line = new LineTo(moveTo.getX(),moveTo.getY());
        this.getElements().add(line);

//        double triangleHeight = (Math.round(radius / 2.0)) * Math.sqrt(3);
//        MoveTo start = new MoveTo(centerX,centerY - radius);
//        LineTo line1 = new LineTo(centerX + triangleHeight, centerY - Math.round(radius / 2.0));
//        LineTo line2 = new LineTo(centerX + triangleHeight, centerY + Math.round(radius / 2.0));
//        LineTo line3 = new LineTo(centerX, centerY + radius);
//        LineTo line4 = new LineTo(centerX - triangleHeight, centerY + Math.round(radius / 2.0));
//        LineTo line5 = new LineTo(centerX - triangleHeight, centerY - Math.round(radius / 2.0));
//        LineTo line6 = new LineTo(start.getX(),start.getY());
//
//        this.getElements().add(start);
//        this.getElements().addAll(line1, line2, line3, line4, line5, line6);

        setAndAddMouseEventHandler(Color.YELLOWGREEN);
    }

    private void drawNewLines(List<Point> adjacentVertices){

        int size = adjacentVertices.size();
        int linesRemaining = 6 - size;
        double triangleHeight = (radius / 2.0) * Math.sqrt(3);

        MoveTo start;
        LineTo currentLine;

        if (adjacentVertices.isEmpty() && size == 0){
            start = new MoveTo(centerX, centerY - radius);
        } else {
            start = new MoveTo(adjacentVertices.get(0).x,
                                adjacentVertices.get(0).y);
        }

        while (linesRemaining > 0){

//            currentLine = new LineTo()

            linesRemaining--;
        }
    }

    private List<Point> getPointyHexCorners(){

        List<Point> result = new ArrayList<>();
        Point closePoint = new Point(0.0,0.0);

        for (int i = 1; i <= 6; i++){

            //calculating angle in radians
            int angleDeg = 60 * i - 30;
            double angleRad = Math.PI / 180.0 * angleDeg;

            //comparing calculated points with ones already in set
            for (Point p : pointsThusFar){
                if (areTwoPointsInCloseProximity(p,
                        new Point(centerX + radius * Math.cos(angleRad),
                        centerY + radius * Math.sin(angleRad)))){
                    closePoint = p;
                    break;
                }
            }

            //
            if (areTwoPointsInCloseProximity(closePoint,
                    new Point(centerX + radius * Math.cos(angleRad),
                    centerY + radius * Math.sin(angleRad)))) {
                continue;
            } else {
                result.add(new Point(centerX + radius * Math.cos(angleRad),
                        centerY + radius * Math.sin(angleRad)));
            }


        }

        return result;
    }

    private boolean areTwoPointsInCloseProximity(Point a, Point b){
        if (Math.abs(a.x - b.x) < 0.0000001 && Math.abs(a.y - b.y) < 0.0000001) return true;
        else return false;
    }

//    public void setAdjacentLines(List<Point> adjacentVertices) {
//        this.adjacentVertices = adjacentVertices;
//    }

    private void setStyle(){
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(3.0);
    }

    private void setAndAddMouseEventHandler(Color selectionColor){
        EventHandler<MouseEvent> eventHandler = event -> {
            if (instance.getFill().equals(Color.TRANSPARENT)) instance.setFill(selectionColor);
            else instance.setFill(Color.TRANSPARENT);
        };
        instance.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }
}
