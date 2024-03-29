package inclass;

import java.util.*;
import java.io.*;
/**
   Class for simulating finding the shortest distance
   from a city to all other cities.
*/
public class DistanceFinder
{
   private String startFrom;
   private Map<String, HashSet<DistanceTo>> directConnections;

   /**
      Construct a Distance finder.
      @param filename the file containing the connections.
   */
   public DistanceFinder(String filename)
   {
     directConnections = new HashMap<>();
     try (Scanner scanner = new Scanner(new File(filename))) {
       if (scanner.hasNextLine()) {
         String[] firstLine = scanner.nextLine().split("\\s+");
         startFrom = firstLine[0];
         directConnections.put(startFrom, new HashSet<>());
         directConnections.get(startFrom).add(new DistanceTo(firstLine[1], Integer.parseInt(firstLine[2])));
       }
       while (scanner.hasNextLine()) {
         String[] line = scanner.nextLine().split("\\s+");
         directConnections.putIfAbsent(line[0], new HashSet<>());
         directConnections.putIfAbsent(line[1], new HashSet<>());
         directConnections.get(line[0]).add(new DistanceTo(line[1], Integer.parseInt(line[2])));
         directConnections.get(line[1]).add(new DistanceTo(line[0], Integer.parseInt(line[2])));
       }
     } catch (FileNotFoundException e) {
        e.printStackTrace();
     }
   }
      // Read the file and intialize the instance variables
      //. . .
      //use HashMap





   

   /**
      Return the city that we start from.
   */
   public String getStartingCity()
   {
      return startFrom;
   }

   /**
      Return the shortest distances.
      @return the shortest distances.
   */
   public Map<String, Integer> shortestDistances()
   {
    Map<String, Integer> shortestKnownDistance = new TreeMap<>();
    PriorityQueue<DistanceTo> pq = new PriorityQueue<>(Comparator.comparingInt(DistanceTo::getDistance));
    pq.add(new DistanceTo(startFrom, 0));

    while (!pq.isEmpty()) {
      DistanceTo current = pq.poll();
      String target = current.getTarget();
      int distance = current.getDistance();

      if (!shortestKnownDistance.containsKey(target)) {
        shortestKnownDistance.put(target, distance);
        for (DistanceTo next : directConnections.get(target)) {
          pq.add(new DistanceTo(next.getTarget(), distance + next.getDistance()));
        }
      }
    }
    shortestKnownDistance.remove(startFrom);
    return shortestKnownDistance;
      // Follow the algorithm in the instruction
      // Remember the starting point is the first city in the file.
      //. . .
      //use TreeMap






   }
}
