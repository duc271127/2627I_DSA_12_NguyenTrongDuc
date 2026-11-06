import java.io.*;
import java.util.*;

public class Solution {
    static class Node{
        int key;
        Node left ,right;
        public Node(int item){
            key = item;
            left=right= null;
        }
    }
    static Node insert(Node root , int key){
        if(root == null){
            return root = new Node(key);
        }
        if(key > root.key){
            root.right = insert(root.right , key);
        }
        else{
            root.left = insert(root.left , key);
        }
        return root;
    }
    static void preorder(Node root){
        if(root == null) return ;
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for(int i =0 ;i<n;i++){
            int value = sc.nextInt();
            root = insert(root , value);
        }
        preorder(root);
    }


}