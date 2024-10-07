public class DoubleLL{


      public class Node {
        int data;
        Node next;
        Node prev;
           
        
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev= null;
        }
    }
        public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data){
            Node newNode = new Node(data);

            if(head==null){
                head = tail = newNode;
                size++;
                return;
            }

            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            return ;
        }
        public void addLast(int data){
           Node newNode = new Node(data);

            if(head==null){
                head = tail = newNode;
                size++;
                return;
            }
                size++;
            tail.next = newNode;
            newNode.prev =tail;
            tail = newNode;
        }
        public void deleteFirst(){
            if(head==null){
                return;
            
            }
           
            else if(head.next ==null){
                head = tail= null;
                 size--;
                 return;
            }
            head = head.next;
            head.prev = null;
            size--;

        }
        public void deletelast(){
            if(head==null){
                return;
            
            }
           
            else if(head.next ==null){
                head = tail= null;
                 size--;
                 return;
            }
            tail= tail.prev;
            tail.next = null;
            size--;



        }
        public void print(){
            Node curr = head;

            while(curr !=null){
                System.out.print(curr.data + "<->");
                
                curr = curr.next;
                
            }
            System.out.println("null");
            System.out.println("Head is->"+ head.data);
            System.out.println("tail is->"+ tail.data);
            System.out.println("size is "+size);
            
        }
 
    
    public static void main(String []args){


        DoubleLL dll = new DoubleLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(6);
        dll.addLast(7);

        dll.print();
        // dll.deleteFirst();
        // dll.print();
        dll.deletelast();
         dll.print();
        
    }
   
}