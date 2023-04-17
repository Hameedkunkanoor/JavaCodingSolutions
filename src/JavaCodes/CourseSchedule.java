package JavaCodes;

import java.util.*;

public class CourseSchedule {
	//set for storing the course id's 
	Set<Integer> set ;
	//dictionary for storing the course id as key and it's prerequisites as it's value
	HashMap<Integer, List<Integer>> keyValuePairs;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		keyValuePairs = new HashMap<>();
		for(int i=0; i<numCourses; i++)
			keyValuePairs.put(i, new ArrayList<>());
		//iterate over the prerequisites and then add the prerequisite courses list for each and every course
		for (int i=0;i<prerequisites.length;i++)
		{
			if (keyValuePairs.containsKey(prerequisites[i][0]))
			{
				keyValuePairs.get(prerequisites[i][0]).add(prerequisites[i][1]);
			}
			else
			{
				keyValuePairs.put(prerequisites[i][0],List.of(prerequisites[i][1]) );
			}
		}
		set = new HashSet<Integer>();
		boolean result;

		//we oterate over all the courses because there might be disjoint courses which doesn't need any prerequisites or 
		//which doesn't have joint sets ex: 1->2, 3->4 here both of these are disjoint sets
		for(var item : keyValuePairs.entrySet())
		{
			result =  DFS(item.getKey(), item.getValue());
			if (!result)
				return false;
		}

		return true; 
	}
	public boolean DFS(int curCourseId, List<Integer> list)
	{

		//if the list count is 0 that means it doesn't have any prerequisites so this course
		//can always be completed
		if (list.size() == 0)
			return true;
		//if we have already visited this course and again got this course that means
		// there is a loop and this course schedule cannot be done
		if (set.contains(curCourseId))
			return false;
		//we add this course in the path  
		//this set is for storing all the courses across the current dfs path
		set.add(curCourseId);
		boolean result=true;
		//dfs on all the prerequisites of the current course
		for (int i=0;i<list.size();i++)
		{
			result= DFS(list.get(i), keyValuePairs.get(list.get(i)));
			if (!result)
				return false;
		}
		//we remove this course because we didn't find other occurance of this current course in this path
		set.remove(curCourseId);
		keyValuePairs.put(curCourseId, new ArrayList<>());
		return true;

	}
}
