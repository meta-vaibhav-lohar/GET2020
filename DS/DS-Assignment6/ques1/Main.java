package ques1;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static GraphImplementation graph;
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String args[]) {
    	
        System.out.print("Enter the number of vertices in the graph : ");
        String size = inputScanner.next();
        graph = new GraphImplementation(Integer.parseInt(size));
       
        String choice = "";
        do
        {
            System.out.println("\n1. Add Edge to the graph");
            System.out.println("2. Check is the graph Is Connected");
            System.out.println("3. Calculate vertices reachable from a give vertex");
            System.out.println("4. Calculate the Minimum spanning tree");
            System.out.println("5. Calculate the Shortest Path between two nodes");
            System.out.println("6. Print the graph");
            System.out.println("7. Exit!!");
            System.out.print("\nEnter your choice : ");
            choice = inputScanner.next();
            switch (choice) {
            
            case "1":
                System.out.print("\nEnter Source vertex : ");
                String source = inputScanner.next();
                System.out.print("Enter Destination vertex : ");
                String destination = inputScanner.next();
                System.out.print("Enter the weight of the edge : ");
                String weight = inputScanner.next();
                if(graph.addEdgeToTheGraph(Integer.parseInt(source), Integer.parseInt(destination), Integer.parseInt(weight)))
                	System.out.println("Edge Added!!!");
                break;
                
            case "2":
                if (graph.isConnected())
                    System.out.println("\nGraph is connected");
                else
                    System.out.println("Graph is not Connected");
                break;
                
            case "3":
                System.out.print("Enter Vertex to get all rechable Vertex : ");
                String vertex = inputScanner.next();
                 List<Integer> rechableVertex = graph.getReachableVertices(Integer.parseInt(vertex));
	             for (Integer i : rechableVertex)                     
	            	 System.out.print(i + "  ");
                break;
                
            case "4":
                int tree[][] = graph.getMST();
                int noOfVertices = Integer.parseInt(size);
                int k = 0;
                for(int i = 0; i < noOfVertices; i++)
        		{
        			for(int j = 0; j < noOfVertices; j++)
        			{
        				if(tree[i][j] > 0)
        				{
        					System.out.println("Edge : " + (k++));
        					System.out.println("\tSource Node : " + i + " Destination Node : " + j + " Weight : " + tree[i][j]);
        				}
        			}
        		}
                break;
                
            case "5":
                System.out.print("Enter the vertex 1 : ");
                source = inputScanner.next();
                System.out.print("Enter the vertex 2 : ");
                destination = inputScanner.next();
                int shortestPathlength = graph.getShortestPath(Integer.parseInt(source),Integer.parseInt(destination));
                    System.out.println("Shortest Path between " + source  + " and " + destination + " is " + shortestPathlength);
                break;
                
            case"6":
            		graph.printTree();
            		break;
            		
            case "7":
                break;
                
            default:
                System.out.println("Enter a valid choice!!!");

            }
        } while (!"7".equals(choice));
        
        System.out.println("Thank You for using the system");
    }

}