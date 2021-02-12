// Java program for insertion in AVL Tree
class Node {
	int key, height;
	Node left, right;
	Book book;

	Node(Book b) {
		height = 1;
		book = b;
		key = book.getISBN();
	}
}

class AVLTree {

	Node root;
	boolean unadjusted = true;

	// A utility function to see if any rotations were necessary upon insertion to maintain AVL tree status
	boolean getUnadjusted()
	{
		return unadjusted;
	}

	// A utility function to get the height of the tree
	int height(Node N) {
		if (N == null)
			return 0;

		return N.height;
	}

	// A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	int getBalance(Node N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	// LEGACY INSERT FUNCTION
	Node insert(Node node, int key) {

		/* 1. Perform the normal BST insertion */
		if (node == null){
			Book b = new Book(key);
			return (new Node(b));
		}
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else // Duplicate keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left),
							height(node.right));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	//INSERT FUNCTION USING BOOK OBJECT
	Node insert(Node node, Book b) {

		/* 1. Perform the normal BST insertion */
		if (node == null){
			//Book b = new Book(key);
			return (new Node(b));
		}
		if (b.getISBN() < node.key)
			node.left = insert(node.left, b);
		else if (b.getISBN() > node.key)
			node.right = insert(node.right, b);
		else // Duplicate keys not allowed
			return node;

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left),
							height(node.right));

		/* 3. Get the balance factor of this ancestor
			node to check whether this node became
			unbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && b.getISBN() < node.left.key){
			System.out.println("Imbalance occurred while inserting ISBN " + b.getISBNString() + "; fixed in RIGHT Rotation");
			unadjusted = false;
			return rightRotate(node);
		}
		// Right Right Case
		if (balance < -1 && b.getISBN() > node.right.key){
			System.out.println("Imbalance occurred while inserting ISBN " + b.getISBNString() + "; fixed in LEFT Rotation");
			unadjusted = false;
			return leftRotate(node);
		}
		// Left Right Case
		if (balance > 1 && b.getISBN() > node.left.key) {
			System.out.println("Imbalance occurred while inserting ISBN " + b.getISBNString() + "; fixed in LEFT RIGHT Rotation");
			unadjusted = false;
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && b.getISBN() < node.right.key) {
			System.out.println("Imbalance occurred while inserting ISBN " + b.getISBNString() + "; fixed in RIGHT LEFT Rotation");
			unadjusted = false;
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	// A utility function to print preorder traversal
	// of the tree.
	// The function also prints height of every node
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//TEST MAIN
	// public static void main(String[] args) {
	// 	AVLTree tree = new AVLTree();

	// 	/* Constructing tree given in the above figure */
	// 	tree.root = tree.insert(tree.root, 10);
	// 	tree.root = tree.insert(tree.root, 20);
	// 	tree.root = tree.insert(tree.root, 30);
	// 	tree.root = tree.insert(tree.root, 40);
	// 	tree.root = tree.insert(tree.root, 50);
	// 	tree.root = tree.insert(tree.root, 25);

	// 	/* The constructed AVL Tree would be
	// 		30
	// 		/ \
	// 	  20   40
	// 	 / \     \
	// 	10  25    50
	// 	*/
	// 	System.out.println("Preorder traversal" +
	// 					" of constructed tree is : ");
	// 	tree.preOrder(tree.root);
	// }
}
// This code has been contributed by Mayank Jaiswal