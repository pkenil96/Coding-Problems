class TownJudgeOptimized{
	public static int findJudge(int n, int [][] trust){
		if(trust == null)
			return -1;

		int [] sent = new int[n+1];
		int [] received = new int[n+1];

		for(int i=0; i<trust.length; i++){
			sent[trust[i][0]]++;
			received[trust[i][1]]++;
		}

		for(int i=1; i<=n; i++){
			if(sent[i] == 0 && received[i] == n-1)
				return i;
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