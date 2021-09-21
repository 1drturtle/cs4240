# ###########################################################
#   Author: Chris Agrella
#   Date created:  2021-09-17
#   run_test Module
#   FREE CODE FOR WRITING TESTS
#   Usage is demonstrated on examples below
# ################ DO NOT CHANGE THIS CODE ###################
TOLERANCE = 1e-6


# credit: Morrison
def compare_floats(x, y):
    return abs(x - y) < TOLERANCE


def run_test(function, expected, args, debug=False):
    output = function(*args)
    f_name = f'[Function {function.__name__}]'
    if output == expected:
        out = f'{f_name:<30} | Test PASSED'
        if debug:
            out += f': {args = } | ({output = }) == ({expected = })'
        print(out)
    else:
        out = f'{f_name:<30} | Test FAILED: {args = } | {output = } | {expected = }'
        print(out)


def run_test_float(function, expected, args, debug=False):
    output = function(*args)
    f_name = f'[Function {function.__name__}]'
    if compare_floats(output, expected):
        out = f'{f_name:<30} | Test PASSED'
        if debug:
            out += f': {args = } | ({output = }) == ({expected = })'
        print(out)
    else:
        out = f'{f_name:<30} | Test FAILED: {args = } | {output = } | {expected = }'
        print(out)


if __name__ == '__main__':

    # test code please ignore

    def testing(x: int):

        return x / 2

    run_test(testing, 6, [2])
    run_test_float(testing, 1.5, [3])
