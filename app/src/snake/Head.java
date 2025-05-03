package snake;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Represents the head part of the snake
 */
public class Head extends Mover {
  private Property<Segment> bodyProperty;
  private BooleanProperty isAlive = new SimpleBooleanProperty(true);

  public Head(Segment body, Direction direction, int xPos, int yPos, World world) {
    super(direction, xPos, yPos, world);
    this.bodyProperty = new SimpleObjectProperty<>(body);
  }

  public Segment getBody() {
    return bodyProperty.getValue();
  }

  public Property<Segment> bodyProperty() {
    return bodyProperty;
  }

  public void step() {
    World world = getWorld();
    Food food = world.getFood();

    tryToMove();

    // If it's still alive after trying to move
    if (isAlive.getValue()) {
      Segment body = this.getBody();

      if (    this.xPosProperty().intValue() == food.xPosProperty().intValue()
           && this.yPosProperty().intValue() == food.yPosProperty().intValue()) {
        // FOOD!!
        // Make a new segment for the head, setting its nextSegment to be the current segment
        this.bodyProperty = new SimpleObjectProperty<>(new BodySegment(body, this.getDirection(), this.getXPos(), this.getYPos(), world));

      } else {
        // If no new segment is added, make all segments follow the head
        body.follow(this.getDirection());
      }

    }

    // TODO: implement a step in the game. Move the snake if possible, increasing
    // its length when it eats food, and setting properties accordingly.
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
