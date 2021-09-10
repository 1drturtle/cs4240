def choose(n, k):
    """Returns amount of possible choices of size k from a combination of size n

    Args:
        n (int)
        k (int)

    Returns:
        int: number of choices
    """
    if k < 0 or k > n:
        return 0
    elif n == 0:
        return 1
    elif n == 1:
        return n
    elif n == k:
        return 1
    return choose(n - 1, k - 1) + choose(n - 1, k)


print(choose(52, 5))