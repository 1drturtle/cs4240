from math import log, e, sin, cos, pi
from run_tests import run_test, run_test_float

## you can now use log(x) for the natural log of x.
## You can only use the imported functions that I specify.

def greet(name: str = 'Stranger'):
    """prec:  name is a keyword argument with default value "Stranger"
    postc: returns the string Hello, name!"""  
    return f"Hello, {name}!"

def log_base(x, b):
    """prec:  x > 0 and b > 0 is a keyword argument
    postc: use the change-of-base formula to compute 
    the logarithm of x with base b.  The default is that
    the natural log of x is returned."""
    return 0

def truncate(s, n):
    """prec:  s is a string, n is a nonnegative integer
    and a keyword argument.  if len(x) > s return s; otherwise
    truncate at n.  By default, n = 3."""
    return ""

def protean_sin(x, radians):
    """prec: x is a number, radians is a boolean and a
    keyword argument.  
    postc: returns sin(x) using radians if radians is True
    and sin(x) in degrees if radians is false.
    The default is True"""
    return 0

def protean_asin(x, radians):
    """prec: x is a number, -1 <= x <= 1.
    radians is a keyword argument.  
    postc: returns sin(x) using radians if radians is True
    and arcsin(x) in degrees if radians is false.
    The default is True."""
    return 0

if __name__ == '__main__':
    print(f'--{"Tests for Problem #1":^50}--')
    run_test(greet, "Hello, Stranger!", [])
    run_test(greet, f'Hello, Chris!', ['Chris'])
    print(f'--{"Tests for Problem #2":^50}--')
    print(f'--{"Tests for Problem #3":^50}--')
    print(f'--{"Tests for Problem #4":^50}--')
    print(f'--{"Tests for Problem #5":^50}--')