"""This is an implementation of binary search tree
    As per the pep8 convention,
    1) All the methods beginning with __ will be private to
    the class
"""

import logging

logging.basicConfig(filename='bst.log', filemode='w')
LOGGER = logging.getLogger('BST')
LOGGER.setLevel(logging.DEBUG)


class TreeNode:
    '''Node class for Binary Search Tree'''
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None
        self.node_freq = 0

    def get(self):
        '''This method returns the data value of the node'''
        return self.data

    def set(self, data):
        '''This method sets the data value for the node'''
        self.data = data


class BST:
    '''Binary Search Tree class'''

    def __init__(self):
        '''Constructor to initialize root node'''
        self.root = None
        self.nodes = []  # list containing the nodes present in the tree

    def __node_present(self, data):
        """This method checks if a given node is present
        in the bst or not
        """
        if data in self.nodes:
            return True
        return False

    def __print_inorder(self, cur_node):
        '''This method prints the tree in inorder fashion'''
        if cur_node:
            self.__print_inorder(cur_node.left)
            print(cur_node.data, end=" ")
            self.__print_inorder(cur_node.right)

    def __print_postorder(self, cur_node):
        '''This method prints the tree in postorder fashion'''
        if cur_node:
            self.__print_postorder(cur_node.left)
            self.__print_postorder(cur_node.right)
            print(cur_node.data, end=" ")

    def __print_preorder(self, cur_node):
        '''This method prints the tree in preorder fashion'''
        if cur_node:
            print(cur_node.data, end=" ")
            self.__print_preorder(cur_node.left)
            self.__print_preorder(cur_node.right)

    def __print_frequency(self, cur_node):
        """This method prints the frequency of each node
        in the tree. The traversal happens in inorder fashion.
        """
        if cur_node:
            self.__print_frequency(cur_node.left)
            print(cur_node.data, cur_node.node_freq)
            self.__print_frequency(cur_node.right)

    def __find_node(self, cur_node, data):
        """Private method that returns the node containing
        the data (invoked by find())
        """
        if cur_node is None:
            return None
        if cur_node.data == data:
            return cur_node
        if cur_node.data > data:
            return self.__find_node(cur_node.left, data)
        return self.__find_node(cur_node.right, data)

    def __insert_node(self, cur_node, data):
        """This is a private method that creates a TreeNode with
        value=data and inserts it into the tree with root node as specified
        in the curNode
        """
        if cur_node is None:
            return
        elif cur_node.data == data:
            LOGGER.debug("%d exist in tree, incrementing frequency",
                         cur_node.data)
            LOGGER.debug("freq of %d changing from %d to %d", cur_node.data,
                         cur_node.node_freq,
                         cur_node.node_freq + 1)
            cur_node.node_freq += 1
            return
        elif cur_node.data > data and cur_node.left is None:
            cur_node.left = TreeNode(data)
            self.nodes.append(data)
            LOGGER.debug("%d added in the tree", cur_node.left.data)
            LOGGER.debug("freq of %d changing from %d to %d",
                         cur_node.left.data, cur_node.left.node_freq,
                         cur_node.left.node_freq + 1)
            cur_node.left.node_freq += 1
            return
        elif cur_node.data < data and cur_node.right is None:
            cur_node.right = TreeNode(data)
            self.nodes.append(data)
            LOGGER.debug("%d added in the tree", cur_node.right.data)
            LOGGER.debug("freq of %d changing from %d to %d",
                         cur_node.right.data, cur_node.right.node_freq,
                         cur_node.right.node_freq + 1)
            cur_node.right.node_freq += 1
            return
        elif cur_node.data > data:
            self.__insert_node(cur_node.left, data)
        else:
            self.__insert_node(cur_node.right, data)

    def __delete_node(self, data):
        """While deleting a node from bst, there can be 3 cases:
        Case 1: Node to be deleted has no child
        In that case, simply remove the node from the tree
        Case 2: Node to be deleted has one child
        Copy the data of child node to the node to be deleted
        and delete the child node
        Case 3: Node to be deleted has two children:
        1) Find the node to be deleted, 2) Find the inorder successor
        of that node, 3) Copy the content of inorder successor to the node to be
        deleted, 4) Delete the inorder successor
        """
        _node_to_delete_ = self.find(data)
        LOGGER.debug("Node {} is being deleted".format(_node_to_delete_.data))

        if _node_to_delete_.left is None and _node_to_delete_.right is None:
            _node_to_delete_ = None
            LOGGER.debug("Node {} has been deleted.".format(data))
            return
        elif _node_to_delete_.left is not None:
            _node_to_delete_.data = _node_to_delete_.left.data
            _node_to_delete_.left = None
        elif _node_to_delete_.right is not None:
            _node_to_delete_.data = _node_to_delete_.right.data
            _node_to_delete_.right = None
        else:
            _inorder_successor = self.inorder_successor(_node_to_delete_)
            print("Inorder Successor for {} found as {}".format(
                _node_to_delete_.data,
                _inorder_successor.data))

    #public methods available outside the class 
    def find(self, data):
        """Public method that returns the node containing
        the data (part of public interface)
        """
        if self.__node_present(data) is False:
            print('{} is not present in the tree.'.format(data))
            return -1
        return self.__find_node(self.root, data)

    def inorder_successor(self, cur_node):
        """This method returns the inorder successor of the cur_node
        The trick here is to find the smallest (leftmost) node
        in the right subtree of the node to be deleted
        """
        if cur_node is None:
            return cur_node
        if cur_node.right:
            right_subtree_root = cur_node.right
            while right_subtree_root.left:
                right_subtree_root = right_subtree_root.left
            return right_subtree_root
        return cur_node

    def insert(self, data):
        """This is a public method that is used for
        inserting a new node into the bst.
        """
        # adding the first node into the tree
        if self.root is None:
            self.root = TreeNode(data)
            self.nodes.append(data)
            LOGGER.debug("%d added as root node", self.root.data)
            LOGGER.debug("freq of %d changing from %d to %d",
                         self.root.data,
                         self.root.node_freq,
                         self.root.node_freq + 1)
            self.root.node_freq += 1
            LOGGER.debug("root node added, value = %d", self.root.data)
            return
        self.__insert_node(self.root, data)
        return

    def delete(self, data):
        """This is a public method that deletes the node that
        contains the data
        """
        if data not in self.nodes:
            print('Passed node is not present in the list')
            return
        self.__delete_node(data)

    def inorder(self):
        """Public method to print the inorder
        traversal of the binary search tree
        """
        self.__print_inorder(self.root)

    def postorder(self):
        """Public method to print the postorder
        traversal of the binary search tree
        """
        self.__print_postorder(self.root)

    def preorder(self):
        """Public method to print the postorder
        traversal of the binary search tree
        """
        self.__print_preorder(self.root)

    def node_frequency(self):
        """Public method that prints the node vs
        frequency table for the given binary tree
        """
        self.__print_frequency(self.root)


if __name__ == '__main__':
    BST01 = BST()
    BST01.insert(34)
    BST01.insert(45)
    BST01.insert(16)
    BST01.insert(99)
    BST01.insert(45)
    BST01.insert(64)
    BST01.insert(61)
    BST01.insert(16)
    print("\nInorder Traversal")
    BST01.inorder()
    print("\nPostorder Traversal")
    BST01.postorder()
    BST01.delete(34)
    print("\nInorder Traversal")
    BST01.inorder()
    
