import java.util.*;
public class Queues {

//     public static class Node{
//         int data;
//         Node next;
//         Node(int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//     public  Node front =null;
//    public      Node rear = null;
//     public  boolean isEmpty(){
//         if(front==null){
//             // System.out.println("Queue is Empty");
//             return true;
            
//         }
//         return false;
//     }
//     public void addEle(int data){
//         Node newNode = new Node(data);
//         if(isEmpty()){
//             front = rear = newNode;
//             return;
//         }
//         rear.next =newNode;
//         rear = newNode;
//     }

//     public  int deleteEle(){
//         if(isEmpty()){
//        System.out.println("Queue is Empty");
//         return Integer.MIN_VALUE;
//         }
//      int data = front.data;
//      if(front ==rear){
//         front = rear = null;
//      }
//      else{
//      front = front.next;
//      }
//      return data;
//     }
//     public void printQueue(){
//         if(front==null){
//             System.out.println("Queue is Empty");
//             return;
//         }
//         Node curr = front;
//         while(curr!=null){
//             System.out.print(curr.data +" ");
//             curr =curr.next;
            
//         }
//         System.out.println();
        
//     }
  
static void max_of_subarrays(int arr[], int n, int k)
{
 PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
 int i;
 for(i=0;i<k;i++){
     queue.add(arr[i]);
 }
 ArrayList<Integer>ans = new ArrayList<>();
 ans.add(queue.peek());
  System.out.println(queue.peek());
 queue.remove(arr[0]);
 
 for(;i<n;i++){
     queue.add(arr[i]);
        ans.add(queue.peek());
          System.out.println(queue.peek());
      queue.remove(arr[i-k+1]);
 }

 
 
}
    public static void main(String args[]){
      
        Queues q1 = new Queues();
        // q1.front = new Node(1);
    //     q1.addEle(1);
    //     q1.addEle(2);
    //     q1.addEle(3);
    //     q1.addEle(4);
    //     q1.addEle(5);
    //     q1.printQueue();
    //     System.out.println(q1.deleteEle());
    //      System.out.println(q1.deleteEle());
    //  q1.printQueue();
    //     System.out.println(q1.front.data + " "+ q1.rear.data);
        
int arrp[] ={ 1 ,2 ,3 ,1, 4 ,5 ,2 ,3 ,6};
max_of_subarrays(arrp, 9, 3);
    
    } 
    
}
