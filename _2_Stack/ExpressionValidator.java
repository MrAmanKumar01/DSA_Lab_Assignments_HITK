/*
2. Write a method in a separate class to check an expression is valid or not.
*/
package _2_Stack;

import java.util.Stack;

public class ExpressionValidator {

    public static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Mismatched opening and closing brackets
                }
            }
        }

        return stack.isEmpty(); // Expression is valid if stack is empty at the end
    }

    public static void main(String[] args) {
        String expression1 = "{[()]}";
        String expression2 = "{[()]}(";
        String expression3 = "{[()]";

        System.out.println("Expression 1 is valid: " + isValidExpression(expression1));
        System.out.println("Expression 2 is valid: " + isValidExpression(expression2));
        System.out.println("Expression 3 is valid: " + isValidExpression(expression3));
    }
}

/*
OUTPUT:
Expression 1 is valid: true
Expression 2 is valid: false
Expression 3 is valid: false
*/