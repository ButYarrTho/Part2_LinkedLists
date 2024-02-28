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

    // Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxSize = 100;
    }

    //add song to end of list
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

    // Get the size of the list
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

    // Find index of a song
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

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public Song tail() {
        if (isEmpty()) {
            return null;
        }
        return tail.song;
    }

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