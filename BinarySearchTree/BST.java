public class BST
 {
     private BSTNode root;
 
     public BST()
     {
         root = null;
     }

     public boolean isEmpty()
     {
         return root == null;
     }
 
     public void Insert(int data)
     {
         root = Insert(root, data);
     }

     private BSTNode Insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = Insert(node.left, data);
             else
                 node.right = Insert(node.right, data);
         }
         return node;
     }

     public void delete(int i)
     {
         if (isEmpty())
             System.out.println("Tree is Empty");
         else if (search(i) == false)
             System.out.println("Sorry "+ i +" is not present");
         else
         {
             root = delete(root, i);
             System.out.println(i+ " has been deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, int j)
     {
         BSTNode p, p2, n;
         if (root.getData() == j)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (j < root.getData())
         {
             n = delete(root.getLeft(), j);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), j);
             root.setRight(n);             
         }
         return root;
     }
     
     public boolean search(int val)
     {
         return search(root, val);
     }

     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }

     public void inorderTraversal()
     {
         inorderTraversal(root);
     }
     
     private void inorderTraversal(BSTNode r)
     {
         if (isEmpty())
             System.out.println("Tree is Empty");
         if (r != null)
         {
             inorderTraversal(r.getLeft());
             System.out.print(r.getData() +" ");
             inorderTraversal(r.getRight());
         }
     }
     
 }
 