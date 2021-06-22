#include <bits/stdc++.h>
using namespace std;

bool checkIfValidExpression(string exp){
   stack <char> s;
   int n = exp.length();
   for(int i=0; i<n; i++){
       char curr_char = exp[i];
       if(curr_char == '[' || curr_char == '(' || curr_char == '{')
           s.push(curr_char);
       else if(curr_char == ']' || curr_char == ')' || curr_char == '}'){
           if(s.empty()) 
               return false;
           char popped = s.top();
           s.pop();
           if(curr_char == ']' && popped != '[') return false;
           else if(curr_char == ')' && popped != '(') return false;
           else if(curr_char == '}' && popped != '{') return false;
       }
   }
   if(s.empty())
       return true;
   return false;
}

int main(){
    string exp = "([)]";
    cout << checkIfValidExpression(exp) << endl;
    return 0;
}
