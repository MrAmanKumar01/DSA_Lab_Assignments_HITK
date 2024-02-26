/*
3. Write a method in a separate class to evaluate a postfix expression (Consider more than single
digit number as a input).
*/

package _2_Stack;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        //using StringTokenizer to use  one or more digit as input
        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if ( isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token.charAt(0), operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
//        String postfixExpression = "30 4 + 2 *";
//        String postfixExpression = "30 0 / 2 *";
        String postfixExpression = "10 5 + 60 6 / * 8 -";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}

/*
OUTPUT:
Result: 68
-------------
Result: 142
*/