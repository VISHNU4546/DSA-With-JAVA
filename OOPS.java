public class OOPS{
public static void main(String[] args){
   Queen q1 = new Queen();
   q1.moves();
}

}


class complex{

    int real;
        int img;

    public void sum(int a,int b){
        this.img = this.img + b;
        this.real = this.real +a;
        System.out.println("Sum of complex number is "+ real + "+i"+img);

    }

    public void product(int a,int b){
       int x =  a;
       int y = b;
       
        System.out.println("Sum of complex number is "+ real + "+i"+img);

    }
}
interface  chessplayer{
    void moves();
}

class Queen implements chessplayer{
                  public void moves(){
        System.out.println("Queen");
    }
}
