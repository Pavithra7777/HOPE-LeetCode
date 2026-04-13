import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
		}int max=arr[n-1],ind=n-1;
		for(int i=n-2;i>=0;i--){
		    if(arr[i]>max){
		        max=arr[i];
		        ind--;
		        arr[ind]=arr[i];
		    }
		}for(int i=ind;i<n;i++){
		   System.out.print(arr[i]+" ");
		}
	}
}
