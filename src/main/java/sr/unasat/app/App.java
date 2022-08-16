package sr.unasat.app;

import sr.unasat.entity.Hubs;
import sr.unasat.graph.Graph;

public class App {

    public static void main(String[] args) {

        Hubs bernharddorp = new Hubs("Bernharddorp", "5.629136, -55.21281");
        Hubs witSanti = new Hubs("Wit Santi", "5.843311, -55.142391");
        Hubs kabendaDorp = new Hubs("Kabenda dorp", "5.846015, -55.982136");
        Hubs cassipora = new Hubs("Cassipora", "5.396856, -54.942489");
        Hubs witagron = new Hubs("Witagron", "5.163674, -55.075999");
        Hubs cupido = new Hubs("Cupido", "5.287315, -54.21281");
        Hubs tapoeripa = new Hubs("Tapoeripa", "5.074493, -55.975998");
        Hubs kwamala = new Hubs("Kwamala", "2.353986, -56.791789");
        Hubs sipaliwini = new Hubs("Sipaliwini", "2.026822, -56.124203");
        Hubs bigiston = new Hubs("Bigiston", "5.415572, -54.125915");
        Hubs calbo = new Hubs("Calbo", "5.792817, -54.440897");
        Hubs alfonsdorp = new Hubs("Alfonsdorp", "5.577136, -54.354862");
        Hubs tepu = new Hubs("Tepu", "3.155743, -55.715132");
        Hubs apetina = new Hubs("Apetina", "3.50337, -55.057811");
        Hubs alalapadoe = new Hubs("Alalapadoe", "2.523636, -56.324442");

        Graph graph = new Graph();
        graph.addVertex(bernharddorp);
        graph.addVertex(witSanti);
        graph.addVertex(kabendaDorp);
        graph.addVertex(cassipora);
        graph.addVertex(witagron);
        graph.addVertex(cupido);
        graph.addVertex(tapoeripa);
        graph.addVertex(kwamala);
        graph.addVertex(sipaliwini);
        graph.addVertex(bigiston);
        graph.addVertex(calbo);
        graph.addVertex(alfonsdorp);
        graph.addVertex(tepu);
        graph.addVertex(apetina);
        graph.addVertex(alalapadoe);

        graph.addEdge(bernharddorp, witSanti, 30);
        graph.addEdge(bernharddorp, kabendaDorp, 75);
        graph.addEdge(witSanti, cassipora, 35);
        graph.addEdge(witSanti, tapoeripa, 25);
        graph.addEdge(cassipora, cupido, 55);
        graph.addEdge(cupido, tapoeripa, 40);
        graph.addEdge(tapoeripa, sipaliwini, 15);
        graph.addEdge(sipaliwini, kwamala, 50);
        graph.addEdge(sipaliwini, apetina, 44);
        graph.addEdge(kwamala, bernharddorp, 30);
        graph.addEdge(apetina, bernharddorp, 35);
        graph.addEdge(apetina, calbo, 44);
        graph.addEdge(calbo, tepu, 12);
        graph.addEdge(tepu, bernharddorp, 35);
        graph.addEdge(tepu, alfonsdorp, 75);
        graph.addEdge(alfonsdorp, alalapadoe, 25);
        graph.addEdge(alalapadoe, tepu, 60);
        graph.addEdge(alalapadoe, calbo, 35);
        graph.addEdge(kabendaDorp, bigiston, 30);
        graph.addEdge(bigiston, cassipora, 30);
        graph.addEdge(bigiston, witagron, 25);
        graph.addEdge(witagron, alfonsdorp, 55);

        //This method will show the price between a Vertex (State) and the direct neighbors
//       graph.bfsSearch(bernharddorp);
//        System.out.println("");

//        This method will showcase the fiber install from starting hub to the destination hub
        graph.dfsSearch(sipaliwini, apetina);


    }

}
