from typing import List

def s(x: List[str]):
    return [k for k in x if k.lower()[0] < 'n']

def super_sum(f, n):
    return sum(f(k) for k in range(1, n+1))

def intersect(A, B):
    return {x for x in A if x in B}

print(s(['hello', 'world', 'abcdefg']))
print(super_sum(lambda x: x + 1, 6))
print(intersect({'a', 'b', 'c'}, {'b', 'c'}))