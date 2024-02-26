/*
4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single
digit number as a input)
*/
package _2_Stack;

import java.util.Stack;
import java.util.StringTokenizer;

public class PrefixEvaluator {

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isNumeric(token)) {  //push integer operand(s)
                stack.push(Integer.parseInt(token));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
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

    public static String reversedExp(String prefixExpression) {
        String[] tokens = prefixExpression.split(" ");
        StringBuilder reversedExpression = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            reversedExpression.append(tokens[i]).append(" ");
        }
        System.out.println("Reversed expression is: " + reversedExpression);
        return reversedExpression.toString();
    }

    public static void main(String[] args) {
//        String prefixExpression = "* + 30 4 2";
//        String prefixExpression = "+ 9 * 12 6";
        String prefixExpression = "- / * 2 * 5 + 36 6 5 2";
        int result = evaluatePrefix(reversedExp(prefixExpression));
        System.out.println("Result for " + prefixExpression + " is " + result);
    }
}

/*
OUTPUT:
Reversed expression is: 2 4 30 + *
Result for * + 30 4 2 is 68
----------------------------------------------
Reversed expression is: 6 12 * 9 +
Result for + 9 * 12 6 is 81
----------------------------------------------
Reversed expression is: 2 5 6 36 + 5 * 2 * / -
Result for - / * 2 * 5 + 36 6 5 2 is 82
*/