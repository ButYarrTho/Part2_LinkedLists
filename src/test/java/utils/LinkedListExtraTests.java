package utils;

import business.Song;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michelle
 */
public class LinkedListExtraTests {

    public LinkedListExtraTests() {
    }

    /**
     * Test removeAll method with a single occurrence of songToRemove in the middle of the list.
     */
    @Test
    public void testRemoveAll_SingleOccurrenceInTheMiddle() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist 1");
        Song s2 = new Song("Title 2", "Artist 2");
        Song s3 = new Song("Title 3", "Artist 3");
        Song s4 = new Song("Title 4", "Artist 4");
        Song songToRemove = new Song("Title 2", "Artist 2");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);
        instance.add(s4);

        assertEquals(3, instance.size()); // Verify size of list after removal
        assertEquals(-1, instance.indexOf(songToRemove)); // Verify that song is not in list

    }

    /**
     * Test removeAll method with multiple occurrences of songToRemove.
     */
    @Test
    public void testRemoveAll_MultipleOccurrences() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist 1");
        Song s2 = new Song("Title 2", "Artist 2");
        Song s3 = new Song("Title 2", "Artist 2");
        Song s4 = new Song("Title 3", "Artist 3");
        Song songToRemove = new Song("Title 2", "Artist 2");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);
        instance.add(s4);

        assertEquals(2, instance.size()); // Verify size of list after removal
        assertEquals(-1, instance.indexOf(songToRemove)); // Verify the song is not in list
    }

    /**
     * Test removeAll method when songToRemove is not present in the list.
     */
    @Test
    public void testRemoveAll_SongNotPresent() {
        LinkedList instance = new LinkedList();
        Song s1 = new Song("Title 1", "Artist 1");
        Song s2 = new Song("Title 2", "Artist 2");
        Song s3 = new Song("Title 3", "Artist 3");
        Song s4 = new Song("Title 4", "Artist 4");
        Song songToRemove = new Song("Title 5", "Artist 5");

        instance.add(s1);
        instance.add(s2);
        instance.add(s3);
        instance.add(s4);

        assertEquals(4, instance.size()); // Verify the size of the list remains unchanged
    }

    /**
     * Test removeAll method when the list is empty.
     */
    @Test
    public void testRemoveAll_EmptyList() {
        LinkedList instance = new LinkedList();
        Song songToRemove = new Song("Title 1", "Artist 1");

        assertFalse(instance.removeAll(songToRemove)); // Verify that no song is removed from an empty list
        assertEquals(0, instance.size()); // Verify the size of the list remains 0
    }
}

