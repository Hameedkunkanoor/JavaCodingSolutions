package JavaCodes;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringwithUniqueCharacters {

	 
	 public int MaxLength(List<String> arr)
     {
         String result = String.join("",arr);
         var m=result.chars().toArray();
       int max=(int) result.chars().distinct().count();
         int res= helper(0, "", max, arr);
         return res;
     }
     public int helper(int currLen,String currStr,int max,List<String> subArray)
     {
    	 String newStr = "";
         for( int i = 0; i < subArray.size(); i++)
         {
             newStr += currStr + subArray.get(i);
             var newList = new ArrayList<String>(subArray);
             if(IsUnique(newStr))
             {
                 newList.remove(i);
                  var result= helper(newStr.length(),newStr,max,newList);
                 if (result > currLen)
                     currLen = result;
                 if (result == max)
                     return max;
             }
             newStr = "";
         }
         return currLen;
     }
     public boolean IsUnique(String str)
     {
    	 Set<Character> set=new HashSet<Character>();
         for(var item : str.toCharArray())
         {
             if (set.contains(item))
                 return false;
             set.add(item);

         }
         return true;
     }
	 
}
