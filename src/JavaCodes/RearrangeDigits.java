package JavaCodes;

import java.util.Arrays;

public class RearrangeDigits {
	public String smallestnum(String N)
    {
		int[] arr=new int[N.length()];
		for(int i=0;i<N.length();i++)
		{
			arr[i]=Character.getNumericValue(N.charAt(i)) ;
		}
		Arrays.sort(arr);
		int noZeros=0;
		String reString = "";
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
			{
				reString+="0";
				noZeros++;
			}
			else {
				break;
			}
		}
		reString = String.valueOf(arr[noZeros])+reString;
		for(int i=noZeros+1;i<arr.length;i++)
			reString+=arr[i];
		return reString;

    }
}
