/**
 * This class represents a pet rock object. It offers
 * a number of methods applicable to a pet rock.
 */

public class PetRock {
  private String name;
  private double weight;
  private boolean happy = false;

  /**
   * Construct a pet rock object with a name
   * @param name a string representing a name of the pet
   */
  public PetRock(String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  /**
   * Get the name of the pet rock
   * @return the name of the pet rock
   */
  public String getName() {
    return name;
  }

  /**
   * Check if the pet rock is in a happy state
   * @return the current state of the pet rock
   */
  public boolean isHappy() {
    return happy;
  }

  /**
   * Change the 'happy' attribute to True, as the pet
   * rock is played with
   */
  public void playWithRock() {
    happy = true;
  }

  /**
   * Get the string message indicating happiness from
   * the pet rock.
   * @return the message "I'm happy!" from the pet rock
   */
  public String getHappyMessage() {
//    if (!happy) {
//      throw new IllegalStateException();
//    }
    return "I'm happy!";
  }

  /**
   * Get the favorite number of the pet rock, which is 42
   * @return 42
   */
  public int getFavNumber() {
    return 42;
  }

  /**
   * Wait until the pet is happy. Should be used with the
   * timeout rule
   */
  public void waitTillHappy() {
    while (!happy) {
      // do nothing
    }
  }

  /**
   * Set and return the weight of the pet rock
   * @return the weight of the pet rock, which is 300.58g
   */
  public double getWeight() {
    this.weight = 300.58;
    return weight;
  }

  /**
   * Return the string representation of the pet rock
   * @return the string representation of the pet rock
   */
  @Override
  public String toString() {
    return name + " is my pet rock with a weight of " + getWeight()
        + " grams.";
  }
}
