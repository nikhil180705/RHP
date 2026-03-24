package RHP;

import java.util.*;

class All_in_one_gun {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-- > 0){
            int n=sc.nextInt();
            int h=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            long sum=0;

            for(int i=0;i<n;i++){
                int var=sc.nextInt();
                sum+=var;
                arr[i]=var;
            }

            System.out.println(gun(arr,sum,h,k));
        }
    }

    static long gun(int[] arr, long sum, long h, long k) {

        long rr=(h-1)/sum;
        long ans=rr*(arr.length+k);
        h=h-(rr*sum);

        int n=arr.length;
        int[] dp=new int[n+1];

        for(int i=n-1;i>0;i--){
            int max=Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                max=Math.max(arr[j],max);
            }
            dp[i]=max;
        }

        int lmin=Integer.MAX_VALUE;
        long csum=0;

        for(int i=0;i<n;i++){
            lmin=Math.min(arr[i],lmin);
            csum+=arr[i];

            long csumswap=csum;

            if(i<n-1){
                csumswap=csum-lmin+dp[i+1];
            }

            if(csum>=h){
                return ans + i + 1;
            }

            if(csumswap>=h){
                return ans + i + 1;
            }
        }

        return ans + n;
    }
}