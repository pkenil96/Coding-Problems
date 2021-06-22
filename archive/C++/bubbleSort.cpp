#include <iostream>
using namespace std;

void printArray(int* array){
    int n = sizeof(array);
    for(int i=0; i<n; i++){
        cout << array[i] << "\t";
    } 
    cout << endl;
}

void swap(int* m, int* n){
    int* temp = m;
    m = n;
    n = temp;
}

void bubbleSort(int* array){
    bool swaps;
    int n = sizeof(array);
    for(int i=0; i<n; i++){
        swaps = false;
        for(int j=0; j<n-1; j++){
            if(array[j] > array[j+1]){
                swap(array[j], array[j+1]);
                swaps = true;
            }       
        } if (swaps == false) return; //array is already sorted
    }
}

int main(){
    int array[] = {11,-8,22,9,8,16,0,45};
    printArray(array);
    bubbleSort(array);
    printArray(array);
    return 0;
}
