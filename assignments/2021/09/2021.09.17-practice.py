from rt import run_test
from typing import List


######################Problem 1###########################
def trim_sum(nums, limit):
    """nums is a numerical list, limit is a number
    returns the sum of all elements in nums that are
    <= limit"""
    return sum(filter(lambda d: d <= limit, nums))


######################Problem 2###########################
def filter_sum(s):
    """prec: s is a string
    postc:  the total of all digits in the string is returned."""
    return sum(int(k) for k in s if k.isdigit())


######################Problem 3###########################
def sort_letters_backward(word):
    """prec: word is a lower-case string
    postc: returns a string with the letters in word sorted in reverse
    alphabetical order
    """
    return ''.join(sorted(word, reverse=True))


######################Problem 4###########################


def comb_nest(*x: List[List[int]]):
    """prec: x is a star argument; you pass in a comma separated
    list of lists.
    postc:  returns a list containing the sum of each of
    the nested lists inside of x.
    """
    return [sum(i) for i in x]


######################Problem 5###########################
def paranoid_number(n):
    """prec: n is a nonnegative integer
    postc: returns the nth paranoid number
    paranoid_number(0) = 1
    paranoid_number(1) = 3
    paranoid_number(n+2) = 5*paranoid_number(n-1) -  6*paranoid_number(n)
    """
    return 0


######################Problem 6###########################
def generate_anagrams(word):
    """prec: word is a string with distinct letters
    postc:  generates a list containing all anagrams of
    word in alphabetical order."""

    if len(word) <= 1:
        return word

    # word: List[unique char]
    anagrams = []
    for x in generate_anagrams(word[1:]):
        for i in range(len(word)):
            anagrams.append(x[:i] + word[0:1] + x[i:])

    return sorted(anagrams)

    # using modules
    # import itertools
    # return sorted(set("".join(x) for x in itertools.permutations(word)))


def main():
    # do your testing here.
    print("*************** Problem 1 Tests **************")
    run_test(trim_sum, 13, [[5, 12, 11, 2, 6], 10])
    print("*************** Problem 2 Tests **************")
    run_test(filter_sum, 10, ["c1o2w3s4moo"])
    print("*************** Problem 3 Tests **************")
    run_test(sort_letters_backward, "rmmhea", ["hammer"])
    print("*************** Problem 4 Tests **************")
    run_test(comb_nest, [6, 15, 15], [[1, 2, 3], [7, 8], [10, 3, 2]])
    print("*************** Problem 4 Tests **************")
    run_test(comb_nest, [12, 5], [[1, 2, 9], [1, 2, 2]])
    print("*************** Problem 5 Tests **************")
    print(run_test(paranoid_number, 1, [0]))
    print(run_test(paranoid_number, 3, [1]))
    print("*************** Problem 6 Tests **************")
    run_test(generate_anagrams, ["act", "atc", "cat", "cta", "tac", "tca"], ["cat"])


main()
