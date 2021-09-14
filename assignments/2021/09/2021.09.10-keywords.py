from math import log, e, sin, cos, pi, asin
from run_tests import run_test, run_test_float

## you can now use log(x) for the natural log of x.
## You can only use the imported functions that I specify.

def greet(name: str = 'Stranger'):
    """prec:  name is a keyword argument with default value "Stranger"
    postc: returns the string Hello, name!"""  
    return f"Hello, {name}!"

def log_base(x, b = e):
    """prec:  x > 0 and b > 0 is a keyword argument
    postc: use the change-of-base formula to compute 
    the logarithm of x with base b.  The default is that
    the natural log of x is returned."""
    return log(x, b)

def truncate(s, n = 3):
    """prec:  s is a string, n is a nonnegative integer
    and a keyword argument.  if len(x) > s return s; otherwise
    truncate at n.  By default, n = 3."""
    return s[:n]

def protean_sin(x, radians = True):
    """prec: x is a number, radians is a boolean and a
    keyword argument.  
    postc: returns sin(x) using radians if radians is True
    and sin(x) in degrees if radians is false.
    The default is True"""
    if radians:
        return sin(x)
    else:
        return sin(x) * (180/pi)

def protean_asin(x, radians = True):
    """prec: x is a number, -1 <= x <= 1.
    radians is a keyword argument.  
    postc: returns sin(x) using radians if radians is True
    and arcsin(x) in degrees if radians is false.
    The default is True."""
    if radians:
        return sin(x)
    else:
        return round(asin(x) * (180/pi), 6)

if __name__ == '__main__':
    print(f'--{"Tests for Problem #1":^50}--')
    run_test(greet, "Hello, Stranger!", [])
    run_test(greet, f'Hello, Chris!', ['Chris'])
    print(f'--{"Tests for Problem #2":^50}--')
    run_test(log_base, 1, [10, 10])
    run_test_float(log_base, 3, [1000, 10])
    print(f'--{"Tests for Problem #3":^50}--')
    run_test(truncate, 'abc', ['abc'])
    run_test(truncate, 'abc', ['abcdefghijkl'])
    print(f'--{"Tests for Problem #4":^50}--')
    run_test_float(protean_sin, 0.850903, [45])
    run_test_float(protean_sin, 48.75318, [45, False])
    print(f'--{"Tests for Problem #5":^50}--')
    run_test_float(protean_asin, 0.850903, [45])
    run_test_float(protean_asin, 0, [0, True])
    run_test_float(protean_asin, 30, [0.5, False])
    