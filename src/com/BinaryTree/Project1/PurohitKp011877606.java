package com.BinaryTree.Project1;

public class PurohitKp011877606 {

	public static void main(String[] args) {
		

	}
	
	
	private class Node{
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
		public Node getRight(){
			return right;
		}
		
	}
	

}
