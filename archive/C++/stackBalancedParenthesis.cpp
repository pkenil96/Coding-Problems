#include <iostream>
#include <stack>

using namespace std;

/*
	Algorithm:-
	1) Create a non-empty stack
	2) Scan the expression string from left to right:
	   --If the character is an opening character ({,[,(), push it on the stack
	   --If the character is any character other then parenthesis, ignore it
	   --If the character is a closing character (],),}), pop the stack and 
	   compare the current character with popped item, if it matches, continue,
	   else, return false
	3) If there are items left on the stack after the entire expression is scanned,
	return False, else return True
*/
bool isParenthesisBalanced(string exp){
	stack <char> myStack;
	int i=0, len = exp.size();
	while(i < len){
		char curr_char = exp[i];
		if(curr_char == '(' || curr_char == '{' || curr_char == '['){
			myStack.push(curr_char);
			continue;
		}
		if(curr_char == ')' || curr_char == ']' || curr_char == '}') {
			char popped_char = myStack.top();
			myStack.pop();
			if( (curr_char == '(' && popped_char != ')') || (curr_char == '[' && popped_char != ']') || (curr_char == '{' && popped_char != '}'))
				return false;
		}
		i++;
	}
	if(myStack.empty()) return true;    
}

int main(int argc, char* argv[]){
    cout << isParenthesisBalanced("(A+B)*(C*D)") << endl;
    cout << isParenthesisBalanced("(A+B}*(C*D)") << endl;
    cout << isParenthesisBalanced("[]") << endl;
    return 0;
}

