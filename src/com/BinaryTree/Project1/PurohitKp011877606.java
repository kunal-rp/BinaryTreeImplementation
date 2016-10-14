package com.BinaryTree.Project1;

public class PurohitKp011877606 {

	public static void main(String[] args) {
		int[] numbers = {3,2,7,6,5,2,9};
		
		BST bst = new BST();
		for(int i = 0; i < numbers.length; i++){
			bst.insert(numbers[i]);
		}
		bst.inorderTraversal(bst.getRoot());
		System.out.println();
		
	}
	
	//Test Comment
	

}

 class Node{
	int value;
	Node left = null;
	Node right = null;
	
	public Node(int value){
		this.value = value;	
	}
	
	public void addLeft(int valueToAdd){
		left = new Node(valueToAdd);
	}
	
	public void addRight(int valueToAdd){
		right = new Node(valueToAdd);
	}
	public Node getLeft(){
		return left;
	}
	public void setLeft(Node node){
		left = node;
	}
	public Node getRight(){
		return right;
	}
	public void setRight(Node node){
		right = node;
	}
	public int getvalue(){
		return value;
	}
	
}

 class BST{
	
	Node root = null;
	
	public BST(){
	}
	
	public BST(Node root){
		this.root = root;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public void insert(int valueToAdd){
		
		Node node = new Node(valueToAdd);
		
		if(root == null){
			root = node;
		}
		else{
			Node p = root;
			Node q = root;
			while(q != null){
				p = q;
				if(node.getvalue() > p.getvalue() ){
					q = p.getRight();
				}
				else if(node.getvalue() < p.getvalue() ){
					q = p.getLeft();
				}
				else{
					q = null;
				}
			}
			if(node.getvalue() > p.getvalue()){
				p.setRight(node);
			}
			else if(node.getvalue() > p.getvalue()){
				p.setLeft(node);
			}
			
		}
	}
	
	public void inorderTraversal(Node node){
		if(node != null){
			inorderTraversal(node.getLeft());
			System.out.print(node.getvalue()+ " ");
			inorderTraversal(node.getRight());
		}
	}
	
	public void preorderTraversal(Node node){
		if(node != null){
			System.out.print(node.getvalue()+ " ");
			preorderTraversal(node.getLeft());
			preorderTraversal(node.getRight());
		}
	}
	
	public void postorderTraversal(Node node){
		if(node != null){
			postorderTraversal(node.getLeft());
			postorderTraversal(node.getRight());
			System.out.print(node.getvalue()+ " ");
		}
	}
}