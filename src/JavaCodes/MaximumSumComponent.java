package JavaCodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
//not yet finished
public class MaximumSumComponent {
		public class DualVal{
			public DualVal(Integer i1,Integer i2)
			{
				Item1=i1;
				Item2=i2;
			}
			public Integer Item1;
			public Integer Item2;
		}
		Set<Integer> set;
		 long solve(int V,int E,int[] Values,int[][] Edges){
			
			 set=new HashSet<>();
			 long res=Arrays.stream(Values).max().getAsInt();
			 List<DualVal> list=new ArrayList<>();
			 for(int i=0;i<E;i++)
			 {
				 list.add(new DualVal(Edges[i][0],Edges[i][1]) );
			 }
			 for(int i=0;i<E;i++)
			 {
				 if(!set.contains(Edges[i][0]))
				 {
					 
					 res= Math.max(res, helper(list.get(i),new ArrayList<DualVal>(list),Values));
				 }
			 }
			 return res;
		    }
		 long helper(DualVal val,List<DualVal> list,int[] Values)
		 {
			set.add(val.Item1);
			 list.remove(val);
			 long res=Values[ val.Item1-1];
			 boolean continueEdgeFound=false;
			 DualVal newVal=null;
			 for(int i=0;i<list.size();i++)
			 {
				 if(list.get(i).Item1==val.Item2)
				 {
					 newVal=list.get(i);
					 var newList=new ArrayList<DualVal>(list);
					 newList.remove(newVal);
					 res += helper(newVal, newList,Values);
					 continueEdgeFound=true;
				 }
			 }
			 if(!continueEdgeFound)
			 { res+=Values[ val.Item2-1];
			 set.add(val.Item2);
			 }
			 return res;
			 
		 }
	 
}
