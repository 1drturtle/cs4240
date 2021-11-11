import re
from sys import argv

regex = argv[1]
seeker = re.compile(regex)

with open('hughJass.txt', 'r') as fp:
    for line in fp:
        if seeker.match(line):
            print(line, end='')
