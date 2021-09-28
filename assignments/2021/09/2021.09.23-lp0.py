from rt import run_test
from typing import List

# Chris Agrella
# Lab Practical 0
# 09/23/2021ko


# ##################### Problem 1 #########################
def describe_string(s):
    """prec:  s is a string
    postc:  returns "LONG" if the string has 10 or
    more characters and "SHORT" otherwise."""
    return "LONG" if len(s) >= 10 else "SHORT"


# ##################### Problem 2 #########################
def add_evens(nums):
    """prec: nums is a list of integers.
    postc:  returns the sum of the EVEN numbers in nums."""
    return sum(x for x in nums if x % 2 == 0)  # generator of nums


# ##################### Problem 3 #########################
def opposite_letter(ch):
    """prec:  ch is a one-character string (letter)
    postc: returns the "opposite" letter in the alphabet
    in lower case:
    A -> z
    a -> z
    B -> y
    b -> y
    C -> x
    c -> x
    etc."""

    alphabet = "abcdefghijklmnopqrstuvwxyz"
    index = -(alphabet.index(ch.lower()) + 1)  # find the index of the character, make it negative for reverse searching

    return alphabet[index]


# ##################### Problem 4 #########################
def zipper_strings(a, b):
    """prec: a, b are strings.
    post:  returns a string that, starting with a,
    alternates characters of a and b.  When one list is
    exhausted, the rest of the other is tacked onto the end."""
    out = ""

    if len(a) == 0:  # return the other string if one is empty
        return b
    elif len(b) == 0:
        return a

    for i, x in enumerate(a):
        out += x  # add first a
        out += b[i]  # add the b
        if len(b) == i + 1:  # if we are out of b, add the the rest of a, and break
            out += a[i + 1:]
            break
    if len(b) > len(a):  # if b is larger than a, tack on the rest of b
        out += b[len(a):]

    return out


# ##################### Problem 5 #########################
def maximum_product(lists: List[List[int]]):
    """prec: lists is a nonempty list of numerical lists.
    Note that one of the numerical lists could be empty and
    that the product of an empty list is 1.
    postc:  returns THE LIST with the largest product.
    In the event of a tie, it returns the first such list."""

    out = []
    for x in lists:
        if len(x) == 0:  # empty list = 1
            out.append(1)
        else:
            # can be replaced with itertools.product
            a = 1
            for i in x:
                a *= i
            out.append(a)

    index = out.index(max(out))  # out has the same amount of elements so we can do a 1:1 index map
    return lists[index]


# ##################### Problem 6 #########################
def nuggets(limit: int, nugget_list: List[int]):
    """prec: limit is an nonnegative integer
    postc: nugget_list is a list of nonnegative integers
    returns a list from nugget_list that has the
    highest total without exceeding the limit."""
    options = sorted(nugget_list)  # sort from smallest to largest

    total = 0
    out = []
    while total < limit:
        if len(options) == 0:  # stop if we are out of options
            break
        popped = options.pop()  # take off the next biggest option (from the back of the sorted list)
        if total + popped > limit:  # go to the next option if this option would make it too big
            continue
        total += popped  # add it to our total checker
        out.append(popped)  # add it to the output var

    return sorted(out)


print("************* Tests for Problem 1 **************")
run_test(describe_string, "LONG", ["antidisestablishmentarianism"])
run_test(describe_string, "SHORT", [""])
run_test(describe_string, "LONG", ["1234567890"])
print("************* Tests for Problem 2 **************")
run_test(add_evens, 30, [[1, 4, 7, 9, 10, 16]])
run_test(add_evens, 0, [[]])
run_test(add_evens, 0, [[1, 3, 5, 7, 9, 11, 13]])
run_test(add_evens, 30, [[2, 4, 6, 8, 10]])
print("************* Tests for Problem 3 **************")
run_test(opposite_letter, "z", ["a"])
run_test(opposite_letter, "a", ["z"])
run_test(opposite_letter, 'd', ['w'])
run_test(opposite_letter, 'n', ['m'])
print("************* Tests for Problem 4 **************")
run_test(zipper_strings, "cdaotggie", ["cat", "doggie"])
run_test(zipper_strings, "haeblclo", ["hello", "abc"])
run_test(zipper_strings, 'hello', ['', 'hello'])
run_test(zipper_strings, 'hello', ['hello', ''])
run_test(zipper_strings, 'he', ['h', 'e'])
print("************* Tests for Problem 5 **************")
run_test(maximum_product, [6, 6, 6], [[[1, 2], [5, 6, 7], [3, 0], [6, 6, 6]]])
run_test(maximum_product, [10, 5], [[[10, 5], [1, 3], [], [100, 0]]])
run_test(maximum_product, [], [[[], [], []]])
run_test(maximum_product, [100, 1], [[[100, 1], [50, 2], [25, 4]]])
print("************* Tests for Problem 6 **************")
run_test(nuggets, [4, 16], [20, [1, 2, 4, 8, 16]])
run_test(nuggets, [3, 5], [8, [1, 2, 3, 4, 5]])
run_test(nuggets, [1, 2, 3, 4, 5, 6, 7, 8], [100, [1, 2, 3, 4, 5, 6, 7, 8]])
run_test(nuggets, [], [5, [6, 7, 8, 9, 10]])
run_test(nuggets, [1, 3, 9], [13, [1, 3, 5, 7, 9]])  # both [1, 3, 9] and [1, 5, 7] could be valid outputs
