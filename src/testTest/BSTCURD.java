package testTest;

public class BSTCURD {
	
	//查找值为val的节点，如果val小于根节点则在左子树中查找，反之在右子树中查找
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}// 未找到值为val的节点
		if (val < root.val) {
			return searchBST(root.left, val);//val小于根节点值，在左子树中查找
		} else if (val > root.val) {
			return searchBST(root.right, val);//val大于根节点值，在右子树中查找
		} else {
			return root;//找到了
		}
	}
	
	//修改仅仅需要在查找到需要修改的节点之后，更新这个节点的值就可以了 (假如修改过后整棵树还满足BST的性质)
	public void updateBST(TreeNode root, int target, int val) {
		if (root == null) {
			return;
		}// 未找到target节点
		if (target < root.val) {
			updateBST(root.left, target, val);//target小于根节点值，在左子树中查找
		} else if (target > root.val) {
			updateBST(root.right, target, val);//target大于根节点值，在右子树中查找
		} else { //找到了
			root.val = val;
		}
	}
	
	//根节点为空，则待添加的节点为根节点
	//如果待添加的节点值小于根节点，则在左子树中添加
	//如果待添加的节点值大于根节点，则在右子树中添加
	//我们统一在树的叶子节点(Leaf Node)后添加
	public TreeNode insertNode(TreeNode root, TreeNode node) {
	    if (root == null) {
	        return node;
	    }
	    if (root.val > node.val) {
	        root.left = insertNode(root.left, node);
	    } else {
	        root.right = insertNode(root.right, node);
	    }
	    return root;
	}
	//考虑待删除的节点为叶子节点，可以直接删除并修改父亲节点(Parent Node)的指针，需要区分待删节点是否为根节点
	//考虑待删除的节点为单支节点(只有一棵子树——左子树 or 右子树)，与删除链表节点操作类似，同样的需要区分待删节点是否为根节点
	//考虑待删节点有两棵子树，可以将待删节点与右子树中的最小节点进行交换，由于右子树中的最小节点一定为叶子节点，所以这时再删除待删的节点可以参考第一条
	public TreeNode removeNode(TreeNode root, int value) {
	    TreeNode dummy = new TreeNode(0);
	    dummy.left = root;
	    TreeNode parent = findNode(dummy, root, value);
	    TreeNode node;
	    if (parent.left != null && parent.left.val == value) {
	        node = parent.left;
	    } else if (parent.right != null && parent.right.val == value) {
	        node = parent.right;
	    } else {
	        return dummy.left;
	    }
	    deleteNode(parent, node);
	    return dummy.left;
	}

	private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
	    if (node == null) {
	        return parent;
	    }
	    if (node.val == value) {
	        return parent;
	    }
	    if (value < node.val) {
	        return findNode(node, node.left, value);
	    } else {
	        return findNode(node, node.right, value);
	    }
	}

	private void deleteNode(TreeNode parent, TreeNode node) {
	    if (node.right == null) {
	        if (parent.left == node) {
	            parent.left = node.left;
	        } else {
	            parent.right = node.left;
	        }
	    } else {
	        TreeNode temp = node.right;
	        TreeNode father = node;
	        while (temp.left != null) {
	            father = temp;
	            temp = temp.left;
	        }
	        if (father.left == temp) {
	            father.left = temp.right;
	        } else {
	            father.right = temp.right;
	        }
	        if (parent.left == node) {
	            parent.left = temp;
	        } else {
	            parent.right = temp;
	        }
	        temp.left = node.left;
	        temp.right = node.right;
	    }
	}
}
