package com.BinaryTree.Project1;

import java.util.Scanner;

public class PurohitKp011877606 {

	public static void main(String[] args) {
		int[] numbers = {};
		
		BinarySearchTree bst = new BinarySearchTree();


		Scanner in = new Scanner(System.in);///reads input
		int base = 1;
		while(base>0){
			System.out.print("Command:");
			char command = in.next().charAt(0);
			switch(command){//switches through all command possibilities
				case 'A': int number = in.nextInt();
					bst.insert(number);
					break;
				case 'P':System.out.println("Inorder:");
					bst.inorderTraversal(bst.getRoot());
					System.out.println();
					System.out.println("Preorder:");
					bst.preorderTraversal(bst.getRoot());
					System.out.println();
					System.out.println("Postorder:");
					bst.postorderTraversal(bst.getRoot());
					System.out.println();
					break;
				case 'D':int delete = in.nextInt();
					bst.delete(delete);
					break;
				case 'Q':
					base = 0;
					break;
			}


		}





	}
	

	

}

 class Node{//Node class only needs variable initializations and constructor
	 int data;
	 Node left;
	 Node right;
	 public Node(int data){
		 this.data = data;
		 left = null;
		 right = null;
	 }
	
}

 class BinarySearchTree{

	 public static  Node root;
	 public BinarySearchTree(){
		 this.root = null;
	 }//basic constructor



	 public Node getRoot(){
		 return root;
	 }//returns the root of the BST

	 public boolean delete(int id){//deletes node
		 Node parent = root;
		 Node current = root;
		 boolean isLeftChild = false;
		 while(current.data!=id){//first finds the integer
			 parent = current;
			 if(current.data>id){
				 isLeftChild = true;
				 current = current.left;
			 }else{
				 isLeftChild = false;
				 current = current.right;
			 }
			 if(current ==null){//exits program if integer is not found
				 System.out.println("Integer not in tree");
				 return false;
			 }
		 }
		 //if node has no children
		 if(current.left==null && current.right==null){
			 if(current==root){
				 root = null;
			 }
			 if(isLeftChild ==true){
				 parent.left = null;
			 }else{
				 parent.right = null;
			 }
		 }
		 //if node has left child
		 else if(current.right==null){
			 if(current==root){
				 root = current.left;
			 }else if(isLeftChild){
				 parent.left = current.left;
			 }else{
				 parent.right = current.left;
			 }
		 }
		 //if node has right child
		 else if(current.left==null){
			 if(current==root){
				 root = current.right;
			 }else if(isLeftChild){
				 parent.left = current.right;
			 }else{
				 parent.right = current.right;
			 }
		 }else if(current.left!=null && current.right!=null){//if node has both child

			 //we need to first get sucsessor node
			 Node successor	 = getSuccessor(current);
			 if(current==root){
				 root = successor;
			 }else if(isLeftChild){
				 parent.left = successor;
			 }else{
				 parent.right = successor;
			 }
			 successor.left = current.left;
		 }
		 return true;
	 }

	 //gets the sucssessor node of a given node in BST
	 public Node getSuccessor(Node deleleNode){
		 Node successsor =null;
		 Node successsorParent =null;
		 Node current = deleleNode.right;
		 while(current!=null){
			 successsorParent = successsor;
			 successsor = current;
			 current = current.left;
		 }


		 if(successsor!=deleleNode.right){
			 successsorParent.left = successsor.right;
			 successsor.right = deleleNode.right;
		 }
		 return successsor;
	 }

	 public void insert(int id){//inserting function
		 Node newNode = new Node(id);
		 if(root==null){
			 root = newNode;
			 return;
		 }
		 Node current = root;
		 Node parent = null;
		 while(true){
			 parent = current;
			 if(id<current.data){
				 current = current.left;
				 if(current==null){//occurs when we reached leaf
					 parent.left = newNode;
					 return;
				 }
			 }else if(id>current.data){
				 current = current.right;
				 if(current==null){//occurs when we reached leaf
					 parent.right = newNode;
					 return;
				 }
			 }else{//occurs when node already exists in BST
				 System.out.println("Trying to insert existing value");
				 break;
			 }
		 }
	 }
	
	public void inorderTraversal(Node node){
		if(node != null){
			inorderTraversal(node.left);
			System.out.print(node.data+ " ");
			inorderTraversal(node.right);
		}
	}
	
	public void preorderTraversal(Node node){
		if(node != null){
			System.out.print(node.data+ " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	public void postorderTraversal(Node node){
		if(node != null){
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data+ " ");
		}
	}





}