#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    long n,c,q1,q2;
    cin >> n;
    cin >> c;

    vector <pair<long,long> > v;
 
    for(long i=0;i<c;i++){
        cin >> q1 >>  q2;
        v.push_back(make_pair(q1,q2));
    }
    /*
    	Sorting the vector of pairs
    	in the decreasing order of second
    	item in the pair using lamda function
    */
  	sort(v.begin(), v.end(), [](const pair<long,long> &left, const pair<long,long> &right)
  	 {
    	return left.second > right.second;
	 }
	 );

vector < pair <long,long> >::iterator itr;

/*
	At this point the problem reduces down
	to 0/1 knapsack problem
*/
long ans = 0,limit = n;
for(itr = v.begin();itr!=v.end();itr++){
    if(itr->first <= limit){
        ans += ( itr->first )*(itr->second);
        limit-=itr->first;
    }
    else{
        ans+=limit*itr->second;
       break;
    }

}
cout << ans << endl;

    return 0;
}

