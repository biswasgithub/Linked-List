package com.linkedlist;

class LinkedList2{
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	Node head;
	
	public LinkedList2 insert(LinkedList2 list, int data) {
		
		Node newNode = new Node(data);
		Node currNode = list.head;
		if(currNode == null) {
			list.head = newNode;
		}
		else {
			Node node = new Node(data);
			while(currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = node;
		}
		return list;
	}
	
	public void print() {
		Node currNode =head;
		while(currNode !=null) {
			System.out.print(currNode.data + "->");
			currNode=currNode.next;
		}
	}
	
	public LinkedList2 rearrangeEvenOdd(LinkedList2 list) {
		Node even,odd = list.head;
		Node currNode = list.head;
		while(currNode.next.next != null) {
			
		}
		
		return list;
	}
}





public class RearrangeLinkedList {
	
public static void main(String[] args) {
	
	LinkedList2 list = new LinkedList2();
	
	list = list.insert(list, 1);
	list = list.insert(list, 2);
	list = list.insert(list, 3);
	list = list.insert(list, 4);
	list = list.insert(list, 5);
	list = list.insert(list, 6);
	list = list.insert(list, 7);
	
	list.print();
}	

}
