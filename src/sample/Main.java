package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.hexagons.Hexagon;
import sample.hexagons.HexagonMap;
import sample.units.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Collection<Hexagon> hexList;
        List<Unit> unitList = new ArrayList<>();
        Unit janusz;

        //"https://i.imgur.com/JKCdRY8.png" - rat_thumb
        //"https://i.imgur.com/NP4h8sA.png" - checkered
        //"https://i.imgur.com/6Ys3fRp.png" - white 12x12

        int width = 11;
        int height = 8;

        HexagonMap hexagonMap = new HexagonMap(25, height, width);
        hexagonMap.setPadding(50,50);

        janusz = new Unit("Janusz",
                5,
                9,
                23,
                5,
                hexagonMap.getHexagon(-1,2),
                Color.GREENYELLOW);
        unitList.add(janusz);

        hexagonMap.setOnHexagonClickedCallback(janusz.selectAndShowMovementRange(Color.YELLOW, unitList));
//            if (hexagon.getFill().equals(Color.TRANSPARENT)){
//                hexagon.setFill(Color.YELLOWGREEN);
////                hexagon.getNeighbours().forEach(neighbour -> neighbour.setFill(Color.GREENYELLOW));
//            }
//            else {
//                hexagon.setFill(Color.TRANSPARENT);
////                hexagon.getNeighbours().forEach(neighbour -> neighbour.setFill(Color.TRANSPARENT));
//
//            }
//        });


        hexList = hexagonMap.getAllHexagons();
        Group group = new Group();

        hexList.forEach(hexagon -> {
                            hexagon.addEventFilter(MouseEvent.MOUSE_CLICKED,
                        event -> {
                            try{
                                hexagonMap.onHexClickedCallback.onClicked(hexagon);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                            hexagon.setFill(Color.RED);
                            group.getChildren().add(hexagon);
        });

        primaryStage.setScene(new Scene(group, 800, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
