import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PetRockTest {

  private PetRock yan;

  // Timeout rule:
  @Rule
  public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

  @Before
  public void myTestSetUp() throws Exception {
    yan = new PetRock("Yan");
  }

  @Test
  public void getName() throws Exception {
    assertEquals("Yan", yan.getName());
  }

  @Test
  public void testUnhappyToStart() throws Exception {
    assertFalse(yan.isHappy());
  }

  @Test
  public void testHappyAfterPlay() throws Exception {
    yan.playWithRock();
    assertTrue(yan.isHappy());
  }

  @Ignore ("Exception throwing not yet defined")
  @Test (expected = IllegalStateException.class)
  public void nameFail() throws Exception {
    yan.getHappyMessage();
  }

  @Test
  public void name() throws Exception {
    yan.playWithRock();
    String msg = yan.getHappyMessage();
    assertEquals("I'm happy!", msg);
  }

  @Test
  public void testFavNum() throws Exception {
    assertEquals(42, yan.getFavNumber());
  }

  @Test (expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception {
    new PetRock("");
  }

  @Test (timeout = 100) // in ms
  public void waitForHappyTimeout() throws Exception {
    yan.waitTillHappy();
  }

  @Test
  public void weightTest() throws Exception {
    assertEquals(300.58, yan.getWeight(),0.000001);
  }

  @Test
  public void stringTest() throws Exception {
    assertEquals("Yan is my pet rock with a weight of 300.58 grams.",
        yan.toString());
  }

}