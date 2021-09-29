class L1828QueriesOnNumberOfPointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            int cx = query[0];
            int cy = query[1];
            int r = query[2];
            int count=0;
            for(int[] point: points){
                int x = point[0];
                int y = point[1];
                double distance = (x-cx)*(x-cx)+(y-cy)*(y-cy);
                if(distance <= r*r ){
                    count++;
                }
            }
            result[i]=count;
        }
        return result;
    }
}