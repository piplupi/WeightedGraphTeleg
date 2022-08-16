package sr.unasat.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BfsQueueTest {

    BfsQueue testQue = new BfsQueue();

    @Test
    void canInsertQueObject(){
        QueObject queObjectTest = new QueObject(2,0);

        //insert Object at the rear/tail of the quearray
        testQue.insert(queObjectTest);
        assertEquals(2, testQue.peekFront().vertexIndex);
    }

    @Test
    void canRemoveQueObject(){
        QueObject queObjectTest1 = new QueObject(3,0);
        QueObject queObjectTest2 = new QueObject(5,1);

        testQue.insert(queObjectTest1);
        testQue.insert(queObjectTest2);

        //remove Object at the front/head of the queArray
        testQue.remove();
        assertEquals(5, testQue.peekRear().vertexIndex);
    }

}