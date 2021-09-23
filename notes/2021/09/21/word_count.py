import sys


def is_wanted_character(c):

    return c.isalnum() or c == ' '


def cleanup_word(word: str):
    word = word.strip().lower()
    out = ''
    for letter in word:
        if is_wanted_character(letter):
            out += letter

    return out


def main():

    if len(sys.argv) < 2:
        raise ValueError('Must provide input file name.')

    input_file_name = sys.argv[1]
    output_file_name = input_file_name + '.dump'
    items = {}
    with open(input_file_name, 'r') as fp:
        for line in fp:
            words = line.split()
            for w in words:
                w = cleanup_word(w)
                items[w] = items.get(w, 0) + 1

    with open(output_file_name, 'w') as fp:
        longest_word = max(len(x) for x in items.keys())  # longest word for formatting reasons
        fp.write(title := f'{"Word":<{longest_word}} | Number of Words\n')  # add a title
        fp.write('-' * len(title) + '\n')  # break between title & words

        items = sorted(items.items())  # sort by alphabetically

        for k, v in sorted(items, key=lambda x: x[1], reverse=True):  # Sort through the list
            fp.write(f'{k:<{longest_word}} | {v}\n')


if __name__ == '__main__':
    main()
