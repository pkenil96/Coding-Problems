def backtrack(n, k, temp, start, result):
    if len(temp) == k:
        result.append(list(temp))
        return

    for i in range(start, n+1):
        temp.append(i)
        backtrack(n, k, temp, i+1, result)


def combine(n, k):
    if k==0:
        return [[]]

    result = []
    start = 1
    backtrack(n, k, [], start, result)
    return result


print(combine(4, 2))