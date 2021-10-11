import java.util.*;

public class HashMapSortedByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("N", 2);
        map.put("B", 2);
        map.put("R", 4);
        map.put("X", 5);
        map.put("K", 3);
        
        // sorting the map by values
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
                return (entry1.getValue() == entry2.getValue()) ? entry1.getKey().compareTo(entry2.getKey()) :  entry2.getValue() - entry1.getValue();
            }
        });
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}