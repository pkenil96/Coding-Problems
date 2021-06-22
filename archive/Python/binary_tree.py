import logging

logging.basicConfig(filename='bt.log', filemode='w')
LOGGER = logging.getLogger('BT')
LOGGER.setLevel(logging.DEBUG)


class TreeNode:
    '''Node class for Binary Tree'''
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

    def get(self):
        '''This method returns the data value of the node'''
        return self.data

    def set(self, data):
        '''This method sets the data value for the node'''
        self.data = data