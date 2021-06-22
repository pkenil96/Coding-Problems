/*
	Given a reference to the node pointer that
	needs to be deleted. Delete the given node 
	from the list without the head pointer.
*/

#include <stdio.h>
#include <stdlib.h>

struct Node{
	int data;
	struct Node* next;
};

struct Node* createNode(int data){
	struct Node* newNode = (struct Node*) malloc (sizeof(struct Node));
	if (!newNode) {
		printf("Could not allocate memory\n");
		exit(-1);
	}
	newNode->data = data;
	newNode->next = NULL;
	return newNode;
}

void printList(struct Node* head){
	if (head) {
		struct Node* temp = head;
		while(temp){
			printf("%d ", temp->data);
			temp = temp->next;
		}
		printf("\n");
	} return;
}

void append(struct Node* head, int data ){
	if (!head) return;
	
	struct Node* tempNode = head;
	while(tempNode->next){
		tempNode = tempNode->next;	
	}
	tempNode->next = createNode(data);
	return;
}

void deleteNodeWithoutHead(struct Node* node){
	//case 1: when given node is head node
	//case 2: when given node is between head and tail
	if (node->next) {
		struct Node* prev = node;
		node->data = node->next->data;
		node = node->next;
		prev->next = node->next;
		free(node);
	} else {
    //case 3: when given node is tail node
		free(node);
	}

	
}

int main(int argc, char* argv[]){
	struct Node* sampleNode = createNode(45);
	struct Node* tempNode = sampleNode;
	append(sampleNode, 11);
	append(sampleNode, -67);
	append(sampleNode, 99);
	append(sampleNode, 56);

	printList(sampleNode);
	
	struct Node* nodeToBeDeleted = tempNode->next->next;//67
	printf("Node which is being deleted has value %d\n", nodeToBeDeleted->data);
	deleteNodeWithoutHead(nodeToBeDeleted);
	printf("List after deleting the node 67...\n");
	printList(sampleNode);
	return 0;	
}
