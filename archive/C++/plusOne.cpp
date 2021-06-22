#include <bits/stdc++.h>
using namespace std;

int vectorToInt(vector <int> digits){
	int result = 0;
	for(auto d : digits)
		result = result*10 + d;
	return result;
}

int main(){
	// normal integer with last digit non nine
	vector <int> digits1;
	digits1.push_back(2);
	digits1.push_back(4);
	digits1.push_back(5);

	// integer with last digit 9
	vector <int> digits2;
	digits2.push_back(1);
	digits2.push_back(2);
	digits2.push_back(9);

	// single digit integer
	vector <int> digits3;
	digits3.push_back(6);
	
	// digit 9
	vector <int> digits4;
	digits4.push_back(9);

	// integer with all carry
	vector <int> digits5;
	digits1.push_back(2);
	digits1.push_back(9);
	digits1.push_back(9);

	// integer with all 9's
	vector <int> digits6;
	digits6.push_back(9);
	digits6.push_back(9);
	digits6.push_back(9);
	return 0;
}