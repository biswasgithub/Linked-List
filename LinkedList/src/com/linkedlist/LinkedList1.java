package com.linkedlist;

public class LinkedList1 {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public LinkedList1 insertion(LinkedList1 list, int data) {

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

	// getMiddle Node
	public int getMiddle(LinkedList1 list) {

		int middle_data = 0;
		Node fist_pointer = list.head;
		Node slow_pointer = this.head;

		while (fist_pointer != null && fist_pointer.next != null) {
			fist_pointer = fist_pointer.next.next;
			slow_pointer = slow_pointer.next;
		}
		middle_data = slow_pointer.data;
		return middle_data;

	}

	// get N'th node from last
	public int getNodeFromLast(LinkedList1 list, int position) {
		int data = 0;
		int length = 0;
		int count = 0;
		Node current = this.head;
		while (current.next != null) {
			length++;
			current = current.next;
		}

		length = (length - position) + 1;
		Node curr = this.head;
		while (curr.next != null) {
			count++;
			curr = curr.next;
			if (length == count) {
				data = curr.data;
			}
		}

		return data;

	}

	// detect loop
	public boolean detectLoop(LinkedList1 list) {

		boolean result = false;
		LinkedList1 dummy_list = list;
		Node curr = dummy_list.head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = dummy_list.head.next;

		Node fast_pointer = dummy_list.head;
		Node slow_pointer = dummy_list.head;

		while (fast_pointer != null && fast_pointer.next != null) {
			fast_pointer = fast_pointer.next.next;
			slow_pointer = slow_pointer.next;
			if (fast_pointer == slow_pointer) {
				// removeloop(fast_pointer, slow_pointer);
				return true;
			}
		}
		return result;
	}

	public void removeloop(Node fast_pointer, Node slow_pointer) {

	}

	//Remove duplicate node from sorted list
	public LinkedList1 removeDuplicateNode(LinkedList1 list) {

		Node currNode = list.head;
		Node curr_next = null;

		while (currNode != null) {
			curr_next = currNode;
			while (curr_next != null && currNode.data == curr_next.data) {
				System.out.println("*****");
				curr_next = curr_next.next;
			}
			currNode.next = curr_next;
			currNode = currNode.next;
		}
		return list;
	}
	
	public LinkedList1 removeDuplicateFromUnsorted(LinkedList1 list) {
		
		Node currNode = list.head;
		Node temp=null;
		Node dupNode = null;
		while(currNode.next != null) {
			
			temp = currNode;
			while(temp.next !=null) {
				if(currNode.data == temp.next.data) {
					dupNode = temp;// optional
					temp.next = temp.next.next;
				}
				else {
					temp = temp.next;
				}
			}
			currNode = currNode.next;
		}
		return list;
	}

	public void print() {
		Node current = this.head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
	}

	public static void main(String[] args) {

		LinkedList1 list = new LinkedList1();
		list = list.insertion(list, 1);
		list = list.insertion(list, 6);
		list = list.insertion(list, 1);
		list = list.insertion(list, 4);
		list = list.insertion(list, 1);
		list = list.insertion(list, 1);
		list = list.insertion(list, 5);
		list = list.insertion(list, 2);
		list = list.insertion(list, 3);
		list = list.insertion(list, 4);
		list = list.insertion(list, 5);
		
		list = list.insertion(list, 6);
		//list = list.insertion(list, 7);
		//list = list.insertion(list, 8);
		//list = list.insertion(list, 9);
		//list = list.insertion(list, 9);
		//list = list.insertion(list, 9);
		//list = list.insertion(list, 9);
		//list = list.insertion(list, 9);
		//list = list.insertion(list, 10);
		// list = list.insertion(list, 11);
		list.print();

		int midData = list.getMiddle(list);
		System.out.println("\nMiddle data: " + midData);
		int dataFromLast = list.getNodeFromLast(list, 3);
		System.out.println("Node from last: " + dataFromLast);
		// System.out.println("Is Loop detect: " + list.detectLoop(list));

		//list.print();
		//remove duplicate node from sorted list
		//list = list.removeDuplicateNode(list);
		//list.print();
		//remove duplicate node from unsorted list
		list = list.removeDuplicateFromUnsorted(list);
		list.print();

	}
}
