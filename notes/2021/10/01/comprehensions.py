from typing import List

# list comprehensions

# x = [1, 4, 7, 3, -4, 9, 12, 4]

def squares(x: List[int]):
    return [i ** 2 for i in x]

def trimmed_sum(x: List[int], limit: int):
    return sum(k for k in x if k <= limit)

def foo(x: List[int]):
    return sum(k ** 3 for k in x if k > 0)

# dictionary comprehensions

x = {
    'cat': 5,
    'dog': 3,
    'tapir': 9,
    'okapi': 2,
    'hyena': 1
}

def print_rare(x: dict):
    return {k: v for k, v in x.items() if v <= 2}

print(print_rare(x))