from collections import deque

def nsr(nums):
    if nums is None or len(nums) == 0:
        return None

    print(nums)
    result = []
    stack = deque()
    index = len(nums) - 1

    while index >= 0:
        if not stack:
            result.append(-1)
        else:
            while stack and stack[-1] > nums[index]:
                stack.pop()
            if not stack:
                result.append(-1)
            else:
                result.append(stack[-1])
        stack.append(nums[index])
        index -= 1
    result = result[::-1]
    print(result)

nsr([11, 6, 4, 10, 2, 5])