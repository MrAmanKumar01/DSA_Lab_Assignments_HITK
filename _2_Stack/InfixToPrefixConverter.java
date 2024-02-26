/*
6. Write a method in a separate class to convert an infix expression to its corresponding prefix
expression.
*/
package _2_Stack;

import java.util.Stack;

public class InfixToPrefixConverter {

    public static String infixToPrefix(String infixExpression) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        // Reverse the infix expression to simplify conversion
        String reversedInfix = new StringBuilder(infixExpression).reverse().toString();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);

            // If character is operand, add to prefix
            if (Character.isLetterOrDigit(c)) {
                prefix.append(c);
            }
            // If character is ')', push to stack
            else if (c == ')') {
                operatorStack.push(c);
            }
            // If character is '(', pop from stack and add to prefix until ')' is found
            else if (c == '(') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != ')') {
                    prefix.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop ')'
            }
            // If character is operator
            else {
                // Pop and add to prefix if precedence of current operator is less than precedence
                // of top of stack operator
                while (!operatorStack.isEmpty() && precedence(c) < precedence(operatorStack.peek())) {
                    prefix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        // Pop remaining operators from stack and add to prefix
        while (!operatorStack.isEmpty()) {
            prefix.append(operatorStack.pop());
        }

        // Reverse the prefix expression to get the correct order
        return prefix.reverse().toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        String infixExpression = "(A-B/C)*(A/K-L)";
//        String infixExpression = "a+b*(c-d)/e";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}

/*
OUTPUT:
Infix Expression: (A-B/C)*(A/K-L)
Prefix Expression: *-A/BC-/AKL
------------------------------------
Infix Expression: a+b*(c-d)/e
Prefix Expression: +a/*b-cde
*/


