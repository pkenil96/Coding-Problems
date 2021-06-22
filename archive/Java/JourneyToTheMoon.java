package hackerrank;

import java.io.*;
import java.util.*;

class DisjointSet{
        int n;
        int [] parent;
        
        DisjointSet(int n){
            this.n=n;
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        
        public int FindSet(int k){
            return parent[k];
        }
        
    
        public void MergeSet(int x , int y){
            
            if(FindSet(x)==FindSet(y))
                return;
            
            int temp,swap;
            if(x>y){
                swap=x;
                x=y;
                y=swap;
            }
            
            temp = parent[x];
            parent[x] = parent[y];
            
            for(int i=0;i<n;i++){
                if(parent[i]==temp)
                    parent[i]=parent[y];
            }
            
        }
        
        public Vector<Integer> getSetSize(){
            
            Vector <Integer> v = new Vector<Integer>();
            int hold,set_size=0;
            int [] used = new int[n];
            
            for(int i=0;i<n;i++){
                used[i]=0;
            }
            
            for(int i=0;i<n;i++){
                
                hold=parent[i];
                set_size=0;
                
                if(used[i]==1)
                    continue;
                      
                for(int j=i;j<n;j++){
                    if((parent[j]==hold) && (used[j]!=1)){
                        used[j]=1;
                        set_size++;
                    }
                    
                }
                v.add((Integer)set_size);
            }
            return v;   
        }    
    }
    
public class JourneyToTheMoon {    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N,P;
        N = sc.nextInt();
        P = sc.nextInt();
        
        DisjointSet ds = new DisjointSet(N);
        
        for(int i=0;i<P;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ds.MergeSet(a,b);
        }
        
        Vector <Integer> v = ds.getSetSize();
        Integer answer = 0;
        int m = v.size();
        
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                answer+=v.get(i)*v.get(j);
            }
        }
        System.out.println(answer);
        
        
        
    }
}
