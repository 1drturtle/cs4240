def dublin(x):
    return x * 2


def bullet_proof(x: int) -> int:
    return x * 2


# bullet_proof('0')  # gives error with mypy

def hypot(x, y) -> float:
    return (x ** 2 + y ** 2) ** .5


# arguments are evaluated before being passed to the function.
print(hypot(3, 4))