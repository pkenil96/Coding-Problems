import java.util.*;

public class L253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals){
        if(intervals.length == 1) return 1;
        
        int startTime=0, endTime=1;
        // sorting the intervals by start time - scheduling all the meetings one by one in order
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        // to keep track of the meeting with earliest end time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // the meeting that starts first will occupy one room initially
        pq.add(intervals[0][endTime]);
        int minRooms = 1;
        
        for(int i=1; i<intervals.length; i++){
            // pq currently stores the endtime of the earliest ending meeting (min heap),
            // if the current interval is starting before the earliest ending meeting
            // there is no way we can find a vacant room and we have to allocate new room
            if(intervals[i][startTime] < pq.peek()){
                minRooms++;
            } else {
                // if the above condition fails, it means the meeting with earliest end time
                // is now over and it can be removed from the heap
                pq.poll();
            }
            // we keep adding all the intervals into pq as we encounter as
            // there is a chance that it may have earliest ending time
            pq.add(intervals[i][endTime]);
        }
        return minRooms;
    }
}
