public class BSTNodeDemo {
    public static void main(String[] args) {
        BSTNode<String> node = new BSTNode<>("Hi");

        BSTNode<String> node2 = new BSTNode<>("Hi");

        System.out.println(node.lessThan(node2.getData()));
        System.out.println(node.equalTo(node2.getData()));
        System.out.println(node.greaterThan(node2.getData()));

    }
}
