package Fundamentals.Algortihms_part_1.Week_1;

import java.util.HashSet;
import java.util.Scanner;

class QuickFind{
    // This Algorthium uses integer datastructure and
    // has O(1) time access for connected query and 
    // O(N^2) access for union command if there were 
    // 10^9 operations and 10^9 memory words to access then 
    // it takes 30+ years time to compute this quadratic algorithum doesnt scale
    private int[] id;
    public QuickFind(int n){
        id=new int[n];
        for(int i=0;i<n;i++)
            id[i]=i;
    }
    public int count(){
        HashSet<Integer> hs=new HashSet<>();
        for(int i:id)
            hs.add(i);
        return hs.size();
    }
    public boolean connected(int p,int q){
        return id[p]==id[q];
    }
    public void union(int p,int q){
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++)
            if(id[i]==pid)
                id[i]=qid;
    }
}
class QuickUnion{
    // This algorithum is a beauty and a curse which checks for the parent and
    // dosent alter every thing in array like the quickfind the time complexity is O(N) for checking connected and intilizaton operations
    // and O(N*Q) it takes q operations to find the root of the node
    //This implenatation is very costly if the trees gets bigger 
    private int id[];
    public QuickUnion(int n){
        id=new int[n];
        for(int i=0;i<n;i++)
            id[i]=i;
    }
    // Chase parent pointers unitl reach root depth of i array access
    private int root(int i){
        while(i !=id[i]){
            id[i]=id[id[i]]; // this line is added for path compression 
            // the time complexity will be n + m log n
            i=id[i];
        }
        return i;
    }
    public int count(){
        HashSet<Integer> hs=new HashSet<>();
        for(int i:id)
            hs.add(i);
        return hs.size();
    }
    public boolean connected(int p,int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int i=root(p);
        int j=root(q);
        id[i]=j;
    }
}

class WQuickUnion{
    private int id[];
    private int sz[];
    public WQuickUnion(int n){
        id=new int[n];
        sz=new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
            sz[i]=1;
        }
    }
    // stackoverflow link and explanation 
    // https://stackoverflow.com/questions/12696803/weighted-quick-union-with-path-compression-algorithm
    // Chase parent pointers unitl reach root depth of i array access
    private int root(int i){
        while(i !=id[i]){
            id[i]=id[id[i]]; // the weighted quick with path compression is 
            // faster it can address real world problems at ease 
            // time complexit is n + m lg* n
            i=id[i];
        }
        return i;
    }
    public int count(){
        HashSet<Integer> hs=new HashSet<>();
        for(int i:id)
            hs.add(i);
        return hs.size();
    }
    public boolean connected(int p,int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int i=root(p);
        int j=root(q);
        if(i==j) return ;
        if(sz[i] < sz[j]){
            id[i]=j;
            sz[j] += sz[i];
        }
        else{
            id[j]=i;
            sz[i] += sz[j];
        }
    } 
}
class QuickUnionUF {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //indicates number of objects to be stored 
        int t=sc.nextInt();
        QuickFind qf=new QuickFind(t);
        while(t-->0){
            int p=sc.nextInt();
            int q=sc.nextInt();
            if(qf.connected(p, q))
                continue;
            qf.union(p, q);
            System.out.println(p+"->"+q);
        }
        sc.close();
        System.out.println(qf.count()+" connected components in QucikFind");
    }
}