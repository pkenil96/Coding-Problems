import java.util.*;

public class GetMazePathsWithJumps {

    public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        ArrayList<String> paths = new ArrayList<>();
        backtrack(sr, sc, dr, dc, "", paths);
        return paths;
    }
    
    public static void backtrack(int sr, int sc, int dr, int dc, String path, ArrayList<String> paths){
        if(sr == dr && sc == dc){
            paths.add(path);
            return;
        }
        
        if(sr > dr || sc > dc || sr < 0 || dc < 0){
            return;
        }
        
        // horizontally
        for(int i=1; i<=dc; i++){
            backtrack(sr, sc+i, dr, dc, path+"h"+i, paths);
        }
        
        
        // vertically
        for(int i=1; i<=dr; i++){
            backtrack(sr+i, sc, dr, dc, path+"v"+i, paths);
        }
        
        
        // diagonally
        for(int i=1; i<=dr; i++){
            backtrack(sr+i, sc+i, dr, dc, path+"d"+i, paths);
        }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(getMazePathsWithJumps(0, 0, m-1, n-1));
    }


}