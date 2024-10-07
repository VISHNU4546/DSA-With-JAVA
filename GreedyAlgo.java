import java.util.*;
public class GreedyAlgo {
    

    static int ActivitySec(int activites[][]){
      
        int count = 1;

        int currEnd = activites[0][2];
        for(int i =1;i<activites.length;i++){
          
           
            if(currEnd<=activites[i][1]){
                count++;
                 currEnd = activites[i][2];
            }
            
           
             


        }
        return count;
    }
    public static void main(String args[]){
//     int start[] = {1,3,0,5,8,5};
//     int end[] ={2,4,6,7,9,9};
// int activites[][] = new int[start.length][3];
// for(int i = 0;i<start.length;i++){
//     activites[i][0] = i;
//     activites[i][1] = start[i];
//     activites[i][2] =end[i];
// }
// //lembda function
// //2-D Array Sortring
// Arrays.sort(activites,Comparator.comparingDouble(o->o[2]));
    // System.err.println(ActivitySec(activites));

//     int values[] = {60,100,120};
//    int  weight[] = {10,20,30};
//    int W = 50;
//    System.out.println(FractionalKnapsack(values,weight,W,3));
// int A[] = {1,2,3};
// int B[] = {2,3,1};
// System.err.println(MinimumABSSum(A, B));

System.err.println(Mincoin(1059));
        
    }

    static int FractionalKnapsack(int values[],int weight[],int W,int n){
        int profit =  0;

      
    double ratio[][] = new double[n][2];
        for(int i=0;i<n;i++){
            ratio[i][0] = i;
            ratio[i][1] =(values[i]/(double)weight[i]);
        }
     Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));


     for(int i = ratio.length-1;i>=0;i--){
     int idx = (int)ratio[i][0];
        if(W>=weight[idx]){
            W -=weight[idx];
            profit +=values[idx]; 

        }
        else{
            profit += W*ratio[i][1];
            W = 0;
            break;
        }
     }

        return profit;
    }
    static int MinimumABSSum(int A[],int B[]){
        int Sum = 0;
 
         Arrays.sort(A);
         Arrays.sort(B);
         for(int i = 0;i<A.length;i++){
            Sum += Math.abs(A[i]-B[i]);
         }

        return Sum;
    }
    static int Mincoin(int M){
        int Coin = 0;
      int arr[] = {1,2,5,10,20,50,100,500,2000};
        // Arrays.sort(arr);

         for(int i =arr.length-1;i>=0;i--){
                 if(M>=arr[i]){
                    while (M>=arr[i]) {
                        Coin++;
                    System.err.println(arr[i]);
                    M -=arr[i];
                    }
                }
            }

        return Coin;
    }
}
