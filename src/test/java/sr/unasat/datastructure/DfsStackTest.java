package sr.unasat.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DfsStackTest {

    DfsStack stacktest = new DfsStack();

    @Test
    void canPush() {
        stacktest.push(2);
        assertEquals(2, stacktest.peek());

    }

    @Test
    void canPop(){
        stacktest.push(1);
        stacktest.push(3);

        stacktest.pop();
        assertEquals(1, stacktest.peek());

    }
}