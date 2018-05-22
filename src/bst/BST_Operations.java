package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;

class BST {
	
	class Node {
		int key;
		Node parent;
		Node left;
		Node right;
		
		Node(int key) {
			this.key = key;
		}
	}
	
	Node root = null;
	int numNodes = 0;
	int height = -1;
	
	void recursivePostOrderTreeWalk() {
		System.out.print("<");
		recPostOrderWalk(root);
		System.out.println(">");
	}
	
	private void recPostOrderWalk(Node node) {
		if (node != null) {
			recPostOrderWalk(node.left);
			recPostOrderWalk(node.right);
			System.out.print(" " + node.key + " ");
		}
	}
	
	void iterativePostOrderTreeWalk() {
		Node current;
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		
		stack1.push(root);
		while(!stack1.isEmpty()) {
			current = stack1.pop();
			stack2.push(current);
			if(current.left != null)
				stack1.push(current.left);
			if(current.right != null)
				stack1.push(current.right);
		}
		System.out.print("<");
		while(!stack2.isEmpty()) {
			System.out.printf(" %d ", stack2.pop().key);
		}
		
		System.out.println(">");
	}

	void recursivePreOrderTreeWalk() {
		System.out.print("<");
		recPreOrderWalk(root);
		System.out.println(">");
	}
	
	private void recPreOrderWalk(Node node) {
		if (node != null) {
			System.out.print(" " + node.key + " ");
			recPreOrderWalk(node.left);
			recPreOrderWalk(node.right);
		}
	}
	
	void iterativePreOrderTreeWalk() {
		System.out.print("<");
		
		Node node = root;
		while(node != null) {
			if (node.left == null) {
				System.out.printf(" %d ", node.key);
				node = node.right;
			}
			else {
				Node current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}
				
				if(current.right == node) {
					current.right = null;
					node = node.right;
				}
				else {
					System.out.printf(" %d ", node.key);
					current.right = node;
					node = node.left;
				}
			}
		}	
		
		System.out.println(">");
	}

	
	void recursiveInOrderTreeWalk() {
		System.out.print("<");
		recInOrderWalk(root);
		System.out.println(">");
	}
	
	private void recInOrderWalk(Node node) {
		if (node != null) {
			recInOrderWalk(node.left);
			System.out.print(" " + node.key + " ");
			recInOrderWalk(node.right);
		}
	}

	void iterativeInOrderTreeWalk() {
		Node current = root;
		Stack stack = new Stack();
		
		System.out.print("<");
		while(current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(" " + current.key + " ");
				current = current.right;
			}
		}
		System.out.println(">");
	}

	void insert(int key) {
		Node newNode = new Node(key);
		Node parent = null;
		Node current = root;
		
		int pathLength = 0;
		while (current != null) {
			parent = current;
			if (key < current.key) 
				current = current.left;
			else
				current = current.right;
			pathLength++;
		}
		newNode.parent = parent;

		if(parent == null) {
			// empty tree
			root = newNode; 
		}
		else if (key < parent.key) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}

		numNodes++;
		if (pathLength > height) {
			height = pathLength;
		}
	}
	
	void display() {
		if (root != null) {
			ArrayList<Node> level = new ArrayList<>(Arrays.asList(root));
			ArrayList<Node> nextLevel = new ArrayList<>();
			for (int levelNum = 0; levelNum <= height; levelNum++) {
				displayLevel(level, levelNum);
				nextLevel.clear();
				Node node;
				for(int i = 0; i < level.size(); i++) {
					node = level.get(i);
					if(node == null) {
						nextLevel.add(null);
						nextLevel.add(null);	
					}
					else {
						nextLevel.add(node.left);
						nextLevel.add(node.right);
					}
				}
				level.clear();
				level.addAll(nextLevel);
			}
		}
		System.out.println();
	}
	
	private void displayLevel(ArrayList<Node> nodes, int level) {
		StringBuffer sb = new StringBuffer();
		
		// Compute where to print nodes
		int initialNodeOffsetNum = (int) (Math.pow(2, height - level) - 1);
		for (int i = 0; i < initialNodeOffsetNum; i++)
			sb.append("   ");
		String nodeSpacer = sb.toString();
		
		// Compute where to print edges
		int initialEdgeOffsetNum = initialNodeOffsetNum / 2;
		sb = new StringBuffer();
		for (int i = 0; i < initialEdgeOffsetNum; i++)
			sb.append("   ");
		String edgeSpacer = sb.toString();
		
		StringBuilder nodeLine = new StringBuilder(nodeSpacer);
		StringBuilder edgeLine = new StringBuilder(edgeSpacer);
		
		Node node;
		String filler = "   ";
		for (int i = 0; i < nodes.size(); i++) {
			node = nodes.get(i);
			nodeLine.append(node != null? String.format("%3d", node.key) : filler);
			nodeLine.append(nodeSpacer + filler + nodeSpacer);
			if (node != null) {
				edgeLine.append(node.left != null? "  /" : filler);
				edgeLine.append(edgeSpacer + filler + edgeSpacer);
				edgeLine.append(node.right != null? " \\ " : filler);
				edgeLine.append(edgeSpacer + filler + edgeSpacer);
			}
			else {
				edgeLine.append(filler);
				edgeLine.append(edgeSpacer + filler + edgeSpacer);
				edgeLine.append(filler);
				edgeLine.append(edgeSpacer + filler + edgeSpacer);
			}
		}
		System.out.println(nodeLine);
		System.out.println(edgeLine);	
	}
	
	class Stack {
		private ArrayList<Node> nodeStack = new ArrayList<>();
		
		void push(Node node) {
			nodeStack.add(node);
		}
		
		Node pop() {
			if(nodeStack.isEmpty())
				throw new EmptyStackException();
			return  nodeStack.remove(nodeStack.size() - 1);
		}
		
		boolean isEmpty() {
			return nodeStack.isEmpty();
		}
	}
}

public class BST_Operations {

	public static void main(String[] args) {
		BST bst = generateBST(10, 999);
		bst.display();
		
		System.out.print("Recursive Post-Order: ");
		bst.recursivePostOrderTreeWalk();
		System.out.print("Iterative Post-Order: ");
		bst.iterativePostOrderTreeWalk();
		
		System.out.println();
		
		System.out.print("Recursive Pre-Order:  ");
		bst.recursivePreOrderTreeWalk();
		System.out.print("Iterative Pre-Order:  ");
		bst.iterativePreOrderTreeWalk();
		
		System.out.println();
		
		System.out.print("Recursive In-Order:   ");
		bst.recursiveInOrderTreeWalk();
		System.out.print("Iterative In-Order:   ");
		bst.iterativeInOrderTreeWalk();
		
		System.out.println();

	}
	
	private static BST generateBST(int n, int max) {
		BST bst = new BST();
		
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			bst.insert(r.nextInt(max + 1));
		}
		
		return bst;
		
	}

}
