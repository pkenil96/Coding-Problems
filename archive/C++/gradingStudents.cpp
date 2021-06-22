#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;

int main(){
    int n;
    vector <int> v;
    cin >> n;

    for(int a0 = 0; a0 < n; a0++){
        int grade;
        cin >> grade;
        v.push_back(grade);
    }

    for(int i=0;i<n;i++){
        //finding the next closest multiple of 5
        int mul = (v[i]-(v[i]%5))+5;
        if( (mul - v[i]) < 3 && v[i]>=38){
            v[i] = mul;
        }
        cout << v[i] <<endl;

    }
    return 0;
}
