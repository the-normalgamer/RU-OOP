package snake;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * Represents the head part of the snake
 */
public class Head extends Mover {
  private Property<Segment> childProperty;
  private BooleanProperty isAlive = new SimpleBooleanProperty(true);

  public Head(Segment body, Direction direction, int xPos, int yPos, World world) {
    super(direction, xPos, yPos, world);
    this.childProperty = new SimpleObjectProperty<>(body);
  }

  public Segment getBody() {
    return childProperty.getValue();
  }

  public Property<Segment> bodyProperty() {
    return childProperty;
  }

  public void step() {
    if (!isAlive.getValue()) return;

    World world = getWorld();
    Food food = world.getFood();

    tryToMove();
    Segment child = getBody();

    if (child.bitesItself(this))
      isAlive.set(false);

    // If it's still alive after trying to move
    if (isAlive.getValue()) {

      if (    this.xPosProperty().intValue() == food.xPosProperty().intValue()
           && this.yPosProperty().intValue() == food.yPosProperty().intValue()) {
        // FOOD!!
        world.eatFood();

        // Make a new segment for the head, setting its nextSegment to be the current segment
        childProperty = new SimpleObjectProperty<>(new BodySegment(child, this.getDirection(), this.getXPos(), this.getYPos(), world));

        // Add a circle for the "new segment"
        if (world.getPane() instanceof WorldView worldView)
          worldView.addMoverView(getBody(), WorldView.getGridSize() / 1.5, Color.GREEN);

      } else {
        // If no new segment is added, make all segments follow the head
        child.follow(this.getDirection());
      }

    }
  }

  private void tryToMove() {
    if (canMove()) {
      move();
    } else {
      isAlive.set(false);
    }
  }

  public BooleanProperty isAliveProperty() {
    return isAlive;
  }

}
