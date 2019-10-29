public class BST<T> {
    BSTNode<T> root;

    public BST() {

    }

    public void insert(Comparable<T> item) {
        root = insert(root, item);
    }

    private BSTNode<T> insert(BSTNode current, Comparable<T> item) {
        if (current == null)
            return new BSTNode<T>(item);
        else if (current.lessThan(item)|| current.equalTo(item))
            current.setRight( insert(current.getRight(), item) );

        else
            current.setLeft( insert(current.getLeft(), item) );

        return current;
    }

    public boolean find(Comparable<T> item) {
        return find(item, root);
    }

    private boolean find (Comparable<T> item, BSTNode current) {

        // Base case 1: node is null
        if (current == null)
            return false;

        // Recursive case 1: current's data < item
        else if (current.lessThan(item))
            return find(item, current.getRight());

        // Recursive case 2: current's data > item
        else if (current.greaterThan(item))
            return find(item, current.getLeft());

        // Base case 2: node matches
        return true;
    }

    public void print() {
        printNode(root);
    }

    private void printNode(BSTNode current) {
        // Recursive case 1: current node has left child
        if (current.getLeft() != null)
            printNode(current.getLeft());

        // Print current node's data
        System.out.println(current.getData().toString());

        // Recursive case 2: current node has right child
        if (current.getRight() != null)
            printNode(current.getRight());

        // Base case: right child is null (do nothing)
    }

    public void delete (Comparable<T> item) {
        root = delete(root, item);
    }

    // Thanks to https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
    // For code

    public BSTNode delete(BSTNode current, Comparable<T> item) {
        // Base case: null node
        if (current == null)
            return current;

        // Recursive case 1: Current's data is greater than item
        else if (current.greaterThan(item))
            current.setLeft( delete(current.getLeft(), item) );

        // Recursive case 2: Current's data is less than item
        else if (current.lessThan(item))
            current.setRight( delete(current.getRight(), item) );

        // By this point, either exhausted tree (return false)
        // Or found the node to delete

        // Case: Only child on right (return that child)
        else {
            if (current.getLeft() == null)
                return current.getRight();

                // Case: Only child on left (return that child)
            else if (current.getRight() == null)
                return current.getLeft();

            // Case: Two children (set the current node's data = the in order
            // successor's data

            current.setData(findInOrderSuccessor(current.getRight()));
            System.out.println(current.getData().toString());

            // Delete the inorder successor
            current.setRight(delete(current.getRight(), current.getData()));
        }
        // Return current node, leaving all branches untouched except
        // for the one where the current node has been found
        return current;

    }

    private Comparable<T> findInOrderSuccessor(BSTNode current) {
        Comparable<T> successor = current.getData();

        while (current.getLeft() != null) {
            successor = current.getLeft().getData();
            current = current.getLeft();
        }
        return successor;
    }
    }


