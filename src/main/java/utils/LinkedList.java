package utils;

import business.Song;

/**
 *
 * @author michelle
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    private final int maxSize;

    private class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    /**
     * Constructs an empty linked list with a maximum size of 100.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxSize = 100;
    }

    /**
     * Adds a song to the end of the list.
     *
     * @param song the song to add
     * @throws IllegalArgumentException if the provided song is null
     * @throws IllegalStateException    if the list is full (reached its maximum size)
     */
    public void add(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null.");
        }

        if (size >= maxSize) {
            throw new IllegalStateException("Cannot add more songs, the list is full.");
        }


        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    // Get song at a specific position
    public Song get(int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position.");
        }

        Node current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.song;
    }

    /**
     * Finds the index of the specified song in the list.
     *
     * @param song the song to find
     * @return the index of the song in the list, or -1 if not found
     * @throws IllegalArgumentException if the provided song is null
     */
    public int indexOf(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null.");
        }

        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.song.equals(song)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retrieves the song stored in the tail node of the list.
     *
     * @return the song stored in the tail node, or null if the list is empty
     */
    public Song tail() {
        if (isEmpty()) {
            return null;
        }
        return tail.song;
    }

    /**
     * Removes all occurrences of the specified song from the list.
     *
     * @param songToRemove the song to remove
     * @return true if at least one occurrence of the song was removed, false otherwise
     * @throws IllegalArgumentException if the provided song to remove is null
     */
    public boolean removeAll(Song songToRemove) {
        if (songToRemove == null) {
            throw new IllegalArgumentException("Song to remove cannot be null.");
        }

        boolean removed = false;
        Node current = head;

        // Handle removal at the beginning of the list
        while (current != null && current.song.equals(songToRemove)) {
            head = current.next;
            current = head;
            size--;
            removed = true;
        }

        // Handle removal in the middle or end of the list
        while (current != null && current.next != null) {
            if (current.next.song.equals(songToRemove)) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current; // Update tail if the last node was removed
                }
                size--;
                removed = true;
            } else {
                current = current.next;
            }
        }

        return removed;
    }
}