/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infixToPostfixExpressionEvaluation;
import java.util.Stack;
import java.util.regex.Pattern;
/**
 *
 * @author manja
 */
public class infixToPostfixExpressionEvaluation_mitali {

    public StringBuilder infixToPostfix(String infixExpression)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();
        for(int i = 0; i < infixExpression.length(); i ++)
        {
            char c = infixExpression.charAt(i);
            if(Character.isDigit(c))    //if character is an operand, output it
            {
                //check if the digit has more digits in continuation to it 
                int number = 0;
                while(Character.isDigit(c))
                {
                    number = (number * 10) + ( c - '0' ); //since c is a character, to get the integer value from it, c will contain the ascii value of the digit. to get the int value from it we subtract '0'. example: '1' - '0' = 49 - 48 == 1
                    i++;
                    if(i < infixExpression.length())
                        c = infixExpression.charAt(i);
                    else
                        break;
                }
                i--;
                String temp = Integer.toString(number);
                postfixExpression.append(temp);
                postfixExpression.append(" ");
                System.out.println("postfixExpression:"+postfixExpression);
            }
            else if(c == '(')   //if character is ( , push it onto stack
            {
                stack.push(c);
            }
            else if(c == ')')   //if character is ), pop operators from stack until '(' is popped, don't output the paranthesis
            {
                while(stack.peek() != '(')
                {
                    char opr = stack.pop();
                    postfixExpression.append(Character.toString(opr));
                    postfixExpression.append(" ");
                }
                stack.pop();
            }
            else if(isOperator(c))//check precedence, pop higher or equal precedence opr, stop before popping a '(' or lower precedence opr. push the opr.
            {
                while(!stack.empty() && findPrecedence(c) <= findPrecedence(stack.peek()) )
                {
                    char opr1 = stack.pop();
                    postfixExpression.append(Character.toString(opr1));
                    postfixExpression.append(" ");
                }
                stack.push(c);
            }
        }
        //pop remaining opr from the stack
        while(!stack.isEmpty())
        {
            char opr2 = stack.pop();
            postfixExpression.append(Character.toString(opr2));
            postfixExpression.append(" ");
        }
        return postfixExpression;
    }
    
    public double evaluatePostfixExpression(StringBuilder postfixExpression)
    {
        double answer = 0.0;
        Stack<Double> stack1 = new Stack<>();
        String[] expression = postfixExpression.toString().split(" ");
        int flag = 0;
        double num = 0.0;
        double opnd1 = 0.0;
        double opnd2 = 0.0;
        char operator;
        
        for(int j = 0; j < expression.length; j++)
        {
            String t = expression[j];
            try
            {
                num  = Double.parseDouble(t);
                flag = 1;
            }
            catch(NumberFormatException e)
            {
                flag = 0; 
            }
            if(flag == 1)
            {
                //is an operand
                stack1.push(num);
            }
            else
            {
                //is an operator
                operator = expression[j].charAt(0);
                opnd1 = stack1.pop();
                opnd2 = stack1.pop();
                answer = performOperation(opnd1,opnd2,operator);
                stack1.push(answer);
            }
        }
        answer = stack1.pop();
        return answer;
    }
    public double performOperation(double opnd1, double opnd2, char operator)
    {
        switch (operator) {
            case '+':
                return opnd2 + opnd1;
            case '-':
                return opnd2 - opnd1;
            case '*':
                return opnd2 * opnd1;
            case '/':
                if (opnd1 == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return opnd2 / opnd1;
        }
        return 0;
    }
    public int findPrecedence(char c)
    {
        
        switch(c)
        {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
        }
        return 0;
    }
    
    public static boolean isOperator(char c)
    {
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String infixExpression = "(4 + 8) * (6 - 5)/((3 - 2) * (2 + 2))";
        System.out.println("Infix Expression: "+infixExpression+"\n");
        infixExpression = infixExpression.replaceAll("\\s","");
        
        
        infixToPostfixExpressionEvaluation_mitali obj = new infixToPostfixExpressionEvaluation_mitali();
        StringBuilder postfixExpression =  obj.infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: "+postfixExpression);
        
        double answer = obj.evaluatePostfixExpression(postfixExpression);
        System.out.println("Answer: "+answer);
    }
    
}
