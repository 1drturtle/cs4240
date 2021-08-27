# #!/usr/bin/python
# Printing
# Written by Chris Agrella
# 08.27.2021

print('hello')
# allows for comma-seperated
print(1,2,3, True, 'cows', [1,2,3], sep='*') 

x = [1, 2, 3, True, 'cows', [1, 2, 3]]
print(*x, sep='\t', ) # list unpacking

# replace end \n for `asdf`
# print(*x, end='asdf')
print(*x, sep='-=-')

# christmas tree
print('\n'.join(['*'*(i+1) for i in range(6)]))

print(*['*'*(i+1) for i in range(6)], sep='\n')

for i in range(6):
    print('*'*(i+1))
    
print('*')
print('**')
print('***')
print('****')
print('*****')
print('******')


print("""
*
**
***
****
*****
******""")

print('*\n**\n***\n****\n*****\n******')

for i in range(1, 7):
    print('*'*i)
    
# centered format string

for i in range(1, 9):
    if i > 6:
        print(f'{"* *":^30}')
    else:
        spaced = ('* '*i).strip()
        print(f'{spaced:^30}')

[print(f'{"* *":^30}') if i>6 else print(f'{("* "*i).strip():^30}') for i in range(1, 9)]
    
for i in range(1, 9):
    
    if i <= 6:
        spaced = ('* '*i).strip()
        distance = " " * ((30 - len(spaced))//2)
        print(f'{distance}{spaced}{distance}')
    else:
        spaced = ('* '*2).strip()
        distance = " " * ((30 - len(spaced))//2)
        print(f'{distance}{spaced}{distance}')
        
for i in range(1, 9):
    
    def print_row(iters):
        spaced = ('* '*iters).strip()
        distance = " " * ((30 - len(spaced))//2)
        print(f'{distance}{spaced}{distance}')
    
    if i <= 6:
        print_row(i)
    else:
        print_row(2)
