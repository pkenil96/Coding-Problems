/*
	Due to the use of extra memory and multiple traversals, this ran very slow and the updated solution is posted with the file name TownJudgeOptimized.java
*/

import java.util.*;

class Pair{
	int sent;
	int received;

	public Pair(int sent, int received){
		this.sent = sent;
		this.received = received;
	}
}


class TownJudge{

	public static int findJudge(int n, int [][] trust){
		if(trust == null)
			return 0;

		HashMap <Integer, Pair> hmap = new HashMap<>();

		//initializeing the hashmap with  (0,0) pair
		for(int i=1; i<=n; i++){
			hmap.put(i, new Pair(0, 0));
		}

		for(int i=0; i<trust.length; i++){
			int x = trust[i][0];
			int y = trust[i][1];
			Pair tempX = hmap.get(x);
			tempX.sent += 1;
			Pair tempY = hmap.get(y);
			tempY.received += 1; 
			hmap.put(x,tempX);
			hmap.put(y,tempY);
		}

		for (Map.Entry <Integer,Pair> entry : hmap.entrySet()){  
            int key = entry.getKey(); 
            Pair pair = entry.getValue();
            if(pair.sent == 0 && pair.received == n-1)
            	return key; 
        } 
        return -1;
	}

	public static void main(String[] args) {
		int N = 3;
		int [][] trust = {
							{1, 2},
							{2, 3}
						};
		System.out.println(findJudge(N, trust));
	}
}