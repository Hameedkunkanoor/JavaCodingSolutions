package JavaCodes;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
//	 public int[] searchRange(int[] nums, int target) {
//	        
//	    }
	  public int lengthOfLongestSubstring(String s) {
	        //iter over the string
		  //maintain set to check vals
		  Set<Character> set=new HashSet<>();
		  for(int i=0;i<s.length();i++)
		  {
			  if(set.contains(s.charAt(i)))
			  {
				  
			  }
		  }
		  return 0;
	    }
}
