import random
# sorting #3

def swap(x, j, k):
    if j != k:
        x[j],x[k] = x[k],x[j]
        
        
def sort_list(x: list):
    pointer = 0
    while pointer < len(x):
        current = pointer
        while current > 0 and x[current] < x[current - 1]:
            swap(x, current, (current - 1))
            current -= 1
        
        pointer += 1
        
x = list(range(1000))
random.shuffle(x)
print(x[:20])
sort_list(x)
print(x[:20])
