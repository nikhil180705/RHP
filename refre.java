package RHP;
import java.util.*;
public class refre {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int xor=arr[0];
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }

        int set=1;
        while((xor&1)==0){
            xor>>=1;
            set++;
        }
        int og=0,zg=0;
        for(int v:arr){
            if((v&set)==0){
                zg^=v;
            }
            else{
                og^=v;
            }
        }
        System.out.println(og+" "+zg);
    }
}
