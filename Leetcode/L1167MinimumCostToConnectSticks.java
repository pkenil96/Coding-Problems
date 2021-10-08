class L1167MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minCost = 0;
        for(int i=0; i<sticks.length; i++){
            pq.add(sticks[i]);
        }
        
        while(pq.size() > 1){
            int firstMin = pq.poll();
            int secondMin = pq.poll();
            int cost = firstMin + secondMin;
            minCost += cost;
            pq.add(cost);
        }
        return minCost;
    }
}