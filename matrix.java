import java.util.Scanner;

public class matrix {

public static void matrix(){
  System.out.println("Enter the size of matrix");
  Scanner sc = new Scanner(System.in);
  int M = sc.nextInt();
  int N = sc.nextInt();

  int matrix[][] = new int[M][N]; 

   System.out.println("Enter the Element of matrix");

   for(int i = 0;i<M;i++){
    for(int j = 0;j<N;j++){
      matrix[i][j] = sc.nextInt();
    }
   }

   //output
  //  for(int i = 0;i<M;i++){
  //   for(int j = 0;j<N;j++){
  //       System.out.print(matrix[i][j] + " ");
      
  //   }
  //   System.out.println();
  //  }
  //   System.out.println();
   //Border
   
   /*int i = 0;
   int j = N;
   for(i=0;i<N;i++){
    System.out.print(matrix[0][i] + " ");
   }
   for(j = 1;j<M;j++){
    System.out.print(matrix[j][N-1] + " ");
   }

   for(i = M-2;i>=0;i--){
        System.out.print(matrix[M-1][i] + " ");
   }
for(j = N-2;j>0;j--){
        System.out.print(matrix[j][0] + " ");
   }*/


  //  printSpiral(matrix);
//   printDaigonalSum(matrix);
// stairCaseSearch(matrix, 11);
transpose(matrix);
  



}
public static void printSpiral(int matrix[][]){

  int startRow = 0;
  int startCol = 0;
  int endRow = matrix.length-1;
  int endCol = matrix[0].length-1;
  int i,j;
  
  while(startCol<=endCol && startRow<=endRow){
    //top
      for(j=startCol;j<=endCol;j++){
    System.out.print(matrix[startRow][j] + " ");
   }
   //right
   for(i = startRow+1;i<=endRow;i++){
    System.out.print(matrix[i][endCol] + " ");
   }
   //bottom

   for(j = endCol-1;j>=startCol;j--){
    if(startRow == endRow){
      break;
    }
        System.out.print(matrix[endRow][j] + " ");
   }
   //left
for(i = endRow-1;i>=startRow+1;i--){
        if(startCol == endCol){
      break;
    }
        System.out.print(matrix[i][startCol] + " ");
   }
  startCol++;
  startRow++;
  endCol--;
  endRow--;
  }

}
public static void printDaigonalSum(int matrix[][]){

  int i,j;
  int N = matrix[0].length;
  int  M =matrix.length;

  int sum = 0;
//   for( i = 0;i<M;i++){
//     for( j = 0;j<N;j++){
//           if(i == j){
//             System.out.print(matrix[i][j] + " ");
//             sum +=matrix[i][j];
//           }
//           else if(i+j == N-1){
//              System.out.print(matrix[i][j] + " ");
//              sum +=matrix[i][j];
//           }   
//     }
// }


// o(n) time

for( i =0;i<N;i++){
  //primary diagonal
  sum +=matrix[i][i];

  //sec
  if(i != matrix.length-i-1){
    sum +=matrix[i][matrix.length-i-1];
  }
}

System.out.println(sum);
}
public static void stairCaseSearch(int matrix[][],int key){
    int row = 0;int col = matrix.length-1;
    while(row<matrix.length-1 && col>=0){
        if(matrix[row][col] == key){
           System.out.println(" Key found at "+ row + " ,"+col);
        return;
        }
        else if(key<matrix[row][col]){
            col--;
        }
        else{
            row++;
        }
    }
    System.out.println(" Key is not found  ");
}
public static void transpose(int matrix[][]){
    int m = matrix.length;
    int n = matrix[0].length;
    int transpose[][] = new int[m][n];

    for(int i = 0;i<m-1;i++){
      for(int j = 0;j<n-1;j++){
        transpose[j][i] = matrix[i][j];
      }
    }
    for(int i = 0;i<m-1;i++){
    for(int j = 0;j<n-1;j++){
        System.out.print(transpose[i][j] + " ");
      
    }
    System.out.println();
   }
    System.out.println();
    



}

 public static void main(String args[]){

        matrix();
 }}

