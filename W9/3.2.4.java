import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int key;
        Node left,right;
        public Node(int item){
            key = item;
            left=right = null;
        }
    }
    public static Node insert(Node root , int key){
        if(root == null) return new Node(key);
        if(key > root.key){
            root.right = insert(root.right, key);
        }
        else{
            root.left = insert(root.left , key);
        }
        return root;
    }

    public static Node LCA(Node root , int key1 , int key2){
        if(root==null ) return root;
        if(root.key > key1 && root.key > key2){
            return LCA(root.left, key1 , key2);
        }
        if(root.key < key1 && root.key < key2){
            return LCA(root.right , key1, key2);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        for(int i =0 ; i<n;i++){
            int s = sc.nextInt();
            root= insert(root, s);
        }
        int key1= sc.nextInt();
        int key2= sc.nextInt();
        Node ans = LCA(root , key1,key2);
        System.out.print(ans.key);
    }
}