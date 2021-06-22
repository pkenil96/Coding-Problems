#include <iostream>
#include <stdlib.h>
#include <string.h>

using namespace std;

int main(int argc, char* argv[]){
	if(argc != 2){
		cout << "Exactly 2 arguments are required, " <<  argc << " provided." << endl;
		cout << "Usage: g++ program_name input_string" << endl;
		exit(-1);
	} else {
		string str = argv[1];
		cout << "Input string is: " << str << endl;
		string temp="";
		int sum=0;
		for(char ch: str){
			if(isdigit(ch)){
				temp += ch;	
			} else {
				//sum += std::stoi(temp);
				sum += atoi(temp.c_str());
				temp="";
			}
		}
		sum += atoi(temp.c_str());
		//sum += std::stoi(temp);
		cout << sum << endl;
	}	
	return 0;	
}
