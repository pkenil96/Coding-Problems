import java.util.*;

class L1762BuildingWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = heights.length;
        int max = heights[n-1];
        int index = n-2;
        list.add(n-1);
        while(index >= 0){
            if(heights[index] > max){
                max = heights[index];
                list.add(index);
            }
            index--;
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int i=list.size()-1; i>=0; i--){
            res[i] = list.get(k++);
        }
        return res;
    }
}