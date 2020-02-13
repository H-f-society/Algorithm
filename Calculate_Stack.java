/*
* @Author: lenovo
* @Date:   2019-09-12 10:23:58
* @Last Modified by:   Administrator
* @Last Modified time: 2019-09-17 17:22:32
*/
import java.util.Stack;

public class Calculate_Stack {
	public static void main(String[] args) {
			System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	public static int calculate(String s) {
		Stack<String> stack = new Stack<>();
        
        for(int i=s.length()-1; i>=0; i--) {           
            if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)==')') {
                stack.push(""+s.charAt(i));
            }
            if(s.charAt(i)>='0' && s.charAt(i)<='9') {
                String num = "";
                while(i>=0 && s.charAt(i)>='0' && s.charAt(i)<='9') {
                    num = s.charAt(i--) + num;
                }
                i++;
                stack.push(num);
            }
            if(s.charAt(i)=='*' || s.charAt(i)=='/') {
            	String fuhao = s.charAt(i--) + "";
            	String number = "";
            	int result = 0;
                while(s.charAt(i) == ' ') {
                	i--;
                }
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9') {
                    number = number +  s.charAt(i--);
                }
                i++;
                if(fuhao.equals("*")) {
            		result = Integer.parseInt(number) * Integer.parseInt(stack.pop());
            	}
            	if(fuhao.equals("/")) {
            		if(Integer.parseInt(stack.peek()) == 0)
            			result = Integer.parseInt(number) / (Integer.parseInt(stack.pop()));
            		else {
            			result = Integer.parseInt(number) / Integer.parseInt(stack.pop());
            		}
            	}
            	stack.push(result + "");
            	fuhao = "";
            	number = "";
            }
            if(s.charAt(i) == '(') {
                String fuhao = "", number = "";
                int result = 0;
                while(!stack.isEmpty()) {
                    if(stack.peek().equals(")")) {
	                    stack.pop();
	                    break;
	                }
                    if(stack.peek().equals("+") || stack.peek().equals("-")) {
                    	fuhao = stack.pop();
                    }else {
                    	number = stack.pop();
                    }
                    result = Integer.parseInt(number);
                    if(!fuhao.equals("") && !number.equals("")) {
                    	if(fuhao.equals("+")) {
                    		result = Integer.parseInt(number) + Integer.parseInt(stack.pop());
                    	}
                    	if(fuhao.equals("-")) {
                    		result = Integer.parseInt(number) - Integer.parseInt(stack.pop());
                    	}
                    	stack.push(result + "");
                    	fuhao = "";
                    	number = "";
                    }
                }
                stack.push(result + "");
            }
        }
        String fuhao = "", number = "";
        int result = 0;
        while(!stack.isEmpty()) {
            if(stack.peek().equals("+") || stack.peek().equals("-")) {
            	fuhao = stack.pop();
            }else {
            	number = stack.pop();
            }
            result = Integer.parseInt(number);
            if(!fuhao.equals("") && !number.equals("")) {
            	if(fuhao.equals("+")) {
            		result = Integer.parseInt(number) + Integer.parseInt(stack.pop());
            	}
            	if(fuhao.equals("-")) {
            		result = Integer.parseInt(number) - Integer.parseInt(stack.pop());
            	}
            	stack.push(result + "");
            	fuhao = "";
            	number = "";
            }
        }
        return result;
	}
}
