# PrefixExpression
An Expression is in a *prefix form* when operators
are written before their operands. Here are some examples 
of prefix expressions and the values they evaluate to:

| Expression   | Value |
|--------------|-------|
| 12           | 12    |
| +2 51        | 53    |
| * 5 7        | 35    |
| * +16 4 +3 1 | 80    |

An Expression (such as 12) that begins with an integer
is a prefix expression that evaluates to itself. Otherwise,
an expression is a prefix expression if it begins with an operator
and is followed by two prefix expressions. In this latter case, the value of the expression is
recursively computed from the values of its constituent prefix sub-expressions.

Write a program that allows the user to enter prefix expressions in a text field.
The program reads the expression, evaluates it, and displays the value in a suitable GUI component.
Assume that the user enters expressions that only use positive integers and the two operators __+__(Addition) 
and __*__(Multiplication). Your program should use a stack to store operators that have not yet been applied.

