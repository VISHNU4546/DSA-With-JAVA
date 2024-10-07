// import java.lang.runtime.SwitchBootstraps;
import java.util.*;

public class Sorting {
    
    public static void bubbleSort(int Arr[]){
        boolean result = true;
        for(int i = 0;i<Arr.length-1;i++){
            
           /*
            For Asending  order Sorting
           for(int j =0;j<Arr.length-i-1;j++){
               if(Arr[j]>Arr[j+1]){
                result  = false;
                int temp = Arr[j+1];
                Arr[j+1] = Arr[j];
                Arr[j] = temp;
               }
               
            }*/
 
// For DEsending Order
            for(int j =0;j<Arr.length-i-1;j++){
               if(Arr[j]<Arr[j+1]){
                result  = false;
                int temp = Arr[j+1];
                Arr[j+1] = Arr[j];
                Arr[j] = temp;
               }
               
            }
            
           
    }
        for(int i = 0;i<Arr.length;i++){
            System.out.print( " "+Arr[i] + " ");
        }
          System.out.print(result);
    }

    public static void selectionSort(int N[]){
        for(int i = 0;i<=N.length-1;i++){
            /*
             For Asending  order Sorting
            int minPos =  i;
            for(int j = i+1;j<=N.length-1;j++){
                if(N[minPos]>N[j]){
                  minPos =  j;
                }
            }
        int temp = N[minPos];
        N[minPos] = N[i];
        N[i] = temp;*/

            // For DEsending Order
         int maxPos =  i;
            for(int j = i+1;j<=N.length-1;j++){
                if(N[maxPos]<N[j]){
                  maxPos =  j;
                }
            }
        int temp = N[maxPos];
        N[maxPos] = N[i];
        N[i] = temp;

        }
        for(int i = 0;i<N.length;i++){
            System.out.print( " "+N[i] + " ");
        }
    }
    public static void insertionSort(int N[]){
        for(int i =1;i<N.length;i++ ){
            int curr = N[i];
            int prev = i-1;
            while(prev>=0 && N[prev] > curr){
                N[prev+1] = N[prev];
                prev--;
            }
           N[prev+1] = curr;   
        }
         for(int i = 0;i<N.length;i++){
            System.out.print( " "+N[i] + " ");
        }
    }


    public static void countingSort(int N[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<N.length;i++){
            largest = Math.max(largest, N[i]);
        }
        int count[] = new int[largest+1];
        for(int i = 0;i<N.length;i++){
            count[N[i]]++;
        }
        int j = 0;
        for(int i=count.length-1;i>=0;i--){

            while(count[i]>0){
                N[j] = i;
                j++;
                count[i]--;
            }
        }
        for(int i = 0;i<N.length;i++){
            System.out.print( " "+N[i] + " ");
        }
    }
    public static void main(String args[]){
        int Arr[] = {1,852,652,854,35};
        //bubbleSort(Arr);
        //selectionSort(Arr);
       //insertionSort(Arr);
       //Arrays.sort(Arr);
       countingSort(Arr);
       
    }
}
