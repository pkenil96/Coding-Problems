def maxArea(height):
    '''
        Thoughts:
        Since we need to maximize the area, we need largest height and largest breadth possible.

        Brute force: Start from the first line up until the end keep track of the maximum area. O(n^2)

        Better way: Initialize left = 0, right = len(height).
        Now the area between these bars is given by the distance between these bars multiplied with the
        smaller height of the two. This is one possible area. Now we need to inspect further for larger areas.
        So either we can move left or right pointer. Since we need to increase the area and either moving left
        or right is just gonna decrease the width, we select the bar in such a way that we get bigger height,
        hence the bigger area. So if height[left] < height[right], we move left ahead and vice versa. We also
        keep track of the maximum area so far and at the end return it
    '''
    left = 0
    right = len(height) - 1
    maxArea = 0

    # terminating condition: when left==right, area will shrink to zero
    while left < right:
        maxArea = max(maxArea, min(height[left], height[right]) * (right - left))
        if height[left] <= height[right]:
            left += 1
        else:
            right -= 1
    return maxArea