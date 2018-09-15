package cn.yourancc.tree;

public class Entry {

	public static void main(String[] args) {
		RedBlackTree<String> tree = new RedBlackTree<>();
		
		tree.add("13");
		tree.add("52");
		tree.add("44");
		tree.add("34");
		tree.add("12");
		tree.add("2");
		tree.add("35");
		tree.add("46");
		
		tree.travel();
	}

}
