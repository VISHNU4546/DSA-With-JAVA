import java.util.ArrayList;
import java.util.Arrays;


public class BST {
    
static class Node{
    int data;
    Node left,right;
      Node(int data){
        this.data = data;
        left = right = null;
    }

 
} 
 public static  Node buildBST(Node root,int data){
  if(root==null){
    root= new Node(data);
    return root;
  }
   if(root.data>data){
     root.left =  buildBST(root.left, data);
   }
   if(root.data<data){
   root.right =   buildBST(root.right, data);
   }
   return root;
}
 public static void printBST(Node root){
    if (root==null) {
        return;
    }
     
    // System.out.print(root.data +"->");
   printBST(root.left);
   System.out.print(root.data +"->");
    printBST(root.right);
    // System.out.print(root.data +"->");
    
}

public static Boolean Search(Node root,int data){
    if(root==null){
        return false;
    }
     if (root.data==data) {
        return true;
     }
    if(root.data>data){
       return Search(root.left, data);
    }
    else{
      return Search(root.right, data);
    }
  
    
}
public static void printInRange(Node root,int r1,int r2){
  if(root==null) return;

  if(root.data>=r1 && root.data<=r2){
      
       printInRange(root.left, r1, r2);
        System.out.print(root.data + " ");
       printInRange(root.right, r1, r2);
  }
  else if(root.data<r1){
   printInRange(root.right, r1, r2);

  }
  else{
    printInRange(root.left, r1, r2);
  }
}
 public static Node Delete(Node root,int data){
   if (root ==null) {
    return null;
   }

    if(root.data>data){
       root.left= Delete(root.left, data);
    }
    else if (root.data<data) {
       root.right= Delete(root.right, data);
    }
     else{
    // Case 1
    if(root.left==null && root.right==null){
        
        return null;
    } 
    else if(root.right==null){
        return root.left;
        
    }
     else if(root.left ==null ){
            return   root.right;
        
    }
    else{
        Node succussor = InorderSuccessor(root.right);
        root.data = succussor.data;
      root.right =   Delete(root.right, succussor.data);
        
    }
 

  }
  return root;
    
}

public static void rootToLeaf(Node root,ArrayList<Integer>q){
 if(root ==null){
  return;
 }
  q.add(root.data);
  if(root.left==null && root.right==null){
    System.out.println(q);
  }

  rootToLeaf(root.left, q);
   rootToLeaf(root.right, q);
   q.remove(q.size()-1);
}

public static Node InorderSuccessor(Node root){
    
    while (root.left !=null) {
        root = root.left;
    }
    return root;
}
public static Node inorderPredeccesor(Node root){
    
    while (root.right !=null) {
        root = root.right;
    }
    return root;
}


public static Boolean validBst(Node root){
  if(root ==null) return true;

  if(root.left==null && root.right==null)return true;
   if(root.left==null)return validBst(root.right);
   if(root.right==null)return validBst(root.left);
  if(root.data >inorderPredeccesor(root.left).data && root.data<InorderSuccessor(root.right).data){
    return validBst(root.left)&&validBst(root.right);
  }
  return false;
}

public static Node mirrorBST(Node root){
  if(root==null)return null;

  Node left = mirrorBST(root.left);
  Node right = mirrorBST(root.right);

  root.left = right;
  root.right = left;
  return root;
}

public static Node arrayToBalanceBST(int arr[],int low,int high){
   if(low>high) return null;
int mid = low +(high-low)/2;
 Node root = new Node(arr[mid]);
 root.left = arrayToBalanceBST(arr, low,mid-1);
 root.right = arrayToBalanceBST(arr, mid+1, high);
 return root;
}
    public static  void main(String args[]){
        // System.out.println("hello");

       int values[] = {8,5,3,6,10,11};
       Node root = null;

      //  for(int i=0;i<values.length;i++){
      //   root = buildBST(root, values[i]);
      //  }
         
    //    printBST(root);
    
    // if(Search(root, 9)){
    //   System.out.println("Item find");
    // }
    // else{
    //     System.out.println("Not found");
    // }
//  printBST(root);
 System.out.println();
    //  root =   Delete(root, 7);
      // printBST(root);
      // System.out.print("Printing range ->" );
      //  printInRange(root, 5, 12);
    System.out.println();
      
      //  rootToLeaf(root,new ArrayList<>());
      // System.out.println(validBst(root));
      // root = mirrorBST(root);
      Arrays.sort(values);
      root = arrayToBalanceBST(values, 0, values.length-1);
      printBST(root);

    }
}
