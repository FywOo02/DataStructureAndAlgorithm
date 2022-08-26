package Tree.HuffmanTree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Cho
 * @Date: 2022/8/23 10:10
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            //sort
            Collections.sort(nodes);
            System.out.println(nodes);
            //get two nodes with the smallest weights
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //create a new binary tree
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // delete the used nodes from arraylist
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // add the parent node to arraylist
            nodes.add(parent);

        }
        return nodes.get(0);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else {
            System.out.println("this huffman tree is empty");
        }
    }
}

class Node implements Comparable<Node>{
    public int value;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(@NotNull Node o) {
         return this.value - o.value;
    }
}

