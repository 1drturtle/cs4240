#################################################
#  Author: Chris Agrella
#  Date: 09/09
#  harder_functions.py
#
# Make these happen using RECURSION!

from rt import compare_floats, run_test, run_test_float


###################Problem 1################
def rectangle(m, n):
    """Precondition: m and n are nonnegative integers.
    Postcondition:  returns a string containing
    a rectangle of *s to the screen that
    has m rows and n columns"""
    # return '\n'.join(['*'*n for i in range(m)])
    if m == 0:
        return ""
    line = n * "*"
    out = line + "\n" + rectangle(m - 1, n)

    return out.strip()


###################Problem 2################
def power(base, exp):
    """prec:  base is a number, exp is an integer`
    postc: computes base**exp from scratch (no using libraries
    or built-in functions).  Pay attention to the case where exp < 0!"""

    if exp == 0:
        return 1
    if exp < 0:
        exp = abs(exp)
        base = 1 / base
    return base * power(base, exp - 1)


###################Problem 3################
def convert_to_binary(n):
    """prec: n is an integer
    postc: retrns a string containing a binary representation of n.
    return"""

    if n == 0:
        return 0

    x = n % 2
    return x + (convert_to_binary(n // 2)) * 10


###################Problem 4################
def sum_of_digits(n):
    """precondition: n is an integer
    postcondition:  returns the sum of the digits of n.  You should
    be able to take negative input; in such cases disregard the - sign."""
    if n == 0:
        return 0
    n = abs(n)
    return (n % 10) + sum_of_digits(n // 10)


###################Problem 5################
def super_summer(f, n):
    """precondition: f is a function that is defined for all nonnegative
    integers.
    postcondition:  returns sum(f(k), k = 1..n)"""
    if n == 0:
        return 0

    return f(n) + super_summer(f, n - 1)


###################Problem 6################
def reverse_string(x):
    """prec: x is a string
    postc:  return a string containing x is reverse."""
    if x == "":
        return ""
    return x[-1] + reverse_string(x[:-1])


###################Problem 7################
def sum_from(n: int, x: list):
    """prec:  n is an integer, x is a list of integers.
    postc: returns a sublist of x whose sum is n if it exists
    and the graveyard object None otherwise."""
    if sum(x) == n:
        return x
    if not x:
        return None
    return sum_from(n, x[:-1])


def main():
    # run your tests in this main function
    print("###################Problem 1################")
    test = """**********
**********
**********
**********
**********"""
    run_test(rectangle, test, [5, 10])
    run_test(rectangle, "**", [1, 2])
    print("###################Problem 2################")
    run_test(power, 8, [2, 3])
    run_test(power, 1, [100, 0])
    run_test(power, 1 / 64, [8, -2])
    run_test(power, 1 / 8, [2, -3])
    print("###################Problem 3################")
    run_test(convert_to_binary, 10000000, [128])
    run_test(convert_to_binary, 0, [0])
    run_test(convert_to_binary, 1, [1])
    run_test(convert_to_binary, 1001111101, [637])
    print("###################Problem 4################")
    run_test(sum_of_digits, 6, [123])
    run_test(sum_of_digits, 0, [0])
    run_test(sum_of_digits, 3, [111])
    run_test(sum_of_digits, 27, [999])
    print("###################Problem 5################")
    func = lambda x: x + 1
    print(super_summer(func, 3))
    run_test(super_summer, 9, [func, 3])
    run_test(super_summer, 2, [func, 1])
    run_test(super_summer, 0, [func, 0])
    print("###################Problem 6################")
    run_test(reverse_string, "cba", ["abc"])
    run_test(reverse_string, "sirhC", ["Chris"])
    run_test(reverse_string, "dlrow olleh", ["hello world"])
    print("###################Problem 7################")
    print(sum_from(10, [1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2]))
    run_test(sum_from, [1, 2], [3, [1, 2, 3]])
    run_test(
        sum_from, [1, 1, 1, 1, 1, 1, 1, 1, 2], [10, [1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2]]
    )
    run_test(sum_from, None, [1, [3, 3, 3]])


main()
