public class BSTDriver{

  public static void main(String[] args){
	BST bst = new BST();	

	/* Insert  */
	bst.insert(5);
	bst.insert(4);
	bst.insert(7);
	bst.insert(6);
        bst.insert(8);
	bst.insert(11);
	bst.insert(12);
        bst.insert(21);
	
	
	System.out.println("Before delete");

	bst.printLevelOrder(bst.getRoot());

	/* delete */
	bst.deleteAt(5);

	System.out.println("After delete");		
	
	bst.printLevelOrder(bst.getRoot());

  }

}
