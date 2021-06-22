package codechef;

//https://www.codechef.com/problems/COVIDLQ
import java.util.*;
import java.lang.*;
import java.io.*;

class Covidlq{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=0;
		if(sc.hasNext())
			t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			Integer [] arr = new Integer[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
			}

			//logic
			ArrayList <Integer> dis = new ArrayList<>();
			int index=0;
			for(int i=0; i<n; i++){
				if(arr[i] == 1){
					dis.add(index++, i);
				}
			}

			for(int i=0; i<dis.size()-1; i++){
				if(dis.get(i+1) - dis.get(i) < 6){
					System.out.println("NO");
				}
			}
			System.out.println("Yes");
		}		
	}
}