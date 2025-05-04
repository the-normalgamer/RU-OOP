package snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
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
    private Timeline timeline;

    @Override
    public void start(Stage stage) throws Exception {
        World world = new World();
        Pane ui = createUserInterface(world);
        BorderPane root = new BorderPane();

        world.getPane().setStyle("-fx-background-color: #30B080;");
        ui.setPadding(new javafx.geometry.Insets(10));

        root.setLeft(world.getPane());
        root.setRight(ui);

        timeline = new Timeline(new KeyFrame(Duration.millis(DELAY), e -> world.getHead().step()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        // End

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> keyHandler(keyEvent, world));
        scene.setOnMouseClicked(mouseEvent -> mouseHandler(mouseEvent, world));

        stage.setTitle("SNEK");
        stage.setScene(scene);
        stage.show();
    }

    private void keyHandler(KeyEvent keyEvent, World world) {
        switch (keyEvent.getCode()){
            case KeyCode.SPACE:
                world.setRunning(!world.getRunningProperty().getValue());

                if (world.getRunningProperty().getValue()) timeline.play();
                else timeline.pause();

            if (!world.getRunningProperty().getValue()) return; // Other controls are only allowed to be registered when the game isn't paused

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
        }

    }

    private void mouseHandler(MouseEvent mouseEvent, World world) {
        double grid_size = WorldView.getGridSize();
        new Food((int) (mouseEvent.getX() / grid_size),(int) (mouseEvent.getY() / grid_size), world);
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label();

        scoreText.textProperty().bind(Bindings.concat("Score: ", world.getScoreProperty()));

        StringBinding pauseState = Bindings.when(
                Bindings.and(
                        Bindings.not(world.getRunningProperty()),
                        world.getHead().isAliveProperty()
                )
        ).then("Paused").otherwise("");
        StringBinding gameState = Bindings.when(world.getHead().isAliveProperty()).then("").otherwise("GAME OVER");

        runningText.textProperty().bind(Bindings.concat(pauseState, gameState));

        // End

        ui.getChildren().addAll(scoreText, runningText);

        return ui;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
