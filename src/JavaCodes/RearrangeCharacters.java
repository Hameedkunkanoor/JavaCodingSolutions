package JavaCodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//not yet solved
public class RearrangeCharacters {
	boolean rearrangeString(String S) {
	    //code here
		var arr=Stream.of(S.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		int totalEmptySpaces=0;
		var max=Collections.max(arr.values()) ;
		List<Long> list=new ArrayList<>();
		for(var entry:arr.entrySet())
		{
			if(entry.getValue()==1)
				totalEmptySpaces++;
			else
				list.add(entry.getValue());
		}
		
		System.out.print(max);
		return false;
	}
}
