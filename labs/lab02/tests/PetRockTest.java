/**
 * Import JUnit testing suite
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * Class PetRockTest containing unit tests
 */
public class PetRockTest {

  /**
   * Construct a new PetRock object
   */
  private PetRock yan;

  // Timeout rule:
  @Rule
  /**
   * Get global timeout in seconds
   */
  public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

  /**
   * Construct the object for testing setup
   * @throws Exception if the name is empty
   */
  @Before
  public void myTestSetUp() throws Exception {
    yan = new PetRock("Yan");
  }

  /**
   * Check if the given name is correct
   * @throws Exception if the argument is invalid
   */
  @Test
  public void getName() throws Exception {
    assertEquals("Yan", yan.getName());
  }

  /**
   * Check that the current state of the pet
   * is indeed not happy
   * @throws Exception where necessary
   */
  @Test
  public void testUnhappyToStart() throws Exception {
    assertFalse(yan.isHappy());
  }

  /**
   * Check if the pet indeed becomes happy after
   * being played with
   * @throws Exception if the argument is invalid
   */
  @Test
  public void testHappyAfterPlay() throws Exception {
    yan.playWithRock();
    assertTrue(yan.isHappy());
  }

  /**
   * This test throws an exception when the pet is
   * not happy
   * @throws Exception if the pet is not happy
   */
  @Ignore ("Exception throwing not yet defined")
  @Test (expected = IllegalStateException.class)
  public void nameFail() throws Exception {
    yan.getHappyMessage();
  }

  /**
   * This tests makes sure that the pet is happy
   * after being played with and that the toString
   * method indicates that the pet is happy
   * @throws Exception where necessary
   */
  @Test
  public void name() throws Exception {
    yan.playWithRock();
    String msg = yan.getHappyMessage();
    assertEquals("I'm happy!", msg);
  }

  /**
   * This test if the getFavNumber returns the
   * correct value
   * @throws Exception where necessary
   */
  @Test
  public void testFavNum() throws Exception {
    assertEquals(42, yan.getFavNumber());
  }

  /**
   * This test if passing an empty name in the
   * constructor throws an error
   * @throws Exception when a new pet rock is
   * constructed without a name
   */
  @Test (expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception {
    new PetRock("");
  }

  /**
   * Throws an exception when the test is timed out
   * after 100 milliseconds
   * @throws Exception where necessary
   */
  @Test (timeout = 100) // in ms
  public void waitForHappyTimeout() throws Exception {
    yan.waitTillHappy();
  }

  /**
   * Tests if the weight of the pet is as expected
   * @throws Exception where necessary
   */
  @Test
  public void weightTest() throws Exception {
    assertEquals(300.58, yan.getWeight(),0.000001);
  }

  /**
   * Tests if the toString function returns the correct
   * string representation of the pet rock
   * @throws Exception where necessary
   */
  @Test
  public void stringTest() throws Exception {
    assertEquals("Yan is my pet rock with a weight of 300.58 grams.",
        yan.toString());
  }

}