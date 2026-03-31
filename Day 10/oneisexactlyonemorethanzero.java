import java.util.Scanner;
class extraone{
    public static void  main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        int maxlen=0;
        int start=-1,end=-1;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int ones=0,zeros=0;
            for(int j=i;j<n;j++){
                if(arr[j]==1){
                    ones++;
                }else{
                    zeros++;
                }
                if(ones==zeros+1){
                    if(j-1+1>maxlen){
                        maxlen=j-1+1;
                        start=i;
                        end=j;
                    }
                }
            }
        }
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
