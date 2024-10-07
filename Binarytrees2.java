import java.util.ArrayList;
import java.util.Collections;

public class Binarytrees2 {
    static class Node{
       
        int data;
        Node left;
        Node right;
      
        Node(int d){
         data =d;
         left = right = null;
        }
    }
     
     static int level = 1;
     public static void kthLevel(Node root,int lvl){
        if(root ==null) return ;
        
        if(level == lvl){
            System.out.print(root.data + " ");
            return;
        }
        level++;
        kthLevel(root.left, lvl);
        kthLevel(root.right, lvl);
        level--;
     }
     static boolean path(int n,ArrayList<Node> a,Node root){
         if(root==null) return false;
         a.add(root);

         if(root.data==n) return true;
         boolean leftPath = path(n, a, root.left);
         boolean rightPath = path(n, a, root.right);

         if(leftPath|| rightPath){
            return true;
         }
         a.remove(a.size()-1);
         return false; 
     }
     
      public static void lowestCommanAncestor(int n1,int n2,Node root){
          ArrayList<Node> path1 = new ArrayList<>();
          ArrayList<Node> path2 = new ArrayList<>();
         path(n1,path1,root);
         path(n2,path2,root);


         int i = 0;
         for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i).data !=path2.get(i).data){
                break;
            }
         }
         System.out.println();
         System.out.println("Lowest Comman ancestor is "+ path1.get(i-1).data);
          
           ArrayList<Node> path3 = new ArrayList<>();
          ArrayList<Node> path4 = new ArrayList<>();
         
          path(n1, path4, path1.get(i-1));
          path(n2, path3, path1.get(i-1));
          System.out.println("minimum distance is " + (path3.size()-1+path4.size()-1));
      }
      public static Node sumTree(Node root){
        if(root ==null) return null;
         int sum1 = 0;
         int sum2 = 0;
        if(root.left !=null){
             sum1 = sumTree(root.left).data;
        }
       if(root.right !=null){
        sum2 = sumTree(root.right).data;
       }
      root.data = sum1+sum2 +root.data;
      return root;
      }
 
      static void preOrder(Node root,  ArrayList<Integer>ans){
        if(root==null) return;
        ans.add(root.data);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }
    // Return the Kth smallest element in the given BST
    public static int KthSmallestElement(Node root, int K) {
        ArrayList<Integer>ans = new ArrayList<>();
        preOrder(root,ans);
        
        Collections.sort(ans);
        return ans.get(K-1);
    }
  static  boolean Help(Node root,int node,ArrayList<Integer> ans){
        if(root==null) return false;
        if(root.data ==node){
            return true;
        }
        if(Help(root.left,node,ans)||Help(root.right,node,ans)){
            ans.add(root.data);
        }
        return false;
    }
    public static int kthAncestor(Node root, int k, int node)
    {
    
    ArrayList<Integer> ans =new ArrayList<>();
   if( Help(root,node,ans)){
       ans.add(root.data);
   }
//    if(ans.size()>0){
//        return ans.get((ans.size())-k+1);
//    }
   for (int i = 0;i<ans.size();i++) {
    System.out.println(ans.get(i));
   }
   return -1;
   
    }
    public static int transform(Node root){
        if(root ==null) return 0;

        int left = transform(root.left);
        int right = transform(root.right);
        int data= root.data;

        int newLeft = root.left ==null?0:root.left.data;
        int newright = root.right ==null?0:root.right.data;

        root.data = newLeft + left + newright + right;
        return data;
       }
       
       public static void printPreOrder(Node root){
                 
        if(root==null){
         
            return;}
        System.err.print(root.data +" ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    
    }

     public static void main(String args[]){

        Node node = new Node(1);
         node.left= new Node(2);
         node.left.left= new Node(4);
         node.left.right= new Node(5);
         node.right = new Node(3);
         node.right.left = new Node(6);
         node.right.right = new Node(7);
        //  topView(node);
        // kthLevel(node, 2);
        // lowestCommanAncestor(5, 6, node);
//         // int arr [] = {2,3,3,2};
//     // System.out.println(sumTree(node).data);
//     System.out.println(KthSmallestElement(node,6));

// System.out.println(kthAncestor(node, 1, 6));
transform(node);
printPreOrder(node);
    }
}
