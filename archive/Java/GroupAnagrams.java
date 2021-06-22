package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class GroupAnagrams{

	public static String getElementCode(String element){
		char [] characters = element.toCharArray();
		Arrays.sort(characters);
		return new String(characters);
	}

	public static List <List<String>> GroupAnagramsUtil(String [] strs){
		//sorting each item in the given list
		HashMap <String, List<String> > hmap = new HashMap<String, List<String>>();

		for(int i=0; i<strs.length; i++){
			// this code refers to the sorted value of the given element
			String elem_code = getElementCode(strs[i]); 
			if(hmap.containsKey(elem_code)){
				//in case the code is already present in the hashmap, we append the
				//current element to the list pointing to the code
				hmap.get(elem_code).add(strs[i]);
			} else {
				//if there is no key with the given code, we create an empty list,
				//and add the current element into that list. That list is stored
				//as value to the given elem_code
				List <String> newArrayList = new ArrayList<>();
				newArrayList.add(strs[i]);
				hmap.put(elem_code, newArrayList);
			}
		}
		List<List<String>> answer = new ArrayList<List<String>>(hmap.values());
		return answer;
	}

	public static void main(String[] args) {
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		List <List<String>> ans = GroupAnagramsUtil(strs);
		System.out.println(ans); 
	}
}