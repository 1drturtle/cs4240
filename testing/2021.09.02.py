import random


# no inputs, no outputs, only a side effect
def land_on_hoots():
    # docstring
    """This function does almost nothing except print a string."""
    print("""Mortage your unimproved deeds
          Sell bak developments
          count cash""")


def square(x):
    """precondition: x is a number
postcondition: returns the square of x"""
    return x ** 2


for i in range(10):
    print(random.randint(1, 6), random.randint(1, 6))

# print(help(square))


# modifies `x` in place, since lists are mutable.
def swap(x, j, k):
    """Swaps two items in list x.

    Args:
        x (list)
        j (int): indice of x
        k (int): indice of x

    Returns: modifies input x
    """
    x[j], x[k] = x[k], x[j]


x = ['a', 'b', 'c', 'd', 'e']
swap(x, 0, 4)
print(x)
