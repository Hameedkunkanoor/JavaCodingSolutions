package JavaCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
          
      List<List<Integer>> result=new ArrayList<>();
        //iterating from start to end
        //we need to sort the array so that all duplicates will be in place and we can ignore duplicates
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            // we need to findout a triplet(a,b,c) whose sum is equal to zero 
            int a=nums[i];
            // we will check for b and c in remaining array starting from i+1 to nums.length
            int low=i+1,high=nums.length-1;
            while(low<high)
            {
               
                if(a+nums[low]+nums[high] == 0)
                {
                     //we found a triplet
                     result.add(Arrays.asList(a,nums[low],nums[high]));
                     //now it's time to increment low and decrement high to check for any other possible triplet
                    
                     while( low<high && nums[low]==nums[low+1]  )
                        low++;
                     while( low <high && nums[high]==nums[high-1]  )
                        high--;
                     low++;
                     high--;
                    
                }
                else if(nums[low]+nums[high]+a > 0)
                {               
                    high--;
                }
                else
                {
                    low++;
                }
            }

        }
        return result.stream().distinct().collect(Collectors.toList());
 
    }
}