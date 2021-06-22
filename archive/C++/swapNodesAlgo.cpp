/*
Problem Description
-------------------

A binary tree is a tree which is characterized by any one of the following properties:

It can be an empty (null).
It contains a root node and two subtrees, left subtree and right subtree. These subtrees are also binary tree.
Inorder traversal is performed as

Traverse the left subtree.
Visit root (print it).
Traverse the right subtree.
(For an Inorder traversal, start from the root and keep visiting the left subtree recursively until you reach the leaf,then you print the node at which you are and then you visit the right subtree.)

We define depth of a node as follow:

Root node is at depth 1.
If the depth of parent node is d, then the depth of current node wll be d+1.
Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping left subtree will be R and right subtree L.

Eg. In the following tree, we swap children of node 1.

                                Depth
    1               1            [1]
   / \             / \
  2   3     ->    3   2          [2]
   \   \           \   \
    4   5           5   4        [3]
Inorder traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.

Swap operation: Given a tree and a integer, K, we have to swap the subtrees of all the nodes who are at depth h, where h ∈ [K, 2K, 3K,...].

You are given a tree of N nodes where nodes are indexed from [1..N] and it is rooted at 1. You have to perform T swap operations on it, and after each swap operation print the inorder traversal of the current state of the tree.

Input Format 
First line of input contains N, number of nodes in tree. Then N lines follow. Here each of ith line (1 <= i <= N) contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node. -1 is used to represent null node. 
Next line contain an integer, T. Then again T lines follows. Each of these line contains an integer K.

Output Format 
For each K, perform swap operation as mentioned above and print the inorder traversal of the current state of tree.

Constraints 
1 <= N <= 1024 
1 <= T <= 100 
1 <= K <= N 
Either a = -1 or 2 <= a <= N 
Either b = -1 or 2 <= b <= N 
Index of (non-null) child will always be greater than that of parent.
*/


//solution

#include <bits/stdc++.h>
using namespace std;

struct Node{
    struct Node* left;
    int data;
    struct Node* right;

    Node(int data){
        this->data = data;
        this->right = this->left = NULL;
    }
};


void inOrderTraversal(struct Node* root){
    if(root){
        inOrderTraversal(root->left);
        cout << root->data << " ";
        inOrderTraversal(root->right);
    }
}

void swapMyChildren(struct Node* root){
    struct Node* temp = root->left;
    root->left = root->right;
    root->right = temp;
}

void swapSubTree(struct Node* root, int current_level ,int K){
    if(root==NULL || (root->left==NULL && root->right==NULL))
        return;

    if(current_level%K==0)//Caution : All the nodes that lies at the level which is multiple of K needs to be swaped
        swapMyChildren(root);

    swapSubTree(root->right,current_level+1,K);
    swapSubTree(root->left,current_level+1,K);
    
}

int main(){
    queue <Node*> q;
    int a,b,N;
    cin >> N;

    struct Node *root = new Node(1),*temp;
    q.push(root);

    while(!q.empty()){
        temp = (Node*)q.front();
        q.pop();

        cin >> a;

        if(a==-1){
            temp->left=NULL;
        } else {
            temp->left = new Node(a);
            q.push(temp->left);
        }

        cin >> b;
        if(b==-1){
            temp->right=NULL;
        } else {
            temp->right = new Node(b);
            q.push(temp->right);
        }
    }//by now the tree is formed

    int n_K,K;
    cin >> n_K;

    for(int i=0;i<n_K;i++){
        cin >> K;
        //swapSubTree at Kth level
        swapSubTree(root,1,K);
        inOrderTraversal(root);
        cout << endl; 
    }    
    return 0;
}
