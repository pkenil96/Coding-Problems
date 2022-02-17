import java.util.*;

public class L252MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 1){
            return true;
        }
        
        // sorting intervals by start time
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
