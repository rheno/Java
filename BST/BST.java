import java.util.Queue;
import java.util.LinkedList;

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

  private Node root;

  public BST(){
	this.root = null;
  }

  public Node getRoot(){
	return root;
  }

  public void insert(int data){
	this.root = insert(data, this.root);
  }

  public Node insert(int data, Node root){
      
      if(root == null){
	 root = new Node(data, null, null);
      }else if(root.data > data){
	 root.left = insert(data, root.left);
      }else if(root.data < data){
	 root.right = insert(data, root.right);
      }
   
      return root;
  }   

  public void deleteAt(int data){
	this.root = deleteAt(data, this.root);
  }

  public Node deleteAt(int data, Node root){
	if(root == null){
		root = null;
	}else if(root.data == data){
		if(root.left == null && root.right == null){
			root = null;
		}else if(root.left != null && root.right == null){
			Node del = root;
			root = root.left;
			del = null;
		}else if(root.left == null && root.right != null){
			Node del = root;
			root = root.right;
			del = null;
		}else if(root.left != null && root.right != null){
			Node right = root.right;
			root = root.left;
			getMostRight(root).right = right;
		}
	}else if(root.data > data){
		root.left = deleteAt(data, root.left);
	}else if(root.data < data){
		root.right = deleteAt(data, root.right);
	}	
	
	return root;
  }

  public Node getMostRight(Node root){
	
	if(root == null){
		return null;
	}
		
	if(root.right == null){
		return root;
	}
	
	return getMostRight(root.right);		
  }

  public Node getMostLeft(Node root){
	if(root == null){
		return null;
	}

	if(root.left == null){
		return root;
	}

	return getMostLeft(root.left);
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

  public void printPreOrder(Node root){
	if(root == null){
		return;
	}

	printPreOrder(root.left);
	System.out.println(root.data);
	printPreOrder(root.right);

  }

  public void printInOrder(Node root){
      
      if(root == null){
	return;
      }
      System.out.println(root.data);	
      printInOrder(root.left);
      printInOrder(root.right);
  }

  public void printPostOrder(Node root){
	if(root == null){
		return;
	}
	
	printPostOrder(root.left);
	printPostOrder(root.right);
	System.out.println(root.data);
  }

  public void printLevelOrder(Node root){
	if(root == null){
		return;
	}

	Queue<Node> q = new LinkedList<Node>();
	q.add(root);

	while(q.size() != 0){
		
		int size = q.size();
		
		while(size > 0){
			Node curr = q.peek();
			System.out.print(curr.data+" ");
			if(curr.left != null){
				q.add(curr.left);
			}

			if(curr.right != null){
				q.add(curr.right);
			}
			size--;					
			q.remove();
		}
		System.out.println();
	}
  }
  

}
