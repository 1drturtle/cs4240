# CS Notes 10/25

## Visibility

- Type of the variable determines what variables/methods are visible

## Delegation

- The Object is in charge of executing the code, not the type class.

```java
jshell> Shape s = new Rectangle(6, 8);
jshell> s.numSides();
|  Error:
|  cannot find symbol
|    symbol:   method numSides()
|  s.numSides();
|  ^--------^
jshell> Rectangle r = new Rectangle(6, 8);
jshell> r.numSides();
$3 ==> 4
```
