def insert(intervals, newInterval):
    '''
        intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]],  newInterval = [4,8]

    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16
    ------    -----------    ------    ------------        ----------------------
                   ---------------------

              --------------------------
    Approach:
    ans = []
    CI - Current interval
    NI - New Interval
    Compare (CI)?(NI) --> NI completely on right (CR)/overlap (O)/Left Overlap(LO)
    If CR: move to next CI (push current to ans), if start time of CI > end time of NI(LO) --> add NI to ans reassign NI=CI, else: update NI as follows: NI(min) = min(CI, NI) and NI(max) = max(CI, NI)
    (1, 2) ? (4, 8): CR --> next (push (1, 2) to ans)
    (3, 5) ? (4, 8): O --> NI = (3, 8)
    (6, 7) ? (3, 8): O --> NI = (3, 8)
    (8, 10)? (3, 8): LO --> NI = (8, 10) --> push NI to ans; NI=CI
    (12, 16)?(8,10):
    '''
    if len(intervals) == 0:
        return [newInterval]
    ans = []
    for interval in intervals:
        if interval[1] < newInterval[0]:  # CR
            ans.append(interval)
        elif interval[0] > newInterval[1]:
            ans.append(newInterval)
            newInterval = interval
        else:
            newInterval[0] = min(newInterval[0], interval[0])
            newInterval[1] = max(newInterval[1], interval[1])
    ans.append(newInterval)
    return ans