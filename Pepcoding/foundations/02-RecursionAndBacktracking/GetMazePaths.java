import java.util.*;

public class GetMazePaths {

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> paths = new ArrayList<>();
        backtrack(sr, sc, dr, dc, "", paths);
        return paths;
    }
    
    public static void backtrack(int sr, int sc, int dr, int dc, String path, ArrayList<String> paths){
        // if current row and column is equal to the destination, add the current path to solution
        if(sr == dr && sc == dc){
            paths.add(path);
            return;
        }
        
        if(sr > dr || sc > dc || sr < 0 || dc < 0){
            return;
        }

        backtrack(sr, sc+1, dr, dc, path+"h", paths);
        backtrack(sr+1, sc, dr, dc, path+"v", paths);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(getMazePaths(0, 0, m-1, n-1));
    }
}