import java.util.*;

class L216CombinationSumIII {
    
    public void solve(int k, int n, List<List<Integer>> result, List<Integer> temp, int index){
        if(n == 0 && temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(n < 0 || temp.size() > k || index > 9){
            return;
        }
        for(int i=index; i<=9; i++){
            temp.add(i);
            solve(k, n-i, result, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(k, n, result, new ArrayList<>(), 1);
        return result;
    }
}