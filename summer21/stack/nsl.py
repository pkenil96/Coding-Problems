from collections import deque

def nsl(nums):
    if nums is None or len(nums) == 0:
        return None

    print(nums)
    result = []
    stack = deque()
    index = 0

    while index < len(nums):
        if not stack:
            result.append(-1)
        else:
            while stack and stack[-1] < nums[index]:
                stack.pop()
            if not stack:
                result.append(-1)
            else:
                result.append(stack[-1])
        stack.append(nums[index])
        index += 1
    print(result)

nsl([11, 6, 4, 10, 2, 5])