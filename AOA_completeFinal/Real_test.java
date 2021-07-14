/*

This is the Real_Test main function that will run Graph Operations on Real graph
generated by reading data from input files. This class contains UI (User Interface)
that will ask input from user about what file the user wants to read and then it 
will ask what type Adjacency Criteria the user wants to build on the real graph and
then perform the Graph Operations on Netflix Data by the user.

First of all, user has to make a choice by typing the name of the file that 
user wants the Adjacency Criteria to be built upon.
example - 
NOTE - File should be just outside the AOA_completeFinal package directory.
INPUT - ratings_data_3.txt

Then user will input what type of Adjacency Criteria user wants to make among:
1. Two customers have watched the same movie.
2. Two customers have watched the same movie and rated it 4 or 5 star.
3. Two customers have watched the same movie and rated it 1-3 star.

After this user will be given three choices between following operations:
1. Find Connected Components
2. Find Cycle in Graph
3. Find Shortest Path
    User has to input starting node here

After the desired operation has been executed, then the user shall be
redirected to operations again where he has a choice to run further
operations or go back to the previous menu by pressing any key.

*/

package AOA_completeFinal;
import java.util.*;

public class Real_test {
    
    static void UIReal() {
        HashSet<Integer>[] adjList;
        Scanner scn = new Scanner(System.in);
        while(true) {
            adjList = Graph_make.readFileAndCreateAdjList();
            if (adjList.length == 1) return;
            System.out.println("Enter the operation that you want to run: ");
            System.out.println("Press 1 to find Connected Components");
            System.out.println("Press 2 to Detect a Cycle in the Graph");
            System.out.println("Press 3 to find the Shortest Path between a starting node to all other nodes");
            System.out.println("Press any other key to return to previous menu. ");
            String choice = scn.nextLine();

            switch(choice) {
                case "1": {
                    Graph_operations.countComponents(adjList.length, adjList);
                    break;
                }
                case "2": {
                    Graph_operations.isCyclic(adjList.length, adjList);
                    break;
                }
                case "3": {
                    System.out.println("Enter the starting node between 0 to " + adjList.length);
                    String startStr = scn.next();
                    int start = Integer.parseInt(startStr);
                    Graph_operations.dijkstra(adjList, start);
                    break;
                }
                default: {
                    return;
                }
            }
            
        }        
    }
    public static void main(String[] args) {
        UIReal();
    }
}