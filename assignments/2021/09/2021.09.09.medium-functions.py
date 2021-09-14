#################################################
#  Author: Chris Agrella
#  Date: 09/09/2021
#  medium_functions.py
#################################################
from run_tests import run_test, run_test_float, close_enough
###################FREE CODE######################################
def is_leap(year):
    """prec:  year is a modern year
postc: returns True if the year leaps.
"""
    out = False
    if year %4 == 0:
        out = not out
        if year % 100 == 0:
            out = not out
            if year % 400 == 0:
                out = not out
    return out
##############END FREE CODE######################################


###################Problem 1################
def meanie(theList):
    """Precondition: theList is a non-empty list of numbers
Postcondition: return the mean of the numbers."""
    return sum(theList)/len(theList)
###################Problem 2################
# 1 is January, 2 is February, etc.
def day_in_year(year, month, day):
    """prec:  year/month/day is a valid date
    postc: returns the ordinal position of the day in the year
    (Feb 15 is the 46th day of year 2000).
    Hint:  The built-in function sum is your friend. Learn about it."""
    lengths = [31, 28 + is_leap(year), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    prev_months = sum(lengths[:month-1])
    return prev_months + day
    
###################Problem 3################
def days_left_in_year(year, month, day):
    """prec:  year/month/day is a valid date
    postc: returns the number of days left in the year
    (Feb 15 is the 46th day of year 2000)."""
    return (365 + is_leap(year)) - day_in_year(year, month, day)
###################Problem 4################
def days_to_graduation(year, month, day):
    """prec:  year/month/ is a valid date before graduation
    in 2020 or 2021.  It's 29 May 2021.
    postc: returns the number of days until graduation 
    If the year is illegal, or if a date after 29 May 2021 is entered,
    return "ILLEGAL INPUT"  """
    if year not in [2021, 2020]:
        return 'ILLEGAL INPUT'
    if (day_in_year(2021, month, day) >= day_in_year(2021, 5, 30) and year == 2021):
        return 'ILLEGAL INPUT'
    days_left = ((2021-year)*365) + (day_in_year(2021, 5, 29) - day_in_year(2021, month, day))
    return days_left

###################Problem 5################
def dhms(secs):
    """prec:  secs is a nonnegative integer
    postc: return a STRING of the form d:hh:mm:ss, where d is the number
    of days, h is the number of hours, m is the number     of minutes, and
    s is the number of seconds, h < 24, 0 <= m, s, < 60.  Give each of
    h, m, s a two character width, padding with zeroes as needed.  """
    secs, mins = secs % 60, secs // 60
    mins, hours = mins % 60, mins // 60
    hours, days = hours % 24, hours // 24
    out = f'{days}:{hours:02}:{mins:02}:{secs:02}'
    return out
###################Problem 6################
def water_closet(theString: str):
    """precondition: thesString is a string.
postcondition: returns a tuple (c, w, l) where c is the number of
characters in theString, w is the number of words, and l is the number of
lines in the string"""
    lines = len(theString.splitlines())
    words = len(theString.split())
    chars = len(theString)
    return (chars, words, lines)
###################Problem 7################
def math_case(x):
    """precondition: x is a number
postcondition: If x > 4, f(x) = x - 4, if x < -5, f(x) = x + 5,
otherwise, f(x) = 0."""
    if x > 4:
        return x - 4
    if x < -5:
        return x + 5
    return 0

def main():
    print("###################Problem 1################")
    test = [[1,2,3,4,5,6]]
    expected = 3.5
    run_test_float(meanie, expected, test)
    test = [[-3, -2, 0, 0, 6, 5]]
    expected = 1.0
    run_test_float(meanie, expected, test)
    print("###################Problem 2################")
    run_test(day_in_year, 46, [2000, 2, 15])
    run_test(day_in_year, 1, [2000, 1, 1])
    print("###################Problem 3################")
    run_test(days_left_in_year, 365, [2000, 1, 1])
    run_test(days_left_in_year, 320, [2000, 2, 15])
    print("###################Problem 4################")
    run_test(days_to_graduation, 1, [2021, 5, 28])
    run_test(days_to_graduation, 365, [2020, 5, 29])
    run_test(days_to_graduation, 31, [2021, 4, 28])
    run_test(days_to_graduation, 'ILLEGAL INPUT', [2019, 5, 28])
    print("###################Problem 5################")
    run_test(dhms, '0:00:00:01', [1])
    run_test(dhms, f'1:00:00:01', [86401])
    print("###################Problem 6################")
    run_test(water_closet, (11, 2, 1), ['Hello World'])
    run_test(water_closet, (11, 2, 2), ['hello\nworld'])
    print("###################Problem 7################")
    run_test(math_case, 0, [4])
    run_test(math_case, 1, [5])
    run_test(math_case, 0, [-5])
main()