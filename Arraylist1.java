import java.util.ArrayList;
// import java.util.*;
public class Arraylist1 {
    

    public static  void main(String args[]){
//     ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
       

//         Scanner sc = new Scanner(System.in);

//         int m =2;
//         for(int i =0 ;i<m;i++){
//  ArrayList<Integer> list = new ArrayList<>();
//  for(int j =0;j<m;j++){
//       int A = sc.nextInt();
//       list.add(A);
//  }
//    mainList.add(list);
//         }

//              for(int i =0 ;i<mainList.size();i++){
//        ArrayList<Integer> curr =  mainList.get(i);
// //  for(int j =0;j<m;j++){
// //       System.out.print(curr.get(j)+" ");
      
      
// //  }
//  System.out.println(curr);
 
   
//         }
     //    sc.close();

     ArrayList<Integer> list = new ArrayList<>();
// height.add(1);
// height.add(8);
// height.add(6);
// height.add(2);
// height.add(5);
// height.add(4);
// height.add(8);
// height.add(3);
// height.add(7);

list.add(1);
list.add(2);
list.add(3);
list.add(4);
list.add(5);
list.add(6);



// System.out.print(containerWithMostWater(height));
System.out.println(pairSum(list, 5));


    }

    public  static int containerWithMostWater(ArrayList<Integer> list){
    int currArea =0;
    int s = 0;
    int e =list.size()-1;
  int maxArea = 0;
    while(s<=e){
  currArea = Math.min(list.get(s),list.get(e))*(e-s);
    
  maxArea  = Math.max(currArea, maxArea);

  if(list.get(s)<list.get(e)){
     s++;
  }
  else{
     e--;
  }
    }



    return maxArea;
    }

    public static  ArrayList<ArrayList<Integer>>pairSum(ArrayList<Integer> list,int target){

     int low  = 0;
     int high =  list.size()-1;
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

      while(low<high){
          ArrayList<Integer> temp = new ArrayList<>();
          int sum = list.get(low)+list.get(high);

          if(sum==target){
               temp.add(low++);
               temp.add(high--);

          }
          else if(sum>target){
               high--;
          }
          else{
               low++;
          }
          if(temp.size()==2){
               ans.add(temp);
               System.out.println(temp);
          }
      }


      return ans;
    }
}
