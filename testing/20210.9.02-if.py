def foo(x):
    """Finds the absolute value of x

    Args:
        x (int): The number to find the absolute value of

    Returns:
        int: Absolute value of x
    """
    if x < 0:
        x = -x
    return x


print(foo(3))
print(foo(-4))


def dusty(age):
    """Returns a string depending on the age

    Args:
        age (int): Age to check.
    """
    if age < 21:
        reply = 'Get out!'
    elif age < 65:
        reply = 'aaaaaaa'
    else:
        reply = 'abcdef'
    return reply


print(dusty(10))
print(dusty(21))
print(dusty(35))
print(dusty(65))
print(dusty(100))
