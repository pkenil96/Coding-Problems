/*
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

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

NODE mergeTwoSortedList(NODE list1, NODE list2){
	if(!list1) return list2;
	if(!list2) return list1;

	NODE ptr1 = list1;
	NODE ptr2 = list2;
	NODE result, ans;
	//creating the first node of the merged list
	if(ptr1->data <= ptr2->data){
		result = createNode(ptr1->data);
		ptr1 = ptr1->next;
	} else {
		result = createNode(ptr2->data);
		ptr2 = ptr2->next;
	}
	ans = result;
	//appending the ramining elements
	while(ptr1 && ptr2){
		if(ptr1->data <= ptr2->data){
			result->next = createNode(ptr1->data);
			result = result->next;
			ptr1 = ptr1->next;
		} else {
			result->next = createNode(ptr2->data);
			result = result->next;
			ptr2 = ptr2->next;
		}
	}
	//in case list1 and list2 are of varrying lenght
	//there will be one list yet to traverse after the loop
	//we need to attach it to the result list
	if(ptr1) {
		result->next = ptr1;
		return ans;
	} else if(ptr2) {
		result->next = ptr2;
		return ans;
	} else {
		return ans;
	}
}

int main(){
	NODE list1 = createNode(1);
	list1->next = createNode(2);
	list1->next->next = createNode(8);

	NODE list2 = createNode(-2);
	list2->next = createNode(3);
	list2->next->next = createNode(4);
	list2->next->next->next = createNode(11);
	
	printList(list1);
	printList(list2);

	NODE mergedList = mergeTwoSortedList(list1, list2);
	printList(mergedList);


	return 0;
}
