package inclass;
import org.junit.Test;
import org.junit.jupiter.api.test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceFinderTest {

  @Test
  public void testShortestDistances() {
    DistanceFinder distanceFinder = new DistanceFinder("cities1.txt");
    Map<String, Integer> shortestKnownDistance = distanceFinder.shortestDistances();
    assertEquals(4, shortestDistances.get("Peoria"));
    assertEquals(7, shortestDistances.get("Pueblo"));
  }

  @Test
  public void testGetStartingCity() {
    DistanceFinder distanceFinder = new DistanceFinder("cities2.txt");
    assertEquals("Pendleton", distanceFinder.getStartingCity());
  }

  @Test
  public void testShortestDistancesEmptyFile() {
    DistanceFinder distanceFinder = new DistanceFinder("cities3.txt");
    Map<String, Integer> shortestKnownDistance = distanceFinder.shortestDistances();
    assertEquals(0, shortestDistances.get("Peoria"));
    assertEquals(7, shortestDistances.get("Pueblo"));
    assertEquals(6, shortestDistances.get("Pierre"));
  }

  @Test
  public void testShortestDistancesAllCities() {
    DistanceFinder distanceFinder = new DistanceFinder("cities4.txt");
    Map<String, Integer> shortestKnownDistance = distanceFinder.shortestDistances();
    assertEquals(0, shortestDistances.get("Peoria"));
    assertEquals(12, shortestDistances.get("Pendleton"));
    assertequals(4, shortestDistances.get("Pierre"));
    assertEquals(3, shortestDistances.get("Pueblo"));
  }
}