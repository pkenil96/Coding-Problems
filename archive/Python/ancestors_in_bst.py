'''This python program prints the ancestors of a given node'''
class TreeNode:
	'''Node class for binary tree'''
	def __init__(self, data):
		self.left = None
		self.right = None
		self.data = data


class BST:
	'''Binary Search Tree class'''
	def __init__(self):
		'''Constructor to initialize root node'''
		self.root = None

	def __print_inorder(self, cur_node):
		"""This method prints the tree in inorder fashion"""
		if cur_node:
			self.__print_inorder(cur_node.left)
			print(cur_node.data)
			self.__print_inorder(cur_node.right)

	def inorder(self):
		"""Public method to print the inorder
		traversal of the binary search tree
		"""
		self.__print_inorder(self.root)

	def print_ancestors(self, root, node):
		"""Public method to print the ancestors of
		the node using root node
		"""

if __name__ == '__main__':
	BST01 = BST()
	BST01.root = TreeNode(34)
	BST01.root.left = TreeNode(56)
	BST01.root.right = TreeNode(91)
	BST01.root.left.right = TreeNode(66)
	BST01.root.left.left = TreeNode(16)
	BST01.root.right.left = TreeNode(12)
	BST01.root.right.right = TreeNode(2)
	BST01.inorder()
