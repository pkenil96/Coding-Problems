import java.util.HashMap;
import java.util.Map;

public class DisjointSetString {
	Map<String, String> parent;
	
	public DisjointSetString() {
		parent = new HashMap<>();
	}
	
	public void union(String s1, String s2) {
		String ps1 = find(s1);
		String ps2 = find(s2);
		if(ps1 == ps2) {
			return;
		}
		parent.put(ps1, ps2);
	}
	
	public String find(String x) {
		if(!parent.containsKey(x)) {
			return x;
		}
		String str = x;
		while(parent.containsKey(str)) {
			str = parent.get(str);
		}
		parent.put(x, str);
		return str;
	}
	
	public static void main(String[] args) {
		DisjointSetString ds = new DisjointSetString();
		ds.union("Kenil", "Doug");
		ds.union("Matt", "Gill");
		ds.union("Kenil", "Gill");
		ds.union("Victor", "Bharat");
		ds.union("Ned", "Manu");
		ds.union("Phill", "Manu");
		System.out.println("Matt and Doug same family? " + ds.find("Matt").equals(ds.find("Doug")));
		System.out.println("Matt and Gill same family? " + ds.find("Matt").equals(ds.find("Gill")));
		System.out.println("Victor and Ned same family? " + ds.find("Victor").equals(ds.find("Ned")));
		System.out.println("Matt and Manu same family? " + ds.find("Matt").equals(ds.find("Manu")));
	}
}
