def square(x):
    return x ** 2


def cube(x):
    return x * square(x)


if __name__ == '__main__':
    print(cube(10))
