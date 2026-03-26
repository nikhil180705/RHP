package RHP;
import java.util.*;
public class DP {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }

        solve(grid,n,m);
    }

    public static void solve(int[][] grid,int n,int m){
        int[][] dp=new int[n][m];

        int fm=Integer.MIN_VALUE;
        int sm=Integer.MIN_VALUE;
        
        for(int j=0;j<m;j++){
            if(grid[0][j]>fm){
                sm=fm;
                fm=grid[0][j];
            }
            else if(grid[0][j]>sm){
                sm=grid[0][j];
            }
            dp[0][j]=grid[0][j];
        }

        for(int i=1;i<n;i++){
            int fm1=0;
            int sm1=0;
            for(int j=0;j<m;j++){
                if(grid[i-1][j]==fm){
                    dp[i][j]=grid[i][j]+sm;
                }
                else{
                    dp[i][j]=grid[i][j]+fm;
                }
                if(dp[i][j]>fm1){
                    sm1=fm1;
                    fm1=dp[i][j];   
                }
                else if(dp[i][j]>sm1){
                    sm1=dp[i][j];
                }
            }
            fm=fm1;
            sm=sm1;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(fm);
    }
}
