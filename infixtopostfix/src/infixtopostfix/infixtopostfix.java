/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infixtopostfix;
import java.util.Stack;
import java.util.regex.Pattern;
/**
 *
 * @author darpit
 */
public class infixtopostfix {

    public StringBuilder infixtopostfix(String infix)
    {
        Stack<Character> opr_stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(int i = 0; i < infix.length(); i ++)
        {
            char symbol = infix.charAt(i);
            if(Character.isDigit(symbol))    //if  operand, output it
            {
                //get the whole number
                int number = 0;
                while(Character.isDigit(symbol))
                {
                    number = (number * 10) + ( symbol - '0' );
                    i++;
                    if(i < infix.length())
                        symbol = infix.charAt(i);
                    else
                        break;
                }
                i--;
                String temp = Integer.toString(number);
                postfix.append(temp);
                postfix.append(" ");
            }
            else if(symbol == '(')   //if ( , push it onto stack
            {
                opr_stack.push(symbol);
            }
            else if(symbol == ')')   //if  ), pop operators from stack until '(' 
            {
                while(opr_stack.peek() != '(')
                {
                    char opr = opr_stack.pop();
                    postfix.append(Character.toString(opr));
                    postfix.append(" ");
                }
                opr_stack.pop();
            }
            else if(isOperator(symbol))//check precedence
            {
                while(!opr_stack.empty() && checkPrecedence(symbol) <= checkPrecedence(opr_stack.peek()) )
                {
                    char opr1 = opr_stack.pop();
                    postfix.append(Character.toString(opr1));
                    postfix.append(" ");
                }
                opr_stack.push(symbol);
            }
        }
        //pop remaining opr from the stack
        while(!opr_stack.isEmpty())
        {
            char rem = opr_stack.pop();
            postfix.append(Character.toString(rem));
            postfix.append(" ");
        }
        return postfix;
    }
    
    public double evaluatePostfix(StringBuilder postfix)
    {
        double solution = 0.0;
        Stack<Double> opnd_stack = new Stack<>();
        String[] postfix_exprsn = postfix.toString().split(" ");
        int flag = 0;
        double num = 0.0;
        double a = 0.0;
        double b = 0.0;
        char operator;
        
        for(int j = 0; j < postfix_exprsn.length; j++)
        {
            String t = postfix_exprsn[j];
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
                opnd_stack.push(num);
            }
            else
            {
                //is an operator
                operator = postfix_exprsn[j].charAt(0);
                a = opnd_stack.pop();
                b = opnd_stack.pop();
                solution = operate(a,b,operator);
                opnd_stack.push(solution);
            }
        }
        solution = opnd_stack.pop();
        return solution;
    }
    public double operate(double a, double b, char operator)
    {
        switch (operator)
        {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                if (a == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }
    public int checkPrecedence(char symbol)
    {
        
        switch(symbol)
        {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
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
        String infix = "(1 + 3 + ( ( 4 / 2 ) * ( 8 * 4 ) ))";
        System.out.println("Infix : "+infix+"\n");
        infix = infix.replaceAll("\\s","");
        
        
        infixtopostfix obj = new infixtopostfix();
        StringBuilder postfix =  obj.infixtopostfix(infix);
        System.out.println("Postfix Expression: "+postfix);
        
        double solution = obj.evaluatePostfix(postfix);
        System.out.println("Solution: "+solution);
    }
    
}
