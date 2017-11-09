package String;

import java.util.Stack;

/**
 * Created by liuchong on 2017/11/9.

 20. Valid Parentheses

 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
public class isValid {

    //50%
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    //99.9%
    public boolean isValid1(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') return false;
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') return false;
                    break;
            }
        }
        return head == 0;

    }
}
