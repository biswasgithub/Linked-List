package com.linkedlist;

public class LinkedListInsertion {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {

		Node new_node = new Node(new_data);

		// new_node.data=new_data;
		/* 3. Make next of new Node as head */
		new_node.next = head; // new_node.next=head=null;
		head = new_node;

	}

	/* Inserts End */
	void apend(int data) {
		Node new_node = new Node(data);
		if (head == null) {
			head = new Node(data);
		}

		else {
			Node lastnode = head;
			while (lastnode.next != null) {
				lastnode = lastnode.next;
			}

			lastnode.next = new_node;
		}
	}

	/* Insert any position */
	public void insertAfter(Node pre_node, int data, int node_data) {
		Node new_node = new Node(data);
		Node after_node;

		if (pre_node == null) {
			System.out.println("List is null");
		}

		else {
			while (pre_node != null) {

				if (pre_node.data == node_data) {
					after_node = pre_node.next;

					pre_node.next = new_node;
					new_node.next = after_node;
				}
				pre_node = pre_node.next;
			}
		}
	}

	/* Delete from End */
	public void end_delete() {
		Node current_node = head;
		Node pre_node = null;
		while (current_node.next != null) {
			pre_node = current_node;
			current_node = current_node.next;
		}

		pre_node.next = null;
	}

	/* delete from head */
	public void front_delete() {
		Node current_node = head;
		Node next_node = null;
		if (current_node == null) {
			System.out.println("Node is Null");
		}

		else {
			next_node = current_node.next;
			current_node.next = null;
			head = next_node;
		}
	}

	/* delete from any position */
	public void delete(int data) {

		Node current_node = head;
		Node pre_node = null;

		if (current_node != null && current_node.data == data) {
			head = current_node.next;
		}

		while (current_node != null && current_node.data != data) {
			pre_node = current_node;
			current_node = current_node.next;
		}
		if (current_node == null) {
			System.out.println("Node not found");
		} 
		else {
			pre_node.next = current_node.next;
		}
	}

	public void print() {
		Node tnode = head;
		try {
			while (tnode != null) {
				System.out.print(tnode.data + "-->");
				tnode = tnode.next;
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		LinkedListInsertion linkedList = new LinkedListInsertion();
		linkedList.apend(1);
		linkedList.apend(2);
		linkedList.apend(3);
		linkedList.apend(4);
		linkedList.apend(5);

		linkedList.insertAfter(linkedList.head, 10, 2);
		linkedList.push(50);

		linkedList.print();
		System.out.println();

		linkedList.end_delete();
		linkedList.print();
		System.out.println();

		linkedList.front_delete();
		linkedList.print();
		System.out.println();

		linkedList.delete(101);
		linkedList.print();
	}
}
