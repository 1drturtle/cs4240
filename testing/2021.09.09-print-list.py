def print_list(x: list):
    """Prints a list recursively, one element at a time

    Args:
        x (list): List of any str-able items
    """
    if not x:
        return
    first, rest = x[0], x[1:]
    print(first)
    print_list(rest)  # recursion, called with rest of the list
    
print_list([1, 2, 3])
