import java.util.*;
public class Backtracking {

    public static void chngeArr(int arr[],int i,int val){
    if(i==arr.length){
    
    return;
    }
    arr[i] = val;
    
    chngeArr(arr, i+1, val+1);
      
    arr[i] -=2; 

    }
    public static void subSet(String str,String ans,int i){

        if(i==str.length()){
            System.out.println(ans);
            return;
        }

        //Yes choice
     subSet(str, ans+str.charAt(i), i+1);

     //No choice
     subSet(str, ans, i+1);
     


    }

    public static void premutations(String str,String ans){
    if(str.length()==0){
          System.out.println(ans);
            return;
    }

    for(int i =0;i<str.length();i++){
        char curr = str.charAt(i);
       String newStr = str.substring(0, i)+str.substring(i+1);
        premutations(newStr, ans+curr);
    }
    
   
   
    }
    public static void print(char Board[][]){
         System.out.println("-------- chess Board ----------");
         for(int i = 0;i<Board.length;i++){
            for(int j = 0;j<Board.length;j++){
             System.out.print(Board[i][j] + " ");
            }
 System.out.println();
        }
        System.out.println();
    }

    public static Boolean isSafe(char Board[][],int row ,int col){
    //Vertical Up
    for(int i = row-1;i>=0;i--){
        if(Board[i][col]=='Q'){
            return false;
        }
    }
    //Daigonal left
    for(int i = row-1,j = col-1;i>=0 &&j>=0;i--,j--){
        if(Board[i][j]=='Q'){
            return false;
        }
    }
     //Daigonal right
    for(int i = row-1,j = col+1;i>=0 &&j<Board.length;i--,j++){
        if(Board[i][j]=='Q'){
            return false;
        }
    }
  
return true;
    }
public static void nQueens(char Board[][],int  row,ArrayList<Integer> ans){
    //Base Case
    if(row==Board.length){
//   print(Board);
ans.add(row);
System.out.println(ans);

// count++;
return ;
    }
   //recursion
  for(int i = 0;i<Board.length;i++){
   if(isSafe(Board,row,i)){
    Board[row][i] = 'Q';
    ans.add(row);
// //    if(nQueens(Board, row+1)){
          nQueens(Board, row+1,ans);
// //     return true;
// //    }
//    else{
//    Board[row][i] = 'x';}
   }
     Board[row][i] = '.';
     
   }
// return false;
    }
// static int  count = 0;

public static int gridWays(int i ,int j,int n,int m){ //Also do with permutation
if(i==n-1&& j==m-1){
    return 1;
}

else if(i==n  || j==m)
{
    return 0;
}    

    int w1 = gridWays(i+1, j, n, m);
    int w2 = gridWays(i, j+1, n, m);
    return w1+w2;
}
public static Boolean isSafe(int sudoku[][],int row,int col,int digit){

    //row check
    for(int i =0;i<9;i++){
        if(sudoku[row][i]==digit){
            return false;
        }
    }
 //col check
  for(int i =0;i<9;i++){
        if(sudoku[i][col]==digit){
            return false;
        }
    }

    //grid check
    int sR = (row/3)*3;
    int sC = (col/3)*3;

    for(int i = sR;i<sR+3;i++){
        for(int j = sC;j<sC+3; j++){
            if(sudoku[i][col]==digit){
            return false;
        }
        }
    }
return true;
}
public static Boolean sudokuSolver(int sudoku[][],int row,int col){
    //base Case
    if(row ==9){
        return true;
    }
int nextRow = row,nxtCol = col+1;
if(nxtCol==9){
    nextRow++;
    nxtCol = 0;
}
if(sudoku[row][col] !=0){
    return sudokuSolver(sudoku, nextRow, nxtCol);

}

      for(int digit = 1;digit<=9;digit++){
        if(isSafe(sudoku,row,col,digit)){
            sudoku[row][col] = digit;
           if( sudokuSolver(sudoku, nextRow, nxtCol)){
            return true;
           }
           else{
             sudoku[nextRow][nxtCol] = 0;
           }
           
        }
       
      }
return false;
}
    public static void main(String args[]){


        //int arr [] = new int [5];
        
        //  chngeArr(arr,0,1);
        
        //  System.out.println( Arrays.toString(arr));

        // String   str = "XYZ";
        // // subSet(str, "", 0);
        // premutations(str,"");
        //    int n  =4;
        // char Board[][] = new char[n][n];

        // for(int i = 0;i<n;i++){
        //     for(int j = 0;j<n;j++){
        //      Board[i][j] = '.';
        //     }
        // }
// System.out.print()
// ArrayList<Integer> ans =new ArrayList<>();
// nQueens(Board,0,ans);



    int n =3,m =3;
    System.out.println("Total grid ways is "+gridWays(0, 0, n, m));

    // int sudoku[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
    // {5, 2, 0, 0, 0, 0, 0, 0, 0},
    // {0, 8, 7, 0, 0, 0, 0, 3, 1},
    // {0, 0, 3, 0, 1, 0, 0, 8, 0},
    // {9, 0, 0, 8, 6, 3, 0, 0, 5},
    // {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
    // {1, 3, 0, 0, 0, 0, 2, 5, 0},
    // {0, 0, 0, 0, 0, 0, 0, 7, 4},
    // {0, 0, 5, 2, 0, 6, 3, 0, 0} };

//  if(sudokuSolver(sudoku, 0, 0)){
//     System.out.print("Sol is exist");
//     // print(sudoku);
//  }
//  else{
//      System.out.print("Sol not exist");
//  }


}
    
}
