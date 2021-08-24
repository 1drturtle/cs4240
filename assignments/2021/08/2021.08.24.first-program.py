#!/usr/bin/python
# Written by Chris Agrella
# 2021/08/24
print('hello world')

x = 5
y = 6
print(f'{x} + {y} = {x+y}')
print(
    '''this is a 
multiline string'''
)

# characters for ascii code 48-63
print('\n'.join([f'{k:<10} {chr(k)}' for k in range(48, 64)]))

# object's memory id
print(hex(id(x)))

# lists have state
x = [1, 2, 3]
x[2] = 4
print(x)