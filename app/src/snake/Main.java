package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;

/**
 *
 * @version 1.0
 */
public class Main extends Application {
    public final static int DELAY = 200;
     private boolean isRunning = false;
    private Timeline timeline;
    @Override
    public void start(Stage stage) throws Exception {
        World world = new World();
        Pane worldPane = new WorldView(world);
        Pane ui = createUserInterface(world);
        BorderPane root = new BorderPane();

        worldPane.setStyle("-fx-background-color: #30B080;");
        ui.setPadding(new javafx.geometry.Insets(10));

        root.setLeft(worldPane);
        root.setRight(ui);

        // TODO: Implement timeline
        timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> world.getHead().step()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        // End

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> keyHandler(keyEvent, world));
        scene.setOnMouseClicked(mouseEvent -> mouseHandler(mouseEvent, world));

        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }

    private void keyHandler(KeyEvent keyEvent, World world) {
        // TODO: Implement keyboard controls
        switch (keyEvent.getCode()){
            case KeyCode.UP:
            case KeyCode.W:
                world.getHead().setDirection(Direction.NORTH);
                break;
            case KeyCode.DOWN:
            case KeyCode.S:
                world.getHead().setDirection(Direction.SOUTH);
                break;
            case KeyCode.LEFT:
            case KeyCode.A:
                world.getHead().setDirection(Direction.WEST);
                break;
            case KeyCode.RIGHT:
            case KeyCode.D:
                world.getHead().setDirection(Direction.EAST);
                break;
            case KeyCode.SPACE:
                isRunning = !isRunning;
                if (isRunning) timeline.play();
                else timeline.pause();
        }

    }

    private void mouseHandler(MouseEvent mouseEvent, World world) {
        // TODO: Implement mouse
        new Food((int) mouseEvent.getX(),(int) mouseEvent.getY(),world);
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 'space' to start");

        // TODO: Implement user interface

        // End

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
