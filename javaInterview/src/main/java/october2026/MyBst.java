package october2026;

public class MyBst {
    public Node rootNode;

    public MyBst(int root) {
        this.rootNode = new Node(root);
    }

    public void insert(int value) {
        rootNode = insert(rootNode, value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.element) {
            node.left = insert(node.left, value);
        } else if (value > node.element) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public void showAll(Node cnode) {
        if (cnode == null) {
            return;
        }
        System.out.print(cnode.element + "->");
        showAll(cnode.left);
        showAll(cnode.right);
    }

    static final class Node {
        int element;
        Node left, right;

        Node(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

    }

}

class Test3 {

    public static void main(String[] args) {
        MyBst nst = new MyBst(3);
        nst.insert(2);
        nst.insert(4);
        nst.insert(5);

        nst.insert(7);
        nst.showAll(nst.rootNode);
    }
}
