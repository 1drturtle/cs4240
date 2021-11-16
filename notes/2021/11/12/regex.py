import re
from sys import argv
from operator import itemgetter
from typing import List, Tuple

file_name = argv[1]

with open(file_name) as fp:
    file_contents = fp.readlines()


def clean_word(word):
    word = re.sub(r"\W", "", word)
    return word.lower()


def to_table(header: List[str], items: List[Tuple]):
    padding = max(max(len(x[0]) for x in items), len(header[0]))
    padding_two = max(max(len(str(x[1])) for x in items), len(header[1]))
    title = f'|{header[0]:^{padding+2}}|{header[1]:^{padding_two+2}}|'
    yield title

    yield f'|{"-"*(padding+2)}|{"-"*(padding_two+2)}|'
    for x, y in items:
        yield f'| {x:<{padding}} | {y:<{padding_two}} |'


word_count = dict()

for line in file_contents:
    words = line.split()
    for word in words:
        word = clean_word(word)
        if not word:
            continue
        word_count[word] = word_count.get(word, 0) + 1

# Sort by value
sorted_words = sorted(word_count.items(), key=itemgetter(1), reverse=True)
padding = max(30, max(len(x[0]) for x in sorted_words))
with open('out/output_py_num.txt', 'w') as fp:
    for x in to_table(['Word', 'Occurrences'], sorted_words):
        fp.write(x + '\n')

# Sort Alphabetically
sorted_words = sorted(word_count.items())
with open('out/output_py_alpha.txt', 'w') as fp:
    for x in to_table(['Word', 'Occurrences'], sorted_words):
        fp.write(x + '\n')
