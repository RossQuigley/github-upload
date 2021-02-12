public class TreeTester {
    public static boolean BSTTest(BTNode node){
        if(node != null){
            if(node.left!=null)
            {
                if(node.left.key > node.key)
                return false;
            }
            if(node.right!=null)
            {
                if(node.right.key < node.key)
                return false;
            }
            if(BSTTest(node.left)==false)
            {
                return false;
            }
            if(BSTTest(node.right)==false)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean BSTTest(BinaryTree b){
        if(BSTTest(b.root)==false)
        return false;

        return true;
    }

    public static void preOrderBT(BTNode node) {
        if (node != null) {
            System.out.println("NODE: " + String.valueOf(node.key));
            preOrderBT(node.left);
            preOrderBT(node.right);
        }
    }

    public static boolean AVLTest(BTNode node){
       if(BSTTest(node) == false)
       return false;

       return true;
    }
}
