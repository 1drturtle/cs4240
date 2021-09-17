from run_tests import run_test, run_test_float
from math import e

def power_rec(base, exp):
    """prec:  base is a number, exp is an integer
    postc: returns base**exp using a recursive version of the
    divide and conquer power algorithm"""
    if exp == 0:
        return 1

    base, exp = (1 / base, abs(exp)) if exp < 0 else (base, exp)

    # return base * power_rec(base, exp - 1)

    if not exp % 2:
        return power_rec(base * base, exp / 2)
    else:
        return base * power_rec(base, exp - 1)


def power_iter(x, b):
    """prec:se is a number, exp is an integer
    postc: returns base**exp using an iterative version of the
    divide and conquer power algorithm"""
    # deal with negative inputs
    x, b = (1 / x, abs(b)) if b < 0 else (x, b)

    # default return is 1
    out = 1

    while b > 0:
        if b % 2 == 0:
            x *= x
            b //= 2
        else:
            out *= x
            b -= 1

    return out


def main():
    ##run tests here
    print(f'{"-"*15} Power (Recursive) Tests {"-"*15}')
    run_test(power_rec, 1024, [2, 10])
    run_test(power_rec, 16, [4, 2])
    run_test(power_rec, 1, [0, 0])
    run_test_float(power_rec, 1 / 64, [8, -2])
    run_test_float(power_rec, 3696396931125.1025, [4.25, 20])
    print(f'{"-"*15} Power (Iterative) Tests {"-"*15}')
    run_test(power_iter, 1024, [2, 10])
    run_test(power_iter, 16, [4, 2])
    run_test(power_iter, 1, [0, 0])
    run_test(power_iter, 1 / 64, [8, -2])
    run_test_float(power_iter, 3696396931125.1025, [4.25, 20])
    run_test_float(power_iter, e, [1.000000001, 1000000000])


main()
