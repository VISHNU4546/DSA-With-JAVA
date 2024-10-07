import java.util.Scanner;

public class bitManipulation {


    
    public static void main(String args[]){
        

        Scanner sc =new Scanner(System.in);
        int num = sc.nextInt();
        int index = sc.nextInt();
          ithBit(num, index);
    }

    public static void ithBit(int num,int i){

        int bitMask = 1<<i;
        if((num & bitMask)==1){
            System.out.print("1");
                
        }
        else{
            System.out.print("0");
        }

    }

    
}
