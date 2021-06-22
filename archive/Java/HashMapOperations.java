package syntax;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

class HashMapOperations{

	public static void printSet(Set <Integer> set){
		if(set == null || set.size() == 0)
			return;

		Iterator <Integer> itSet = set.iterator();
		while(itSet.hasNext()){
			System.out.print(itSet.next() + " ");
		}

		System.out.println();
	}

	public static Set<Integer> getKeys(HashMap <Integer, String> hmap, String value){
		if(hmap == null || hmap.size() == 0)
			return null;

		if(!hmap.containsValue(value)){
			System.out.println("HashMap does not contain the value:" + value);
			return null;
		}

		Set <Integer> set = new HashSet<>();
		Iterator it = hmap.keySet().iterator();
		while(it.hasNext()){
			Integer key = (Integer) it.next();
			if(hmap.get(key) == value){
				set.add(key);
			}
		}
		return set;
	}

	public static void main(String[] args) {

		HashMap <Integer, String> hmap = new HashMap<>();
		hmap.put(14, "Bob");
		hmap.put(43, "Gilbert");
		hmap.put(-8, "Bobby");
		hmap.put(41, "Karlee");
		hmap.put(64, "Shivika");
		hmap.put(-1, "Ram");
		hmap.put(12, "Gilbert");

		//using the keySet() for getting only the keys
		for(Integer key : hmap.keySet()){
			System.out.println(key + "-->" + hmap.get(key));
		}

		System.out.println();

		//using the values() for getting only the values
		for(Object value : hmap.values()){
			System.out.println(value);
		}

		System.out.println();

		//Using the entrySet for getting the keys and values
		Iterator itMap = hmap.entrySet().iterator();
		while(itMap.hasNext()){
			Map.Entry pair = (Map.Entry)itMap.next();
			Integer key = (Integer)pair.getKey();
			String value = (String)pair.getValue();
			System.out.println(key + "-->" + value);
			
			//if(key % 2 == 0){
			//	itMap.remove(); // using this approach helps to prevent ConcurrentMoficiationException while modifying the HashMap
			//}
		}

		//getting the key for a given value
		System.out.println();

		Set <Integer> set;
		set = getKeys(hmap, "Bob");
		System.out.println("Keys for " + "Bob: ");
		printSet(set);

		set = getKeys(hmap, "Gilbert");
		System.out.println("Keys for " + "Gilbert: ");
		printSet(set);

		set = getKeys(hmap, "Ram");
		System.out.println("Keys for " + "Ram: ");
		printSet(set);
		//Sorting the HashMap by key


	}
}