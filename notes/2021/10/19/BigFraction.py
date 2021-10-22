import math

class BigFraction:
    def __init__(self, num=0, denum=1):
        
        if denum == 0:
            raise ValueError("Denominator cannot be equal to 0.")
        
        if (gcd := math.gcd(denum, num)) != 1:
            num = num//gcd
            denum = denum//gcd
        
        if denum < 0:
            denum *= -1
            num *= -1
        
        
        self.num = num
        self.denum = denum

    def __str__(self):
        return f'{self.num}/{self.denum}'
    
    def __eq__(self, o):
        if not isinstance(o, BigFraction):
            return False
        if o is self:
            return True
        return self.num == o.num and self.denum == o.denum

    def __add__(self, o):
        if not isinstance(o, BigFraction):
            raise ArithmeticError("Cannot add BigFraction and "+o.__class__.__name__)
        return BigFraction(self.num*o.denum+self.denum*o.num, self.denum*o.denum)
    

if __name__ == '__main__':
    # default constructor
    x = BigFraction()
    print(x)
    assert str(x) == "0/1"
    
    # negative swap
    x = BigFraction(3, -4)
    print(x)
    assert str(x) == "-3/4"
    
    # two negatives
    x = BigFraction(-4, -3)
    print(x)
    assert str(x) == "4/3"
    
    # simplify
    x = BigFraction(100, -200)
    print(x)
    assert str(x) == "-1/2"
    
    # zero denum
    try:
        x = BigFraction(1, 0)
    except ValueError as e:
        assert str(e) == "Denominator cannot be equal to 0."
        
    # equals
    x = BigFraction(1, 2)
    y = BigFraction(2, 4)
    
    print(f'{x} == {y}')
    assert x == y
    
    y = BigFraction(2, 3)
    print(f'{x} != {y}')
    assert x != y
    
    # add
    x = BigFraction(1, 2) + BigFraction(1, 2)
    print(f'1/2 + 1/2 = {x}')
    assert str(x) == "1/1"
