package sr.unasat.graph;

import sr.unasat.datastructure.BfsQueue;
import sr.unasat.datastructure.DfsStack;
import sr.unasat.datastructure.QueObject;
import sr.unasat.datastructure.StackDisplayPath;
import sr.unasat.entity.Hubs;

import java.util.Arrays;

public class Graph {

    private final int MAX_HUBS= 15;
    private int INFINITY = 1000;
    private Vertex vertexArray[];
    private int adjMatrix[][];
    private int nVertex;
    private int nVertexGraph;

    public DfsStack dfsStack;
    public StackDisplayPath stackDisplayPath;
    public BfsQueue bfsQueue;

    public Graph(){

        vertexArray = new Vertex[MAX_HUBS];
        adjMatrix = new int[MAX_HUBS][MAX_HUBS];

        nVertex = 0;
        nVertexGraph = 0;
        for(int index=0; index<MAX_HUBS; index++)
            for(int b=0; b<MAX_HUBS; b++)
                adjMatrix[index][b] = INFINITY;

        bfsQueue = new BfsQueue();
        dfsStack = new DfsStack();
        stackDisplayPath = new StackDisplayPath();

    }

    public void addVertex(Hubs hubs){
        vertexArray[nVertex++] = new Vertex(hubs);
    }

    public void addEdge(Hubs sourceHub, Hubs destinationHub, int price) {
        int indexOfSourceHub = findIndexItem(sourceHub);
        int indexOfDestinationHub = findIndexItem(destinationHub);

        adjMatrix[indexOfSourceHub][indexOfDestinationHub] = price;
    }
    public int findIndexItem(Hubs searchItem) {
        for (Vertex vertex : vertexArray) {
            if (vertex.hubs == searchItem) {
                return Arrays.asList(vertexArray).indexOf(vertex);
            }
        }
        return -1;
    }
    public void displayVertexHubsName(int index) {
        System.out.print(  vertexArray[index].hubs.name);
    }

    public void bfsSearch(Hubs startingVertex) {
        int startingVertexIndex = findIndexItem(startingVertex);
        BfsQueue bfsQueue = new BfsQueue();
        vertexArray[startingVertexIndex].wasVisited = true;
        displayVertexHubsName(startingVertexIndex);
        System.out.println();
        bfsQueue.insert(new QueObject(startingVertexIndex, 0));

        int destinationVertex;

        while (!bfsQueue.isEmpty()) {
            QueObject sourceVertexObject = bfsQueue.remove();
            int sourceVertex = sourceVertexObject.vertexIndex;
            int edgeNumber = sourceVertexObject.edgeNumber;

            while ((destinationVertex = getAdjUnvisitedVertex(sourceVertex)) != -1) {
                vertexArray[destinationVertex].wasVisited = true;
//                displayVertex(destinationVertex);
                displayVertexHubsName(destinationVertex);
                System.out.println(", this hub is separated from " + (startingVertex.getName())+ " by " + (edgeNumber + 1) + " edge(s) ");
                displayPrice(destinationVertex);
                if (edgeNumber == 0) {
                    System.out.println(vertexArray[destinationVertex].hubs.getName() + " is a direct neighbor of " + vertexArray[startingVertexIndex].hubs.getName());
                    System.out.println();
                }
                bfsQueue.insert(new QueObject(destinationVertex, edgeNumber + 1));
//                bfsQueue.showQueue();
                System.out.println();
            }
        }
        bfsQueue.makeEmpty();
        for(int j = 0; j < nVertex; j++) {
            vertexArray[j].wasVisited = false;
        }
    }

    public void displayPrice(int startingVertex) {
        for (int priceEdge = 0; priceEdge < 15; priceEdge++) {
            if (adjMatrix[startingVertex][priceEdge] != INFINITY) {
                System.out.println("The price from " + vertexArray[startingVertex].hubs.getName() + " to " +
                        vertexArray[priceEdge].hubs.getName() + " is " + adjMatrix[startingVertex][priceEdge]);
            }
        }
    }

    public void dfsSearch(Hubs startingHub, Hubs destinationHub) {
        int startingVertexIndex = findIndexItem(startingHub);
        int destinationVertexIndex = findIndexItem(destinationHub);
        vertexArray[startingVertexIndex].wasVisited = true;
        String newline = System.lineSeparator();
        System.out.print("The fiber cable will run from ");
        displayVertexHubsName(startingVertexIndex);
        System.out.print(newline + " to "
                + vertexArray[destinationVertexIndex].hubs.getName()
                + newline + " and goes through ");
        dfsStack.push(startingVertexIndex);
        displayVertexHubsName(startingVertexIndex);

        while(!dfsStack.isEmpty()) {
            int stackPeek = dfsStack.peek();
            int unvisitedVertex = getAdjUnvisitedVertex(stackPeek);
            if(unvisitedVertex == -1) { //if row has no weights anymore(wasVisited all true) only 1000
                dfsStack.pop();
//                stackDisplayPath.pop();
            } else {
                vertexArray[unvisitedVertex].wasVisited = true;

                System.out.print( newline + " to ");
                displayVertexHubsName(unvisitedVertex);

                dfsStack.push(unvisitedVertex);
//                stackDisplayPath.push(unvisitedVertex);
                if (unvisitedVertex == destinationVertexIndex) {
                    break;

                }
            }
        }
        for(int index = 0; index < nVertex; index++) {
            vertexArray[index].wasVisited = false;
        }
        System.out.println(" ");
//        stackDisplayPath.showStack();
    }

    public int getAdjUnvisitedVertex(int vertexFirst) {
        for(int j=0; j<nVertex; j++)
            if(adjMatrix[vertexFirst][j] != INFINITY && vertexArray[j].wasVisited==false)
                return j;
        return -1;
    }

}
