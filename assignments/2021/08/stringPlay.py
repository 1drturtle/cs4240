####################################
# Author: Chris Agrella
#  Date created: 18 Aug 2020
#  Date last modified: 18 Aug 2020
#  Program: stringPlay.py
#
####################################

# ##############Problem 0#################
#   Example problem to show how this works.
#   arg is a lower-case string with at least two instances
#   of the letter q
#   Find the substring of arg between the first and last q
# ########################################

arg = "quoque"
start = arg.find("q")
end = arg.rfind("q")
my_result = arg[start + 1: end]
result = "uo"  # this is my given result
print(result == my_result)  # prints True if you succeeded.

# ##############Problem 1#################
#   Remove all instances of the lower-case letter
#   s from a string.
# ########################################

arg = "sissyphus"
# your code goes here.

my_result = arg.replace('s', '')
result = "iyphu"

assert result == my_result

# ##############Problem 2#################
#   arg is guaranteed to have at least two letters
#   and be an alphabetical string
#   Create a string with the first and last letters of arg.
# ########################################

arg = "heinous"
p2_result_1 = arg[0] + arg[-1]
result = "hs"
assert p2_result_1 == result

arg = "Washington"
p2_result_2 = arg[0] + arg[-1]
result = "Wn"
assert p2_result_2 == result

# ##############Problem 3#################
#   head has an even number of letters
#   tail has an even number of letters
#   Create a string whose first half is the first
#   half of head and the second half of tail.
# ########################################

head = "cerebellum"
tail = "wagger"
p3_result = head[:len(head) // 2] + tail[len(tail) // 2:]
result = "cerebger"
assert result == p3_result

###############Problem 4#################
#   arg is any string
#   Find out how many times the letter b occurs
#   in arg, case INsensitive
#########################################

arg = "Babbage"
p4_result = arg.lower().count('b')
result = 3
assert p4_result == result

###############Problem 5#################
#   arg is any string
#   Find out how many times the letter b occurs
#   in the first 10 letters of arg, case INsensitive
#########################################

arg = "Babbage"
p5_result_1 = arg.lower()[:10].count('b')
result = 3

assert p5_result_1 == result

arg = "flibbertygibbet"
p5_result_2 = arg.lower()[:10].count('b')
result = 2

assert p5_result_2 == result


###############Problem 6#################
#   arg is any string
#   center the string in a string of length 30
#   padded with !s.
#   if the string has more than 30 characers, just
#   display it.  (no conditional logi on your part needed)
#########################################

arg = "wabbit"
p6_result = f'{arg:!^30}'  # justify string in 30 characters using `!` as justification character.
result = "!!!!!!!!!!!!wabbit!!!!!!!!!!!!"

assert p6_result == result

###############Problem 7#################
#   arg is any string
#   get rid of all of the whitespace on the left, if any
#   replace any spaces on the right with @s.
#########################################

arg = "        wabbit    "
p7_result = arg.lstrip().replace(' ', '@')  # will fail if str has space inside of it.

# arg_2 = '   hello world    '.lstrip()

# for x, c in enumerate(arg_2[::-1]):
#     if c != ' ':
#         i = x
#         break
# p8_result_2 = arg_2[:len(arg_2) - x] + '@' * x

result = "wabbit@@@@"

assert p7_result == result
# assert p8_result_2 == 'hello world@@@@'
