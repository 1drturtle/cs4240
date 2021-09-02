#   Author: Morrison
#   Date:  2021-08-30
#   Program easyFunctions.py

#   FREE CODE FOR WRITING TESTS
#   Usage is demonstrated on examples below
################# DO NOT CHANGE THIS CODE ###################
def close_enough(x,y):
    return abs(x - y) < 1e6
def run_test(function, expected, args):
    print(f"args = {args}")
    if(len(args) == 1):
        print("made it into the if statement")
        args = args[0]
        print(f"args = {args}")
        if function(args) == expected:
            print(f"PASS for case {args}")
        else:
            print(f"FAIL because f({args}) != {expected}")
    else:
        if function(*args) == expected:
            print(f"PASS for case {args}")
        else:
            print(f"FAIL because f({args}) != {expected}")
def run_test_float(function, expected, args):
    if(type(args) == list and len(args) == 1):
        args = args[0]
        if close_enough(function(args), expected):
            print(f"PASS for case {args}")
        else:
            print(f"FAIL because f({args}) != {expected}")
        return
    else:
        if close_enough(function(*args), expected):
            print(f"PASS for case {args}")
        else:
            print(f"FAIL because f({args}) != {expected}")
############### END OF CODE NOT TO CHANGE ###########################
## sample problem with tests that returns a floating-point value.
def f2c(tempF):
    """precondition: tempF is a float or an int
    postc:  returns the equivalent temperature on the celsius scale."""
    print(tempF)
    return (tempF - 32)*5/9
test = [-40]   #put arguments in a list
expected = -40 #set this to expected output
run_test_float(f2c, expected, test)   #run test
test = [32]
expected = 0
run_test_float(f2c, expected, test)
test = [212]
expected = 100
run_test_float(f2c, expected, test)
## sample problem with tests that returns a non-float object
def get_first_name(name):
    """prec: name is given in the form last, first, and possibly a middle name in 
    a single string
    postc:  returns first name"""
    chunks = name.split()
    return chunks[1]
test = ["Roberts, Todd"]
expected = "Todd"
run_test(get_first_name, expected, test)
test = ["Morrison, John M."]
expected = "John"
run_test(get_first_name, expected, test)
## Problem 0
def c2f(tempC):
    """precondition: tempC is a float or an int
    postc: returns temperature in degrees farenheit
    """
    return tempC * (9/5) + 32
print("*************** Problem 0 Tests ***************")
run_test(c2f, 32, [0])
run_test(c2f, 212, [100])
run_test(c2f, -40, [-40])
# Problem 1
def positive_part(x):
    """precondition: x is a float or an int
    postc:  returns x if x is nonnegative and 0 otherwise.
    """
    return max(x, 0)
    
    # return 0
print("*************** Problem 1 Tests ***************")
run_test(positive_part, 0, [-10])
run_test(positive_part, 30, [30])
run_test(positive_part, 0, [0])
## Problem 2
def truncate_string(s, n):
    """prec: s is a string, n is a nonnegative integer
    post:  returns s if s has length at most n; otherwise, 
    it truncates s to its first n characters."""
    return s[:n]
print("*************** Problem 2 Tests ***************")
test = ["catamaran", 5]
expected = "catam"
run_test(truncate_string, expected, test)
run_test(truncate_string, 'abc', ['abc', 10])
## Problem 3
def xor(b1, b2):
    """prec b1 and b2 are booleans
    post: returns True if EXACTLY ONE of b1 or b2 is true.
    """
    return (b1 or b2) and (b1 != b2)
print("*************** Problem 3 Tests ***************")
test = [True, True]
expected = False
run_test(xor, expected, test)
run_test(xor, True, [True, False])
run_test(xor, False, [False, False])
##Problem 4
def chop_at(s, ch):
    """s is a string, ch is a one-character string
    if ch is not present in s, just return s
    if it is find the last instance of ch in s and truncate 
    the string there (including ch)"""
    if (index := s.rfind(ch)) != -1:
        return s[:index]
    return s
print("*************** Problem 4 Tests ***************")
test = ["Todd Roberts", "e"]
expected = "Todd Rob"
run_test(chop_at, expected, test)
run_test(chop_at, 'hello world', ['hello world', 'z'])
## Problem 5
def sort_string(s):
    """prec: s is a string of alphabetical characters
    post: returns s lower-cased and with its characters in alphabetical order.
    """
    return ''.join(sorted(s.lower()))
print("*************** Problem 5 Tests ***************")
test = ["CowABUnga"]
expected = "aabcgnouw"
run_test(sort_string, expected, test)
run_test(sort_string, 'abcdefgh', ['hgfedcba'])
## Problem 6
def are_anagrams(s1, s2):
    """prec: s1 and s2 are strings
    postc: return True if s1 is an anagram of s2, case INSENSITIVE."""
    return sort_string(s2) == sort_string(s1)
print("*************** Problem 6 Tests ***************")
test = ["golf", "flog"]
expected = True
run_test(are_anagrams, expected, test)
test = ["butter", "rebut"]
expected = False
run_test(are_anagrams, expected, test)
run_test(are_anagrams, expected=True, args=['racecar', 'racecar'])
run_test(are_anagrams, expected=True, args=['elbow', 'below'])