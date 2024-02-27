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
    }

    //add song to end of list
    public void add(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Song cannot be null.");
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

    // Display all songs in list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }

    // Get song at a specific position
    public Song get(int position) {
        if (position < 0 || position >= size) {
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
}