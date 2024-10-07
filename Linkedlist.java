

public class Linkedlist {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Create A node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        //store ref of head
        newNode.next = head;

        //upadate head
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
size++;
        if(head==null){
            head = tail = newNode;
            return;
        }

        tail.next= newNode;
        tail = newNode;

    }
    public void print(Node head){
        // if(head==null){
        //     System.out.print("Linked list is empty");
            
        // }
        Node curr = head;
        while(curr !=null){
            System.out.print(curr.data + "->");
            
            curr = curr.next;
            
        }
        System.out.println("null");
        //    System.out.println(findmiddle(head).data);
        
    }
    public void addEle(int index,int data){
        if(head==null && index !=0){
            System.out.print("Linked list empty");
            
        }
        Node curr  = head;
        int count = 0;
        while(count <index-1){
            curr = curr.next;
            count++;
        }
        Node newNode = new Node(data);
        size++;
        newNode.next = curr.next;
        curr.next = newNode;
    }
    public void removeFirst(){
        if(head==null){
            System.out.print("Linked list empty");
            return;
        }
       head =head.next;
       size--;

    }
    public void removeLast(){
         if(head==null){
            System.out.print("Linked list empty");
            return;
        }

        Node temp = head;
       for(int i = 0;i<size-2;i++){
        temp = temp.next;
       }
        temp.next = null;
        tail =temp;
        size--;
     
    }
    public int search(int key){
        if(head==null){
            return -1;
        }
    Node temp=head;
    for(int i = 0;i<=size-1;i++){
        if(temp.data==key){
            return i+1;
            
        }
        temp = temp.next;
       }
 return -1;

    }
    
    public static int recursiveSearch(int key,Node head){
        if(head==null){
            return -1;
        }
        
        if(head.data==key){
            return 0;
        }
       return 1+recursiveSearch(key, head.next);
  
    }
    public void  reverseLL(Node head){
        if(head==null){
            return;
        }

        Node prev = null;
        Node curr = tail= head ;
        Node Next = curr.next;
        while(curr !=null){
            Next = curr.next;
           curr.next =  prev ;
            prev = curr;
            curr = Next;

        }
        head = prev;
    }
    public int deleteNthNode(int node){
        int index = size -node;

        if(head==null){
            return -1;
        }
        else if(size==1){
            
            int a=  head.data;
            head = null;
            return a;
        }
        Node curr = head;
        for(int i = 0;i<index-1;i++){
               curr = curr.next;
        }
  Node prev  =curr;
   curr = curr.next;
   int ans = curr.data;
   prev.next = curr.next;
   size--;
   return ans;

    }
    public Node findmiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next !=null && fast !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Boolean palindrome(){
        if(head ==null ||head.next ==null){
            return true;
        }
        //step -1 find middle
        Node mid = findmiddle(head);

   //step-2
         Node prev = null;
        Node curr = mid ;
        Node Next = curr.next;
        while(curr !=null){
            Next = curr.next;
           curr.next =  prev ;
            prev = curr;
            curr = Next;

        }
       Node right =prev;
       Node left  = head;
       //step-3
       while(right !=null){
        if(right.data !=left.data){
            return false;
        }
        right = right.next;
        left = left.next;
        
       }
       return true;
    }
    public boolean findCycle(){
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return  true;
            }

        }
        return false;
    }

    public void deleteCycle(){
        Node slow = head;
        Node fast = head;
        // boolean cycle = false;
        while(fast !=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(fast==slow){
                // cycle= true;
                break;
            }
        }

        slow = head;
        Node prev = null;
       while(slow !=fast){
           slow =slow.next;
           prev = fast;
      fast = fast.next;
        }
        prev.next= null;
    }
    public Node getMid(Node Head){
        // if(head ==null ||head.next == null){
        //       return head;
        // }

        Node slow  = Head; 
        Node fast = Head.next;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head){
        if(head==null ||head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next =null;

        Node newLefthead = mergeSort(head);
        Node newRh = mergeSort(rightHead);
        return merge(newLefthead,newRh);
    }

    public Node merge(Node head1,Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while(head1 !=null && head2 !=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 =  head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 !=null){
             temp.next = head1;
                head1 =  head1.next;
                temp = temp.next;
        }
        while(head2 !=null){
             temp.next = head1;
                head1 =  head1.next;
                temp = temp.next;
        }
        return mergedll.next;}
  

        public void zigZag(){
              //find mid
        Node mid = getMid(head);

       Node curr = mid.next;
       mid.next = null;

        //reverse second half
        Node prev = null;
        Node next;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
             prev = curr;
            curr = next;
            
        }
Node right = prev;
Node left = head;
Node nextR,nextL;
              while(right !=null && left !=null){
    nextL=  left.next;
    left.next = right;
    nextR = right.next;

    right.next = nextL;
    
    left = nextL;
    right = nextR;
}
        }
    public static void  main(String args[]){

        Linkedlist ll =new Linkedlist();
        // ll.head = new Node(1);
        // ll.head.next = new Node(3);
       
        // ll.addFirst(2);
        //  ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // // ll.print(head);
        // ll.addEle(2, 4);
        // ll.print(head);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.print(head);
        
        // System.out.print(ll.search(5));
        // System.out.print(recursiveSearch(1,head));
        // ll.reverseLL();
        // ll.print(head);
        
    //    System.out.println( ll.deleteNthNode(2));
    //    ll.print(head);
        // System.out.println(ll.size);
        //  System.out.println( ll.deleteNthNode(1));
        
    //    ll.print(head);
    //      System.out.println("size is "+ll.size);
    //      ll.addLast(6);
    //      ll.print(head);
    //      System.out.println("size is "+ll.size);
    //                       ll.print(head);
    // System.out.print(ll.palindrome());
    

//     head =new Node(1);
    
//     Node temp = new Node(2);
//     head.next =  temp;
//    head.next.next = new Node(3);
//     head.next.next.next = temp;
//     System.out.println(ll.findCycle());
//     ll.deleteCycle();
//       ll.print(head);
//         System.out.println(ll.findCycle());
ll.addFirst(2);

    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);
    ll.addFirst(10);
    ll.print(head);
    // ll.mergeSort(head);
    // ll.print(ll.mergeSort(head));
    ll.zigZag();
    ll.print(head);

    
      
    

    }
    
}
