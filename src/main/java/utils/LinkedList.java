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

    //get size of list
    public int size() {
        return size;
    }

    //display all songs in list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.song);
            current = current.next;
        }
    }
}
