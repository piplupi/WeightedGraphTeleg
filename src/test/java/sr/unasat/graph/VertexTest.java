package sr.unasat.graph;

import org.junit.jupiter.api.Test;
import sr.unasat.entity.Hubs;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VertexTest {

    @Test
    void canInsertHub(){

        Hubs insertDorp = new Hubs("Dijkveld", "-3848");
        Vertex test = new Vertex(insertDorp);

        assertEquals("Dijkveld", test.hubs.getName());
    }

}