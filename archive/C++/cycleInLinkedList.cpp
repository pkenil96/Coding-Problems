#include <bits/stdc++.h>
using namespace std;

struct ListNode{
	int data;
	struct ListNode* next;
};

struct ListNode* createNode(int data){
	struct ListNode* newNode = new struct ListNode;
	if(!newNode){
		cout << "Memory error" << endl;
		return NULL;
	}
	newNode->data = data;
	newNode->next = NULL;
	return newNode;
}

typedef struct ListNode* NODE;

void printList(NODE node){
	if(!node) return;
	NODE runner = node;
	while(runner){
		cout << runner->data << " ";
		runner = runner->next;
	} cout << endl;
}

bool checkIfCycleExists(NODE list){
	NODE slow = list->next;
	NODE fast = list->next->next;
	while(slow->next && fast->next->next){
		if(slow->data == fast->data) return true;
		slow = slow->next;
		fast = fast->next->next;
	} return false;
}

int main(){
	NODE list1 = createNode(1);
	list1->next = createNode(2);
	list1->next->next = createNode(8);
	list1->next->next = createNode(11);
	list1->next->next->next = createNode(4);
	list1->next->next->next->next = list1; //creating the loop
	cout << checkIfCycleExists(list1) << endl;
	return 0;
}