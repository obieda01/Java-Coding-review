/*
O(N) time AND space

The the basic idea is to take the last element in postorder array as the root,
find the position of the root in the inorder array; 
then locate the range for left sub-tree and right sub-tree and do recursion
. Use a HashMap to record the index of root in the inorder array.

*/

public TreeNode InPosTreeBuilder(int[] inorder, int[] postorder) {
    if (inorder.length != postorder.length||inorder == null || postorder == null  )
        return null;
    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    for (int i=0;i<inorder.length;++i)
        map.put(inorder[i], i);
    return InPosTreeBuilder(inorder, 0, inorder.length-1, postorder, 0, 
                          postorder.length-1,map);
}

private TreeNode InPosTreeBuilder(int[] inorder, int inStr, int inEnd, int[] postorder, int preStr, int preEnd, 
                                 HashMap<Integer,Integer> map)
            {
    if ( inStr>inEnd ||preStr>preEnd ) return null; //base case
    TreeNode root = new TreeNode(postorder[preEnd]);
    int rootIndex = map.get(postorder[preEnd]);
    TreeNode leftchild = InPosTreeBuilder(inorder, inStr, rootIndex-1, postorder, preStr, preStr+rootIndex-inStr-1, map);
    TreeNode rightchild = InPosTreeBuilder(inorder,rootIndex+1, inEnd, postorder, preStr+rootIndex-inStr, preEnd-1, map);
    root.left = leftchild;
    root.right = rightchild;
    return root;
}



public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = TreeNode.createMinimalBST(array);
		int in[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		int post[] = {8, 4, 5, 2, 6, 7, 3, 1}; 
		
			BTreePrinter.printNode(InPreTreeBuilder(in,post));
		
	
		
	}
		/**    
			1               
		      / \       
		     /   \      
		    /     \     
		   /       \    
		   2       3       
		  / \     / \   
		 /   \   /   \  
		 4   5   6   7   
		  \             
		  8
		  
		  **/
	
	
	
	
