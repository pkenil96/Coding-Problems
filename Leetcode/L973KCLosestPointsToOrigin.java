// class Pair{
//     int[] point;
//     double distanceFromOrigin;
//     Pair(int[] point, double distanceFromOrigin){
//         this.point = point;
//         this.distanceFromOrigin = distanceFromOrigin;
//     }
// }

class L973KCLosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
        //     public int compare(Pair p1, Pair p2){
        //         if(p2.distanceFromOrigin > p1.distanceFromOrigin){
        //             return 1;
        //         } else if(p2.distanceFromOrigin < p1.distanceFromOrigin){
        //             return -1;
        //         } return 0;
        //     }
        // });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                int dis1 = p1[0]*p1[0] + p1[1]*p1[1];
                int dis2 = p2[0]*p2[0] + p2[1]*p2[1];
                return dis2-dis1;
            }
        });
        for(int i=0; i<points.length; i++){
            //pq.add(new Pair(points[i], Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1])));
            pq.add(points[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int index = 0;
        int[][] result = new int[k][2];
        //for(int i=0; i<k; i++){
        //    result[i] = pq.poll().point;
        //}
        Iterator itr = pq.iterator();
        while(itr.hasNext()){
            result[index++] = (int[])itr.next();
            //Pair pair = (Pair)itr.next();
            //result[index++] = pair.point;
        }
        return result;
    }
}