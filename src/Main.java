// Java program to evaluate
// a prefix expression.
import java.io.*;
import java.util.*;

import static java.lang.System.exit;

class Main {

    static Boolean isOperand(char c)
    {
        // If the character is a digit
        // then it must be an operand
        if (Character.isDigit(c))
            return true;
        else
            return false;
    }

    static double evaluatePrefix(String exprsn)
    {
        Stack<Double> Stack = new Stack<Double>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {

            // Push operand to Stack
            // To convert exprsn[j] to digit subtract
            // '0' from exprsn[j].
            if (isOperand(exprsn.charAt(j)))
                Stack.push((double)(exprsn.charAt(j)-48));//converts the string to ASCII Value

            else {

                // Operator encountered
                // Pop two elements from Stack
                double o1 = Stack.peek();//Views w/o deleting
                Stack.pop();
                double o2 = Stack.peek();
                Stack.pop();

                // Use switch case to operate on o1
                // and o2 and perform o1 Or o2.
                switch (exprsn.charAt(j)) {
                    case '+':
                        Stack.push(o1 + o2);
                        break;
                    case '-':
                        Stack.push(o1 - o2);
                        break;
                    case '*':
                        Stack.push(o1 * o2);
                        break;
                    case '/':
                        Stack.push(o1 / o2);
                        break;
                    default:
                        System.out.println("Illegal operator");
                        exit(1);//Exits with 1 instead of zero as it was not expected result
                }
            }
        }

        return Stack.peek();
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        String exprsn = "+9*26";
        System.out.println(evaluatePrefix(exprsn));
    }
}