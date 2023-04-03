package Tree;

class ExpTree {
    static class Node {
        private String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public int evaluate(Node root) {
        if (!"*-+/".contains(root.data)) {
            return Integer.parseInt(root.data);
        }

        int left = evaluate(root.left);
        int right = evaluate(root.right);
        if ("*".equals(root.data)) return left * right;
        else if ("+".equals(root.data)) return left + right;
        else if ("-".equals(root.data)) return left - right;
        else return left / right;
    }
}

public class ArithmeticExpression {
    public static void main(String[] args) {
        ExpTree tree = new ExpTree();
        tree.root = new ExpTree.Node("+");
        tree.root.left = new ExpTree.Node("*");
        tree.root.left.left = new ExpTree.Node("5");
        tree.root.left.right = new ExpTree.Node("-4");
        tree.root.right = new ExpTree.Node("-");
        tree.root.right.left = new ExpTree.Node("100");
        tree.root.right.right = new ExpTree.Node("20");

        System.out.println(tree.evaluate(tree.root));
    }
}
