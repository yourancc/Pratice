package cn.yourancc.tree;

import java.util.Iterator;

public class RedBlackTree<E>  implements Iterator<E>{
	int total = 0;
	Node root = new Node();
	
	public RedBlackTree() {
	}

	public void add(Comparable<E> element) {
		//如果长度等于0，则直接将数据添加到0；
		if(total == 0) {
			root.element = element;
			total++;
			return;
		}
		Node tempNode = root;
		addEntry(tempNode,element);
	}
	
	public E delete(E element) {
		return null;
	}


	public E[] travel() {
		Node tempNode = root;
		listEntry(tempNode);
		return null;
	} 
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void addEntry(Node addnode,Comparable<E> element) {
		if(addnode.element.compareTo(element)>0) {
			if(addnode.hasLeft()) { 
				addnode = addnode.left();
				addEntry(addnode,element);
			}
			else {
				Node n = new Node();
				addnode.leftChild = n;
				n.element = element;
			}
		}else if(addnode.element.compareTo(element)<0) {
			if(addnode.hasRight()) { 
				addnode = addnode.right();
				addEntry(addnode,element);
			}
			else {
				Node n = new Node();
				addnode.rightChild = n;
				n.element = element;
			}
		}
		
	}

	public void listEntry(Node addnode) {
		if(addnode != null) {
			listEntry(addnode.left());
			System.out.println(addnode.element);
			listEntry(addnode.right());
		}
	}
}
