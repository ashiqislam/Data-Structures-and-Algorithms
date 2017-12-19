import java.util.*;
public class BinarySearchTree
{
    public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        BST bst = new BST();          
        bst.Insert(50);
        bst.Insert(40);
        bst.Insert(80);
        bst.Insert(20);
        bst.Insert(45);
        bst.Insert(60);
        bst.Insert(90);
        bst.Insert(55);
        bst.Insert(65);
        bst.inorderTraversal();
        System.out.println("\n");
        System.out.print("Is 20 in the tree? ");
        System.out.println(bst.search(20)); 
        System.out.println("\n");
        bst.delete(20);
        bst.inorderTraversal();
        System.out.println("\n");
        System.out.print("Is 80 in the tree? ");
        System.out.println(bst.search(80));
        System.out.println("\n");
        bst.delete(80);
        bst.inorderTraversal();

    }
}