#include <bits/stdc++.h>
using namespace std;

void printVector(vector <int> v){
	for(int i=0; i<v.size(); i++){
		cout << v[i] << "\t";
	}
	cout << endl;
}
//passing the vector by reference
void removeDuplicates(vector <int>& v ){
	if(v.size() == 0) return 0;
	if(v[0] == v[1])
		v.erase(v.begin() + 0);
	int i;
	for(i=0; i<v.size()-1; i++){
		if(v[i] == v[i+1]){
			v.erase(v.begin() + i);
			i--;
		}
	} 
}

int main(){
	vector<int> v;
	v.push_back(0);
	v.push_back(1);
	v.push_back(1);
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);
	v.push_back(7);
	v.push_back(8);
	v.push_back(8);
	v.push_back(9);
	printVector(v);
	removeDuplicates(v);
	printVector(v);
	return 0;
}