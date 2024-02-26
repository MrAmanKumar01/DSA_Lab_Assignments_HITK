/*
5. Write a method in a separate class to convert an infix expression to its corresponding postfix
expression.
*/
package _2_Stack;

import java.util.Stack;

public class InfixToPostfixConverter {

    public static String infixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            // If character is operand, add to postfix
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }
            // If character is '(' push to stack
            else if (c == '(') {
                stack.push(c);
            }
            // If character is ')', pop and add to postfix until '(' is found
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop '('
            }
            // If character is operator
            else {
                // Pop and add to postfix if precedence of current operator is less than or equal to precedence
                // of top of stack operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop remaining operators from stack and add to postfix
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
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
        String infixExpression = "a+b*(c-d)/e";
//        String infixExpression = "(a+b*c-d)+f-g";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}

/*
OUTPUT:
Infix Expression: a+b*(c-d)/e
Postfix Expression: abcd-*e/+
--------------------------------------
Infix Expression: (a+b*c-d)+f-g
Postfix Expression: abc*+d-f+g-
*/