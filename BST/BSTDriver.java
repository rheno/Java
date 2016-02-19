
public class BSTDriver{
  
  public static void main(String[] args){ 

      Node root = null;
      BST bst = new BST();
      root = bst.insert(5,root);
      root = bst.insert(1,root);
      root = bst.insert(7,root);
     
      bst.printBST(root);
    	   
      System.out.println("Width = "+bst.width(root));
      System.out.println("Height = "+bst.height(root));
     
  }
}
