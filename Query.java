package RHP;

import java.util.*;

class Query{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int ql=sc.nextInt();
        int[][] query=new int[ql][4];

        for(int i=0;i<ql;i++){
            for(int j=0;j<4;j++){
                int val=sc.nextInt();
                query[i][j]=val;
            }
        }

        boolean[] b=new boolean[n];

        for(int i=ql-1;i>=0;i--){
            int left=query[i][0];
            int right=query[i][1];
            int x=query[i][2];
            int y=query[i][3];
            
            int pos=left;
            int increment=1;
            
            while(pos<=right){
                if(!b[pos]){
                    arr[pos]=x;
                    b[pos]=true;
                }
                x+=(increment*y);
                pos+=increment;
                increment++;
            }
        }
        int sum=0;
        // Print the final array
        for(int i=0;i<n;i++){
            sum+=arr[i];
            System.out.print(arr[i]);
            if(i<n-1) System.out.print(" ");
        }

        System.out.println();
        System.out.println(sum);
    }
}