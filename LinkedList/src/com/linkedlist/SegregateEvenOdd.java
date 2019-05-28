package com.linkedlist;

class LinkedList3{
	
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	Node head;
	
	public LinkedList3 insert(LinkedList3 list, int data) {
		
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
	
	public LinkedList3 evenOdd(LinkedList3 list) {
		Node currNode = list.head;
		Node evenStart=null, evenEnd=null, OddStart=null, oddEnd = null;
		
		while(currNode != null) {
			if(currNode.data % 2 ==0) {
				if(evenStart == null) {
					evenStart = currNode;
					evenEnd = evenStart;
				}
				else {
					evenEnd.next =currNode;
					evenEnd = evenEnd.next;
				}
			}
			else {
				if(OddStart == null ) {
					OddStart = currNode;
					oddEnd = OddStart;
				}
				else {
					oddEnd.next = currNode;
					oddEnd= oddEnd.next;
				}
			}
			currNode = currNode.next;
		}
		evenEnd.next=OddStart;
		oddEnd.next = null;
		list.head = evenStart;
		
		return list;
	}
	
	public LinkedList3 sortList(LinkedList3 list) {
		
		Node currNode = list.head;
		int temp;
		
		Node index = null;
		while(currNode !=null) {
			index = currNode.next;
			//temp_next = temp.next;
			while(index != null) {
				if(currNode.data >= index.data) {
					temp = currNode.data;
					currNode.data = index.data;
					index.data = temp;
				}
				System.out.println();
				list.print();
				System.out.println();
				index = index.next;
			}
			currNode = currNode.next;
		}
		return list;
	}
}



public class SegregateEvenOdd {
	public static void main(String[] args) {
	
		LinkedList3 list = new LinkedList3();
		
		list = list.insert(list, 12);
		list = list.insert(list, 8);
		list = list.insert(list, 17);
		list = list.insert(list, 15);
		list = list.insert(list, 16);
		list = list.insert(list, 7);
		list = list.insert(list, 9);
		
		list.print();
		System.out.println("\nAfter sort: ");
		list = list.sortList(list);
		list.print();
		
		System.out.println("\nSegregate Even and Odd numbers");
		list = list.evenOdd(list);
		list.print();
	}

}
