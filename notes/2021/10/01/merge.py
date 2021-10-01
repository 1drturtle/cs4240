import random


def zipper(a: list, b: list):
    out = []

    k, j = 0, 0

    while k < len(a) and j < len(b):
        if a[k] < b[j]:
            out.append(a[k])
            k += 1
        else:
            out.append(b[j])
            j += 1

    out += a[k:]
    out += b[j:]

    return out


def merge(x: list):
    if len(x) <= 1:
        return x

    half = len(x) // 2
    first, second = x[:half], x[half:]

    return zipper(merge(first), merge(second))


if __name__ == '__main__':
    x = list(range(1_000_000))
    
    random.shuffle(x)
    
    print(merge(x)[:100])
