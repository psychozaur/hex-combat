package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

//        List<Hexagon> hexList = new ArrayList<>();

        HexagonMap hexMap = new HexagonMap(6,6,50.0,50.0,25.0);

        Group group = new Group();

        for (Object key : hexMap.getKeySet()){
            group.getChildren().add((Hexagon) hexMap.getHexMap().get(key));
        }

//        Hexagon hex = hexMap.getHexagonFromMap(2,3);
//        hex.setFill(Color.YELLOW);

        primaryStage.setScene(new Scene(group, 400, 400));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
