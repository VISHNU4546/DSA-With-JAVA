// import java.util.*;
public class Test {
    
    public static void min_operations(int n, int[] arr, int[] brr) {
        // code here
        int count = 0;
    
        while(count!=5){
           if(n>1){
                int temp = arr[0];
            for(int i =1;i<n;i++){
                arr[i-1] =arr[i];
            }
            arr[n-1] = temp;
            count++;
           }
           for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
            
           }
          System.out.println();
          
          System.out.print("this"+arr[0] +" "+brr[0]+' '+ n);
            System.out.println();
            if(arr[0]==brr[0]){
            for(int i = 0;i<n-1;i++){
                arr[i] = arr[i+1];
                brr[i] = brr[i+1];
               
            }
            count++;
             n--;
        }
        }
        
    System.out.println(count);
    }
    public static void maximum_energy(int n, int[] heights) {
        // code here
        // long int count = 0;
        int size = n;
        int flag = 0;
        long ans[] = new long[n];
        while(n>0){
            ans[flag] = heights[flag];
            for(int i = flag+1;i<n;i++){
                if(heights[i]>heights[i-1]){
                    ans[flag]^=heights[i];
                     System.out.print(ans[flag]+" ");
                }
                
            }
            
            flag++;
            n--;
            System.out.println();
        }
        for(int i =0;i<size;i++){
            System.out.print(ans[i]+" ");
            
           }
        long Eng = ans[0];
        for(int i=1;i<size;i++){
            if(Eng<ans[i]){
                Eng = ans[i];
            }
        }
      System.out.println(Eng);
    }
public static int  count =0;
public static int fib(int n){
    if(n<=1){
        count++;
        return n;
    }
     count++;
    return fib(n-1)+fib(n-2);
}

    public static void main(String args[]){

        int arr[] = {3,1,4,5,6};
        int brr[] = {2,1,3};
        // min_operations(3, arr, brr);
        // maximum_energy(5, arr);
        System.out.println(fib(5) + " " + count);

    }
}
