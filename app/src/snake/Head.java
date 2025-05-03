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
    // TODO: implement a step in the game. Move the snake if possible, increasing
    // its length when it eats food, and setting properties accordingly.
    
    // End
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
