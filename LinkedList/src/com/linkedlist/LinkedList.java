package com.linkedlist;

public class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {

			this.data = data;
			next = null;
		}
	}

	//insert node in last position
	public LinkedList insert(LinkedList list, int data) {

		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		} else {
			Node current = list.head;
			while (current.next != null) {
				current = current.next;

			}
			current.next = new_node;
		}

		return list;
	}

	public LinkedList insertAfterKey(LinkedList list, int key, int data) {

		Node new_node = new Node(data);
		Node curreNode = list.head, afterNode = null;
		
		if(curreNode == null) {
			System.out.println("List is empty");
		}
		
		while (curreNode != null && curreNode.data != key) {
			curreNode = curreNode.next;
		}

		if (curreNode != null) {
			System.out.println("Key is found");
			afterNode = curreNode.next;
			curreNode.next = new_node;
			new_node.next = afterNode;
		} else {
			System.out.println("Key not found");
		}
		return list;
	}
	
	public LinkedList insertAtPosition(LinkedList list, int position, int data) {
		
		Node new_node=new Node(data);
		Node curreNode = list.head;
		Node afterNode = null;
		int count=0;
		while(curreNode != null) {
			count +=1;
			if(count == position) {
				afterNode = curreNode.next;
				curreNode.next = new_node;
				new_node.next =afterNode;
			}
			curreNode = curreNode.next;
		}
		/*
		 * if(curreNode == null) { System.out.println("position is out of limit"); }
		 */
		
		return list;
	}
	
	public LinkedList reverseList(LinkedList list) {
		
		Node currNode = list.head;
		Node prevNode=null, nextNode=null;
		while(currNode != null) {
			
			nextNode = currNode.next; // save list after current node
			currNode.next = prevNode; // break the link and point to the previous node
			prevNode = currNode;  // preNode now point current node
			currNode = nextNode;  // currNode now point next of current node 
		}
		list.head = prevNode;  // point prevNode as head
		return list;
	}
	
	public void print() {
		Node current = head;
		while (current != null) {

			System.out.print(current.data + " -> ");
			current = current.next;
		}
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list = list.insert(list, 1);
		list = list.insert(list, 2);
		list = list.insert(list, 4);
		list = list.insert(list, 6);

		list.print();

		System.out.println("\n insert After Key");
		list = list.insertAfterKey(list, 2, 3);
		list.print();
		System.out.println("\n insert At Position");
		list = list.insertAtPosition(list, 4,5);
		list.print();

		System.out.println("\n Reverse List");
		list = list.reverseList(list);
		list.print();
		
	}
}
