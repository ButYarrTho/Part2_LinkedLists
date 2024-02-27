package utils;

import business.Song;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michelle
 */
public class LinkedListTest {

    public LinkedListTest() {
    }

    /**
     * Testing the size method, of class LinkedList, with an empty list.
     */
    @Test
    public void testSize_EmptyList() {
        LinkedList instance = new LinkedList();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Testing the size method, of class LinkedList, with a populated list.
     */
    @Test
    public void testSize_PopulatedList() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 0", "Artist 1");
        Song s2 = new Song("Title 1", "Artist 1");
        Song s3 = new Song("Title 2", "Artist 1");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Testing valid input with get method, of class LinkedList.
     */
    @Test
    public void testGet_ValidInput() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 0", "Artist 1");
        Song s2 = new Song("Title 1", "Artist 1");
        Song s3 = new Song("Title 2", "Artist 1");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);

        Song result = instance.get(1);
        assertEquals(s2, result);
    }

    /**
     * Testing valid input with get method, when getting from the end of the list, of class LinkedList.
     */
    @Test
    public void testGet_ValidInput_EndOfList() {
        LinkedList instance = new LinkedList();
        instance.add(new Song("Title 0", "Artist 1"));
        instance.add(new Song("Title 1", "Artist 1"));
        instance.add(new Song("Title 2", "Artist 1"));

        Song expResult = new Song("Title 2", "Artist 1");
        Song result = instance.get(2);
        assertEquals(expResult, result);
    }

    /**
     * Testing invalid input (below lower bound) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingLowerBound() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 0", "Artist 1");
        Song s2 = new Song("Title 1", "Artist 1");
        Song s3 = new Song("Title 2", "Artist 1");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(-1);
        });
    }

    /**
     * Testing invalid input (greater than size) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingUpperBound_GreaterThanSize() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 0", "Artist 1");
        Song s2 = new Song("Title 1", "Artist 1");
        Song s3 = new Song("Title 2", "Artist 1");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(4);
        });
    }

    /**
     * Testing invalid input (equal to size) with get method, of class LinkedList.
     */
    @Test
    public void testGet_BreakingUpperBound_EqualToSize() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 0", "Artist 1");
        Song s2 = new Song("Title 1", "Artist 1");
        Song s3 = new Song("Title 2", "Artist 1");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.get(3);
        });
    }

    /**
     * Test of indexOf method with information in the list, of class LinkedList.
     */
    @Test
    public void testIndexOf_SongInList() {
        Song s = new Song("Temp Title", "Temp Artist1");
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist1"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist1"));

        int expResult = 2;
        int result = instance.indexOf(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method with information in the list, of class LinkedList.
     */
    @Test
    public void testIndexOf_SongNotInList(){
        Song s = new Song();
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist1"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist1"));

        int expResult = -1;
        int result = instance.indexOf(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method with an empty list, of class LinkedList.
     */
    @Test
    public void testIsEmpty() {
        LinkedList instance = new LinkedList();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method with an populated list, of class LinkedList.
     */
    @Test
    public void testIsEmpty_PopulatedList() {
        LinkedList instance = new LinkedList();
        instance.add(new Song("Temp title0", "Temp Artist1"));
        instance.add(new Song("Temp title1", "Temp Artist1"));
        instance.add(new Song("Temp Title", "Temp Artist1"));

        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}
