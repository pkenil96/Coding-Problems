/*
	Deleting a given node of the list without 
	returning the head pointer. Passing the head
	pointer by reference to the delete function
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

//create a Node using the data variable and
//append it to the list represented by head
void append( struct Node* head, int data ){
	if (!head)  return;
	
	struct Node* tempNode = head;
	while(tempNode->next){
		tempNode = tempNode->next;	
	}
	tempNode->next = createNode(data);
	return;
}

//data: value of the node to be deleted
/*
	Here if we pass only the node to be deleted
	as function argument, then the copy of the 
	pointer to that variable will be sent to the
	function and deletion will fail in case of head
	node.
*/
void deletePassedNode(struct Node** head, int data){
	//when the data is found in the head node
	if ((*head)->data == data){
		struct Node* delNode = *head;
		*head = (*head)->next;
		free(delNode);
		return;
	}

	struct Node* currNode = *head;
    struct Node* prevNode = *head;
	while(currNode->next){
		if (currNode->data == data){
			prevNode->next = currNode->next;
			free(currNode);
		}
		prevNode = currNode;
		currNode = currNode->next;
	}
	return;
}

int main(int argc, char* argv[]){
	struct Node* sampleNode = createNode(11);
	printf("Creating sample list with 6 values...\n");
	for (int i=1; i<=6; i++){
		append(sampleNode, i*2);	
	}

	printf("Initial list...\n");
	printList(sampleNode);
	printf("After deleting non-head node...\n");
	deletePassedNode(&sampleNode,6);
	printList(sampleNode);
	printf("After deleting head node...\n");
	deletePassedNode(&sampleNode, 11);
	printList(sampleNode);
	return 0;	
}

