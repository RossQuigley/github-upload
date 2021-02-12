public class Main {

    public static void main(String[] args) {
        //AVL TREE SECTION
        Book library[] = FileReader.library("BookList.txt");
        AVLTree t = new AVLTree();

        int bookCount = FileReader.fileSize("BookList.txt");
        System.out.println("-GENERATING AVL TREE-");
        for(int i = 0; i < bookCount; i++ )
        {
            t.root = t.insert(t.root, library[i]);
        }
        System.out.println("-AVL TREE GENERATED-");

        //BINARY TREE SECTION
        System.out.println("\n" + "--------------------------"+"\n");  
        Book libraryCopy[] = FileReader.library("BookList.txt");    
        Book libraryRandomized[] = new Book[bookCount]; 
        Book invalidBook = new Book(-1);
        int min = 0;
        int max = bookCount-1;

        for(int i = 0; i < bookCount; i++ )
        {
            int r = (int)(Math.random()*(max-min+1)+min);
            if(libraryCopy[r].getISBN() != -1){
                libraryRandomized[i] = libraryCopy[r];
                libraryCopy[r] = invalidBook;
            }
            else{
                i--;
            }
        }

        //CREATION AND INSERTION
        BinaryTree b = new BinaryTree(); 
        //ROOT
        b.root = new BTNode(libraryRandomized[0].getISBN());
        //TOP TIER
        b.root.left = new BTNode(libraryRandomized[1].getISBN());
        b.root.right = new BTNode(libraryRandomized[2].getISBN());
        //MID TIER
        b.root.left.left = new BTNode(libraryRandomized[3].getISBN());
        b.root.left.right = new BTNode(libraryRandomized[4].getISBN());
        b.root.right.left = new BTNode(libraryRandomized[5].getISBN());
        b.root.right.right = new BTNode(libraryRandomized[6].getISBN());
        //MID TIER
        b.root.left.left.left = new BTNode(libraryRandomized[7].getISBN());
        b.root.left.left.right = new BTNode(libraryRandomized[8].getISBN());
        b.root.left.right.left = new BTNode(libraryRandomized[9].getISBN());
        b.root.left.right.right = new BTNode(libraryRandomized[10].getISBN());
        b.root.right.left.left = new BTNode(libraryRandomized[11].getISBN());
        b.root.right.left.right = new BTNode(libraryRandomized[12].getISBN());
        b.root.right.right.left = new BTNode(libraryRandomized[13].getISBN());
        b.root.right.right.right = new BTNode(libraryRandomized[14].getISBN());
        //BOTTOM TIER (LEAVES)
        b.root.left.left.left.left = new BTNode(libraryRandomized[15].getISBN());
        b.root.left.left.left.right = new BTNode(libraryRandomized[16].getISBN());
        b.root.left.left.right.left = new BTNode(libraryRandomized[17].getISBN());
        b.root.left.left.right.right = new BTNode(libraryRandomized[18].getISBN());
        b.root.left.right.left.left = new BTNode(libraryRandomized[19].getISBN());
        b.root.left.right.left.right = new BTNode(libraryRandomized[20].getISBN());
        b.root.left.right.right.left = new BTNode(libraryRandomized[21].getISBN());
        b.root.left.right.right.right = new BTNode(libraryRandomized[22].getISBN());
        b.root.right.left.left.left = new BTNode(libraryRandomized[23].getISBN());
        b.root.right.left.left.right = new BTNode(libraryRandomized[24].getISBN());

        System.out.println("-BINARY TREE GENERATED-");

        if(TreeTester.BSTTest(b)==true)
        {
            System.out.println("THE BINARY TREE IS A BINARY SEARCH TREE");

            AVLTree test = new AVLTree();
            for(int i = 0; i < bookCount; i++ ) {
                test.root = test.insert(test.root, libraryRandomized[i]);
            }
            if (test.getUnadjusted() == true) {
                System.out.println("THE BINARY TREE IS AN AVL TREE");
            }
            else {
                System.out.println("THE BINARY TREE IS NOT AN AVL TREE");
            }
        }
        else
        {
            System.out.println("THE BINARY TREE IS NOT A BINARY SEARCH TREE \nTHEREFORE NOT AN AVL TREE");
        }
    }  
}