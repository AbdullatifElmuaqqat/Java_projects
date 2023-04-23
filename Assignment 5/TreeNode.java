
public class TreeNode <T> {
	
	protected TreeNode<T> rightChild;
	protected TreeNode<T> leftChild;
	private T data;
	
	public TreeNode() {
		
	}
	public TreeNode(T dataNode) {
		this.rightChild = null;
		this.leftChild = null;
		this.data = dataNode;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
		this.data = node.getData();
//		leftChild = node.leftChild;
//		rightChild = node.rightChild;
	}
	
	public T getData() {
		return data;
	}
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
//	public void setLeftChild(TreeNode<T> newLeftChild)
//	   {
//	      leftChild = newLeftChild;
//	   }
//	
//	public void setRightChild(TreeNode<T> newRightChild)
//	   {
//		rightChild = newRightChild;
//	   }
	
	

}
