package com.BinaryTree.Project1;

public class PurohitKp011877606 {

	public static void main(String[] args) {
		

	}
	
	
	public class Node{
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

	public class BST{
		
		Node root = null;
		
		public BST(Node root){
			this.root = root;
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
						System.out.println("Value Already exists in the BST.");
						System.exit(0);
					}
				}
				if(node.getvalue() > p.getvalue()){
					p.setRight(node);
				}
				else{
					p.setLeft(node);
				}
				
			}
		}
		
	}

}
