#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n,i=0,m=0;
    cin >> n;
    int arr[n];
    
    for(i=0;i<n;i++){
        cin >> arr[i];
    }
    
    while(i<n){
        m++;
        i+=arr[i]+1;
    }
    cout << m <<endl;
    return 0;
}
