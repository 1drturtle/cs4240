import re
from sys import argv
from operator import itemgetter

file_name = argv[1]

with open(file_name) as fp:
    file_contents = fp.readlines()


def clean_word(word):
    word = re.sub(r"\W", "", word)
    return word.lower()


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
with open('out/output_py_num.txt', 'w') as fp:
    for x, y in sorted_words:
        fp.write(f'{x}: {y}\n')

# Sort Alphabetically
sorted_words = sorted(word_count.items())
with open('out/output_py_alpha.txt', 'w') as fp:
    for x, y in sorted_words:
        fp.write(f'{x}: {y}\n')
