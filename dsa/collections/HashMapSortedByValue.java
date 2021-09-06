import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.LinkedHashMap;

public class HashMapSortedByValue{
	public static void main(String[] args) {
		HashMap<Character, Integer> map = new HashMap<>();
		String word = "heythereiamusingwhatsapp";
		for(Character ch: word){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
		}

		// sorting the hashmap by value
		List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
			public int compare(Map.Entry<Character, Inteer> o1, Map.Entry<Character, Inteer> o2){
				return (o1.getValue().compareTo(o2.getValue()));
			}
		});

		HashMap<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Map.Entry<Character, Integer> entry: list){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
	}
}