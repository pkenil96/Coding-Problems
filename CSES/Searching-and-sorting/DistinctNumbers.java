import java.util.*;

/*
The solution using Set faces TLE for the last input
*/
public class DistinctNumbers{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		//HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<n; i++){
			array[i] = sc.nextInt();
			//set.add(sc.nextInt());
		}
		Arrays.sort(array);
		int count = 1;
		for(int i=1; i<array.length; i++){
			if(array[i] == array[i-1]){
				continue;
			}
			count++;
		}
		System.out.println(count);
	}
}