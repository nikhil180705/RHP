package  RHP;

import java.util.*;

class RemainderTheorem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        PriorityQueue<Integer> zq=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> oq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            oq.add(val);
        }

        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            zq.add(val);
        }
        int ans=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            int ones=oq.poll();
            while(ones-- >0){
                ans=((ans*2)+1)%mod;
            }

            int zeros=zq.poll();
            while(zeros-- >0){
                ans=(ans*2)%mod;
            }
        }
        System.out.println(ans);
    } 
}

