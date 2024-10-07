import java.util.*;
public class stack{

    
    static void  pushAtBottom(Stack<Integer>s,int data){

        if(s.isEmpty()){
            s.push(data);
            return;

        }
        int temp = s.peek();
        s.pop();
          pushAtBottom(s,data);
        s.push(temp);
    }
    
    static void reverseStack(Stack<Integer>s){
        if(s.empty()){
            return;
        }
        int data = s.peek();
        s.pop();
        reverseStack(s);
        pushAtBottom(s,data);
    }
           static void stockSpan(int arr[]){
                  
            ArrayList<Integer>ans = new ArrayList<>();
            Stack<Integer>s = new Stack<>();
            ans.add(1);
            s.push(0);
            for(int i = 1;i<arr.length;i++){
                     while(!s.isEmpty() && arr[i]>arr[s.peek()]){
                        s.pop();}
                        if(s.isEmpty()){
                           ans.add(i+1);
                        }
                       else{ int prevHigh = s.peek();
                        ans.add( i-prevHigh+1);}
                        s.push(i);

                     
            }
            System.out.println(ans);
            
    }
    static void nextGreater(Stack<Integer>s,int arr[]){

       int ans[]  =new int[arr.length];

for(int i= 4;i>=0;i--){
   while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
            
              s.pop();
        }
        if(s.isEmpty()){
            ans[i] = -1;
        }
        else{
        ans[i] =arr[ s.peek()];}
        s.push(i);
    
}

for(int i  =0;i<=ans.length-1;i++){
    System.out.print(ans[i]+ " ");
}
       
    }
    static boolean duplicatePar(String str){
      
 Stack<Character>s = new Stack<>();
 for(int i = 0;i<str.length();i++){
    char ch = str.charAt(i);
    if(ch !=')'){
        s.push(ch);
    }
    else{
        int count = 0;
        while(s.peek() !='('){
              s.pop();
              count++;
        }
        if(count<1){
          return  true;
        }
        s.pop();

    }
    
 }
return false;
    }

    static void  maxHistrogramArea(int arr[],int n){
    
        int nsr[] =new int[n];
        int nsl[] = new int[n]; 
        
        // nsr = nextSmallerRight(arr);
        // nsl = nextSmallerLeft(arr);
        int maxArea =Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int width = (nsr[i]-nsl[i]-1);
            int area = arr[i]*width;
            maxArea = Math.max(maxArea, area);
        }
System.out.println("max area is "+maxArea);


    }
 public static void main(String args[]){
        //   Stack<Integer>s = new Stack<>();

//           s.push(4);
//           s.push(3);
//           s.push(2);
//           pushAtBottom(s,5);
// System.out.println(s);
// reverseStack(s);
// System.out.println(s);
// int arr[] = {2,1,5,6,2,3};
int arr[] = {10,1,1,6};

// stockSpan(arr);
// nextGreater(s, arr);
nextSmallerRight(arr);
// nextSmallerLeft(arr);
// maxHistrogramArea(arr, 2);

// String str = "(((a+(b)))+(c+d))";
// System.out.println(duplicatePar(str));

    }
     static void nextSmallerRight(int arr[]){
Stack<Integer>s = new Stack<>();
       int ans[]  =new int[arr.length];

for(int i= arr.length-1;i>=0;i--){
   while(!s.isEmpty() && arr[i]<s.peek()){
            
              s.pop();
        }
        if(s.isEmpty()){
            ans[i] =-1;
        }
        else{
        ans[i] =s.peek();}
        s.push(arr[i]);
    
}
// return ans;
for(int i =0;i<arr.length;i++){
    if(ans[i]==-1){
        ans[i] = arr[i];
    }
    else{
        ans[i] = arr[i]-ans[i];
    }
}

for(int i  =0;i<=ans.length-1;i++){
    System.out.print(ans[i]+ " ");
}
System.out.println("hello");

     }
    
     static void nextSmallerLeft(int arr[]){
Stack<Integer>s = new Stack<>();
       int ans[]  =new int[arr.length];

for(int i= 0;i<arr.length;i++){
  while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
            
              s.pop();
        }
        if(s.isEmpty()){
            ans[i] = 0;
        }
        else{
        ans[i] =s.peek();}
        s.push(i);
    
}
// return ans;

for(int i  =0;i<=ans.length-1;i++){
    System.out.print(ans[i]+ " ");
}
System.out.println();
     }
}