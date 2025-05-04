package snake;

/**
 * Represents a body part of a snake
 */
public class BodySegment extends Segment {
  private final Segment nextSegment;

  public BodySegment(Segment nextSegment, Direction direction, int xPos, int yPos, World world) {
    super(direction, xPos, yPos, world);
    this.nextSegment = nextSegment;
  }

  @Override
  public void follow(Direction newDirection) {
    nextSegment.follow(getDirection());
    super.follow(newDirection);
  }

  @Override
  public boolean bitesItself(Head head) {
    return sameLocation(head) || nextSegment.bitesItself(head);
  }
}
