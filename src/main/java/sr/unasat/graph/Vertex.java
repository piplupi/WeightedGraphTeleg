package sr.unasat.graph;

import sr.unasat.entity.Hubs;

public class Vertex {

    public Hubs hubs;
    public boolean wasVisited;
    public boolean isInGraph;

    public Vertex(Hubs hubs) {
        this.hubs = hubs;
        wasVisited= false;
        isInGraph = false;
    }
}
