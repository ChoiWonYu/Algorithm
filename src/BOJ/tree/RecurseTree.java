package BOJ.tree;

import java.io.*;

class Node {

    char data;
    Node left;
    Node right;

    public Node(final char data) {
        this.data = data;
    }
}

class Tree {

    Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            root.left = leftData == '.' ? null : new Node(leftData);
            root.right = rightData == '.' ? null : new Node(rightData);
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    private void searchNode(final Node node, final char data,
        final char leftData, final char rightData) {
        if (node == null) {
            return;
        } else if (node.data == data) {
            node.left = leftData == '.' ? null : new Node(leftData);
            node.right = rightData == '.' ? null : new Node(rightData);
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}

public class RecurseTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char root = input.charAt(0);
            char left = input.charAt(2);
            char right = input.charAt(4);
            tree.createNode(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
}
