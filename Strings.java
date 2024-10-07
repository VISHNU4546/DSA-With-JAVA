import java.util.*;

public class Strings {

    public static void stringPrint( String str){
        for(int i = 0;i<str.length();i++){
            System.out.print(str.charAt(i) + " ");
        }
    }
    public static boolean palindrome( String str){
       int s = 0;
       int e = str.length()-1;
       boolean result = true;
       while(s<=e){
        if(str.charAt(s) !=str.charAt(e)){
            result = false;
            break;
            
        }
        else{
            s++;
            e--;
        }
       }
      return result;

    }
    public static void shortestPath(String str){
        int x = 0;
        int y =  0;
        for(int i  = 0;i<str.length();i++){
            if(str.charAt(i) =='W'){
             x--;
            }
            else if(str.charAt(i) =='E'){
             x++;
            }
             else if(str.charAt(i) =='S'){
             y--;
            }
            else{
          y++;
            }
        }
        int path1 = (int) (Math.pow(x, 2) + Math.pow(y, 2));
        int path = (int)Math.sqrt(path1);
        System.out.println(path);
    }
    public static void main(String args[]){

        // String str = "abcd";
        // String str2 = new String("abcd");
        Scanner  sc = new Scanner(System.in);
        String name = sc.nextLine();
        // System.out.println(name);
    //   stringPrint(name);
    // System.out.println(palindrome(name));
    // shortestPath(name);
  //  System.out.println( romanToDecimal(name));
    // upperCase(name);
    isValid(name);
    }



   public static int romanToDecimal(String str) {
    int sum = 0;
  //this is not good ways
    for(int  i=0;i<str.length();i++){
        
        switch(str.charAt(i)){
            case'|':
              sum +=1;
              break;
            
            case'V':
              sum +=5;
              break;
            case'X':
              sum +=10;
              break;  
            case'L':
              sum +=50;
              break;
            case'C':
              sum +=100;
              break;
            case'D':
              sum +=500;
              break;
            case'M':
              sum +=1000;
              break;
              
            default:
            System.out.println(" not ");
            
        }
        
    }
    return sum;
}


public static void upperCase(String S){

StringBuilder sb = new StringBuilder(" ");
  for(int i = 0;i<S.length();i++){
    if(S.charAt(i-1) ==' ' ||i==0){
        
      sb.append( (char) S.charAt(i) + 26); 
    }
    else{
       sb.append( (char) S.charAt(i) );
    }
  }
  System.out.print(sb);
}

public static void isValid(String s) {

  
  for(int i =0;i<s.length();i++){
      int count = 0;
      int n =100;
        System.out.println(s.charAt(i));
         System.out.println(n);
      if(s.charAt(i)=='.'){
          count = 0;
          n = 100;
                  System.out.println(s.charAt(i));
            
      }
      else{
        count+=(int)s.charAt(i);
          System.out.println(s.charAt(i)-'a');
        count = count*n;
      
          n /=10; 
      }
      if(count>=256 ||count<0){
           System.out.println("not IP");
      }
       System.out.println(count);
  }

}
}
