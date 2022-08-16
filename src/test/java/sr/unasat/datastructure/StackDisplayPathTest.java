package sr.unasat.datastructure;

import org.junit.jupiter.api.Test;
import sr.unasat.entity.Hubs;

import static org.junit.jupiter.api.Assertions.*;

class StackDisplayPathTest {

    StackDisplayPath containsHubs = new StackDisplayPath();

    @Test
    void canPushHub() {
        Hubs insertHub1 = new Hubs("Meerzorg", "-347");
        containsHubs.push(insertHub1);

        assertEquals("Meerzorg", containsHubs.peek().getName());

    }

    @Test
    void canPopHub(){
        Hubs insertHubParamaribo = new Hubs("Geyersvlijt", "-125");
        Hubs insertHubParamaribo2 = new Hubs("Blauwgrond", "-3483");

        containsHubs.push(insertHubParamaribo);
        containsHubs.push(insertHubParamaribo2);

        containsHubs.pop();
        assertEquals("Geyersvlijt", containsHubs.peek().getName());
    }
}