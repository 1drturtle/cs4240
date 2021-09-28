from sys import argv
from typing import List


def load_words(file_name: str) -> List[str]:
    with open(file_name, "r") as fp:
        return fp.readlines()


def sort_names(words: list, word: str):

    if len(words) == 1:
        return word == words[0].strip()

    middle = words[len(words) // 2].strip()

    if word > middle:
        return sort_names(words[len(words) // 2:], word)
    elif word < middle:
        return sort_names(words[:len(words) // 2], word)
    elif word == middle:
        return True


def sort_names_while(words: list, word: str):
    found = False
    while not found:
        if len(words) == 1:
            found = word == words[0].strip()
            break

        middle = words[len(words) // 2].strip()

        if word > middle:
            words = words[len(words) // 2:]
            continue
        elif word < middle:
            words = words[: len(words) // 2]
            continue
        elif word == middle:
            found = True
    return found


def main():
    if len(argv) < 2:
        print("[Error] You must specify a word to search for")
        exit(1)

    input_file, search_word = "scrabble.txt", argv[1].upper()

    result = sort_names_while(load_words(input_file), search_word)
    if result:
        print(f"Found word {search_word} in SCRABBLE file.")
    else:
        print(f"Could not find word {search_word} in SCRABBLE file.")


main()
