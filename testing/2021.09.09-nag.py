def nag():
    x = int(input('Enter a number 1-4: '))
    if x <= 4 and x >= 1:
        print(f'You chose {x}.')
    else:
        nag()
    
nag()