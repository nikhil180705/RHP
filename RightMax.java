package RHP;

public class RightMax {
    public static void main(String[] args){
        int[] arr={2,1,2,3,1};
        int n=arr.length;
        int maxi=arr[0],ops=1;

        for(int i=1;i<n;i++){
            if(arr[i]>=maxi){
                maxi=arr[i];
                ops++;
            }
        }
        System.out.println(ops); 
    }
}
