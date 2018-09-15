package cn.yourancc.tree;

public class Node<E> {
	Node<E> parent;
	Comparable<E> element;
	Node<E> leftChild;
	Node<E> rightChild;
	
	public boolean hasLeft() {
		return leftChild!=null;
	}
	public boolean hasRight() {
		return rightChild!=null;
	}
	public Node left() {
		return leftChild;
	}
	public Node right() {
		return rightChild;
	}
}
