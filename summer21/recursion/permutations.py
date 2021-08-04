def solve(ip, op):
    sol = []
    solveUtil(ip, op, sol)
    return sol

def solveUtil(ip, op, sol):
    if len(ip) == 0:
        sol.append(op)
        return

    for i in range(len(ip)):
        op += ip[0]
        ip = ip[1:]
        solveUtil(ip, op, sol)


print(solve("123", ""))