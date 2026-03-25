package RHP;

import java.util.*;

public class BeautifulTree {
    static int dfs(Map<Integer,List<Integer>> m,Map<Integer,Integer> color,Set<Integer> visited,int node,int c){
        int maxNode=0;
        boolean flag=false;
        if(!visited .contains(node)){
            visited.add(node);
            flag=true;
        }
                    
        for(int child:m.get(node)){
             maxNode=dfs(m,color,visited,child,c);
            
        }
        if(flag) maxNode++;
        return maxNode; 
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Map<Integer,List<Integer>> m=new HashMap<>();

        for(int i=1;i<=n;i++){
            m.put(i,new ArrayList<>());
        }
       
        for(int i=1;i<=n;i++){
            int node=sc.nextInt();
            m.get(node).add(i);
            
        }
        Map<Integer,Integer> color=new HashMap<>();
        for(int i=1;i<=n;i++){
            color.put(i,sc.nextInt());
        }

        int query=sc.nextInt();
        int ans=0;
        Map<Integer,Integer> cache=new HashMap<>();
        for(int i=0;i<query;i++){
            int q=sc.nextInt();
            int maxNode=0;
            if(!cache.containsKey(q)){
                Set<Integer> visited=new HashSet<>();
                maxNode=dfs(m,color,visited,q,color.get(q));
                cache.put(q,maxNode);
            }
            ans=(ans+maxNode)%1000000007;
        }
        System.out.println(ans);


    }
}
}