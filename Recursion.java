public class Recursion {


    public static int print(int n){
    
        if(n==1){
            //   System.out.println(n);
            return 1;
        }
        int sum = n + print(n-1);
        System.out.println(sum);
        return sum;
 
    }
    public static boolean isSort(int arr[],int n){
        
        if(n==arr.length-1){
            return true;
        }
        if(arr[n]>arr[n+1]){
            return false;
        }
        

      return isSort(arr, n+1);
    }
    public static int firstOcuur(int arr[],int n,int k){
        
        if(n==arr.length){
            return -1;
        }
        if(arr[n]==k){
            return n+1;
        }
        

      return firstOcuur(arr, n+1,k);
    }

    public static int power(int n,int pow){

        if(pow ==1){
            return n;
        }
        return n*power(n, pow-1);
    }
    public static int tiling(int N){
   if(N==0||N==1){
    return 1;
   }
   
//    int horizontal = tiling(N-2);
//    int vartical = tiling(N-1);

  return tiling(N-1)+tiling(N-2);

    }

    public static void removeDuplicate(String s,boolean map[],StringBuilder R,int index){
   
        if(index==s.length()){
               System.out.println(R);
            return;
        }
        char curr = s.charAt(index);
   int i = curr-'a';
        if(map[i]!=true){
            R.append(s.charAt(index));
            map[i]=true;
             removeDuplicate(s, map, R, index+1);
        }
        else{
       removeDuplicate(s, map, R, index+1);
        }
       

    }
     static int friendsPairing(int N){
        if(N==1 ||N==2){
            return N;
        }

        int single = friendsPairing(N-1);
        int pair =(N-1)* friendsPairing(N-2);

        return single+pair;
     }

     public static void binaryString(int n,int lastplace,String str){
        if(n==0){
               System.out.println(str);
               return;
        }

        // if(lastplace==0){
        //     binaryString(n-1,0, str.append("0"));
        //     binaryString(n-1,1, str.append("1"));
        // }
        // else{
        //     binaryString(n-1,0, str.append("0"));
        // }

         binaryString(n-1,0, str+"0");
         if(lastplace==0){
         binaryString(n-1,1, str+"1");
        }

     }
    public static void main(String  args[]){
        // int arr[] ={1,3,4,8,7};
        
        // System.out.println(print(10));
        // System.out.println(isSort(arr, 0));
        //     System.out.println(firstOcuur(arr, 0,7));
    //   System.out.println(power(7, 3));
    //    System.out.println((int)Math.pow(7, 3));
    
    //  System.out.println(tiling(10));
    // boolean map[]  =new boolean[26];
    // StringBuilder ans = new StringBuilder("");
    // String s = "appnnacollege";
    
    // removeDuplicate(s, map, ans, 0);
    // System.out.println(ans);

    //    System.out.println(friendsPairing(3));
    binaryString(3, 1, "");
        }
    
}
