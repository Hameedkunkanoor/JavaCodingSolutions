package JavaCodes;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		/* s=new StringBuilder(s).reverse().toString(); */
		   Stack<String> stack=new Stack<>();
	        for(int i=0;i<s.length();i++)
	        {
	        	stack.push(Character.toString(s.charAt(i)));
	        }
	        String res="";
	        String tempString="";
	        while(stack.size()>0)
	        {
	        	var ele=stack.pop();
	        	if(ele == "[")
	        	{
	        		var value=Integer.parseInt(stack.pop());
	        		String temp="";
	        		for(int i=0;i<value;i++)
	        			temp+=tempString;
	        		res=temp;
	        		if(stack.size()==0)
	        			return temp;
	        		stack.push(temp);
	        		tempString="";
	        	}
	        	else if(ele != "]")
	        	{
	        		tempString=ele+tempString;
				}
	        	else {
	        		tempString=tempString;
				}
	        }
	        return res;
	        
    }
}
