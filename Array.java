import java.util.*;
public class Array {
   /*  public static void Binary_Search(int arr[],int key){
   int s = 0;
   int e = 5;
   
   while(s<=e){
    int m = (s+e)/2;
     if(arr[m]==key){
         System.out.println(m);
         return;
     }
      if(arr[m]>key){
        e = m-1;
     }
     else{
        s = m+1;
     }
   }
   System.out.println("-1");
    }*/

    public static void subArray_Sum(int n[]){
     // by prefix sum  array


      int Sum = Integer.MIN_VALUE;
      int prefix[] = new int[n.length];
      int curr_sum = 0;


      //prefix sum array
      prefix[0] = n[0];
      for(int i =1;i<prefix.length;i++){
        prefix[i] = prefix[i-1] + n[i];
      }

      for(int i = 0;i<n.length;i++){
        int start = i;
        for(int j=i;j<n.length;j++){
         int end = j;
         curr_sum = start ==0 ? prefix[end] :prefix[end] - prefix[start-1];
        if(Sum<curr_sum){
    Sum =  curr_sum;  
  }}
         
        }
          System.out.println(Sum);
      }

    

    public static void subArray(int n[]){
     
      for(int i = 0;i<n.length;i++){
        int start = i;
        for(int j=i;j<n.length;j++){
         int End = j;
      
          for(int k = start;k<=End;k++){
             System.out.print(n[k] + " ");
          }
         System.out.println();
         
        }
        
      }
      System.out.println();
      System.out.println();
    }


    public static void kadane(int N[]){
      int max_sum = Integer.MIN_VALUE;
     int curr_sum = 0;
     for(int  i  =0;i<N.length;i++){
      curr_sum += N[i];
      if(curr_sum<0){
        curr_sum =0;
      } 
      max_sum = Math.max(curr_sum,max_sum);
     }
 System.out.print( "max sum is = "+ max_sum);
    }
    public static void trappingWater(int N[]){
      if(N.length<=2){
        System.out.print("No water will be trap ");
        return;
      }
      int currBound;
      int leftBound [] = new int[N.length];
      int rightBound[] = new int[N.length];
      leftBound[0] = N[0];
      // rightBound[N.length-1] = N[N.length-1];

      for(int i = 1;i<leftBound.length;i++){
            currBound = N[i];

            leftBound[i] = Math.max(currBound,leftBound[i-1]);
      }

      //right boundry Array
         rightBound[N.length-1] = N[N.length-1];
         for(int i = rightBound.length-2;i>=0;i--){
            currBound = N[i];
            rightBound[i] = Math.max(currBound,rightBound[i+1]);
      }
  // for(int i = 0;i<rightBound.length;i++ ){
  //   System.out.print(rightBound[i] + " ");
  // }
int totalWater = 0;
  for(int i = 0;i<N.length-1;i++){
        int leftPoint = leftBound[i];
        int rightpoint = rightBound[i];
        int waterLavel = Math.min(leftPoint,rightpoint);
        int trapWater = waterLavel - N[i];
     
        if(trapWater<0){
          trapWater = 0;
        }
        totalWater +=trapWater;
  }
  System.out.println("water Trap is " + totalWater);
    }



   

    public static void main(String args[]){
    
        // int arr[] = new int[5];
        // System.out.println("-1");
      // Binary_Search(arr,4);
      //  subArray(arr);
      //subArray_Sum(arr);
     // kadane(arr);
      // trappingWater(arr);
        //  Profit(arr);
  
int arr[] ={-1,1,0,-3,3};

// majorityElement(arr, 5);
// missingNumber(arr, 5);
// maxProduct(arr, 5);      



// findLongestConseqSubseq(arr, 12);
int ans[] = new int[4];
  ans = productExceptSelf(arr);
   System.out.print(Arrays.toString(ans));
}

    public static int[] productExceptSelf(int[] nums) {
        
      int ans[] =  new int [nums.length];
  int maxPro = 1;
  int count = 0;
  int index = -1;
      for(int  i = 0;i<nums.length;i++){
         if(nums[i]==0){
          count++;
          if(count==1){
              index = i;
          }
          
         }
  else {
      maxPro *=nums[i];
  }
      }


      if(count==1){
        ans[index] =maxPro;
        return ans;
      }
for(int i = 0;i<nums.length;i++){
  ans[i] = (maxPro/nums[i]);
}

      return ans;
  }

    static void findLongestConseqSubseq(int arr[], int N)
    {
       // add your code here
       int count = 1;
       int maxCount = Integer.MIN_VALUE;
       Arrays.sort(arr);
       for(int i = 0;i<N-1;i++){
           if(arr[i] ==arr[i+1]-1){
               count++;
           }
           else{
            System.out.print(count+" ");
            
               maxCount = Math.max(count,maxCount);
            System.out.print(maxCount);
               count = 1;
               System.out.println();
           }
       }
      //  return maxCount;
    }

 //best time to sell Stock
    public static void Profit(int N[]){

      int buyPrice  = Integer.MAX_VALUE;
      int Profit = 0;
      // int buyPrice = N[0]; 
      for(int i = 0;i<N.length;i++){
        if(buyPrice < N[i]){
          int currProfit = N[i] - buyPrice;
          Profit =  Math.max(Profit,currProfit);
        }
        else{
          buyPrice = N[i] ;
        }
      }
       System.out.println(" profit is " + Profit);
    }


  public  static void majorityElement(int a[], int size)
    {
        int maxCount = 0;
        int maxEle =-1;
        int currCount = 1;
        Arrays.sort(a);
        int i;
        for( i =0;i<size-1;i++){
            if(a[i]==a[i+1]){
                currCount++;
            }
            else{
               maxCount = Math.max(currCount,maxCount);
               maxEle = a[i];
               currCount = 1;
               System.out.println("hello "+maxCount + maxEle);
            }
        }
        if(i==size-1){
          maxCount = currCount;
          maxEle = a[i];
        }
        
        
        if(maxCount>(size/2)){
          System.out.println( " hello"+maxCount + maxEle );
        }
        else{
          System.out.println(-1);
        }
    }


    static void missingNumber(int arr[], int size)
    {
       Arrays.sort(arr);
       
       int i = 0;
       while(arr[i]<=0){
           i++;
          //  System.out.println(i);
       }
       int j;
       for(j = i;j<size-1;j++){
           if(arr[j]+1 !=arr[j+1]){
                 System.out.println("element->"+arr[j]+1);
           }
       }
       System.out.println("element"+arr[size-1]+1);
    }

    static void maxProduct(int[] arr, int n) {
      long curr  =1;
      long max = Integer.MIN_VALUE;
      
      for(int i =0;i<n;i++){
          curr *=arr[i];
          max = Math.max(max,curr);
          if(curr<=0){
            curr = 1;
        }
               System.out.println(" max is " + max +" curr "+curr);
      }

   }

  
}
