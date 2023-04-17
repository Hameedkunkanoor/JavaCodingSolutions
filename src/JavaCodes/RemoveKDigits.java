package JavaCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        boolean end=false;
       List<Character> res=new ArrayList<>();
       for(char ch: num.toCharArray())
       {
    	   res.add(ch);
       }
    	while(!end)
    	{
    		for(int i=0;i<res.size()-1;i++)
    		{
    			if( Character.getNumericValue(res.get(i))>=Character.getNumericValue(res.get(i+1)))
    			{
    				res.remove(i);
    				break;
    			}
    			if(i==res.size()-2)
    			{
    				end=true;
    			}
    		}
    	}
    	var res2= res.toString();
    	return res2;
    }
}
