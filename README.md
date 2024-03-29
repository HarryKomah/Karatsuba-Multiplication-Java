# Karatsuba-Multiplication-Java

Karatsuba Multiplication is a multiplication algorithm that works asymtotically faster than "grade school" multiplication.

## Grade School Complexity
To put it simply, any "grade school" math will require double loop for every digit of the first operand to multiply with every digit of the second operand.
This will give us O(n<sup>2</sup>) `O(n^2)`

## Karatsuba Complexity
With karatsuba multiplication, the complexity is reduced as optimal as O(n<sup>log<sub>2</sub>(3)</sup>) `O(n^log2(3))` as opposed to the traditional multiplication `O(n^log2(4))`.
Technically, karatsuba multiplication take advantage of less number of multiplication (recursion roots) from 4 to 3.
