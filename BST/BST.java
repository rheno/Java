
class Node{
   
   public int data;
   public Node left;
   public Node right;

   public Node(int d, Node l, Node r){
	data = d;
        left = l;
        right = r;
   }
    
}

public class BST{

  public Node insert(int data, Node root){
      
      if(root == null){
	 root = new Node(data, null, null);
      }else if(data > root.data){
	 root.right = insert(data, root.right);
      }else if(data < root.data){
	 root.left = insert(data, root.left);
      }
   
      return root;
  }   

  public int width(Node root){

      if(root == null){
	 return 0;
      }

      return 1+width(root.left)+width(root.right);
  }

  public int height(Node root){
      
       if(root == null){
	   return 0;
       }

       int l = 1+height(root.left);
       int r = 1+height(root.right);	 
   
       if(l > r){
	 return l;	
       }

       return r;
  }

  public void printBST(Node root){
      
      if(root == null){
	return;
      }
      System.out.println(root.data);	
      printBST(root.left);
      printBST(root.right);
  }
  

}
