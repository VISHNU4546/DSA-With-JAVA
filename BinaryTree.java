import java.util.*;;
public class BinaryTree {
    
  static class Node{
       
       int data;
       Node left;
       Node right;
     
       Node(int d){
        data =d;
        left = right = null;
       }
    }

    static public class BinaryTrees {
      static int idx = -1;
       public static Node buildTree(int Node[]){
        idx++;
          if(Node[idx]==-1){
            return null;
          }
          Node newNode = new Node(Node[idx]);
          newNode.left = buildTree(Node);
          newNode.right = buildTree(Node);
             
            return newNode;
        }
      
        public static void printPreOrder(Node root){
                
            if(root==null){
             
                return;}
            System.err.print(root.data +" ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        
        }
     public static void printPostOrder(Node root){
                
            if(root==null){
             
                return;}

                 
                 printPostOrder(root.left);
                 printPostOrder(root.right);
            System.err.print(root.data +" ");
           
           
        
        }

        public static void levelOrder(Node root){
     
          Queue<Node>ans = new LinkedList<>();
          
           ans.add(root);
           ans.add(null);
              int count = 0;
           while (!ans.isEmpty()) {

            Node currNode =  ans.remove();
            if(currNode==null){
              System.out.println();
              if(ans.isEmpty()){
                break;
              }
              else{
                ans.add(null);
                count++;
              }
            }
              else{
                
            
              System.out.print(currNode.data + " ");
            
           if(currNode.left != null) {ans.add(currNode.left);}
             if(currNode.right != null) {ans.add(currNode.right);}
            
              }
           }

          
        }
        public static int height(Node root){
                   if(root==null){return 0;}

                   return Math.max(height(root.left),height(root.right)) +1;
        }
        public static int nodeSum(Node root){
                   if(root ==null){return 0;}

                   return root.data +nodeSum(root.left) + nodeSum(root.right);
        }
        // public static int Diameter(Node root){
        //            if(root ==null) return 0;
        //            int D1 = height(root.left) + height(root.right) +1;
        //            int leftDiameter = Diameter(root.left);
        //            int rightDiameter =Diameter(root.right);

        //           //  int subTreeMaxDiameter = Math.max(leftDiameter,rightDiameter);
        //            return Math.max(D1, Math.max(leftDiameter,rightDiameter));
        // }

      public static class Info{
        int diam;
        int ht;
             public Info(int diam,int ht){
              this.diam = diam;
               this.ht = ht;
            } 
      }
         public static Info Diameter2(Node root){
              if(root ==null) {return new Info(0, 0);}
                Info leftInfo = Diameter2(root.left);
               Info rightInfo = Diameter2(root.right);

               int d =Math.max( Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht +1);
               int ht = Math.max(leftInfo.ht,rightInfo.ht) +1;
               Info ans = new Info(d, ht);
               return  ans;
        }

       static boolean isIdentical(Node root, Node subRoot){
        if(root == null && subRoot == null) return true;
         if(root == null || subRoot == null || root.data !=subRoot.data) return false;
          
         if(! isIdentical(root.left, subRoot.left)) return false;
          if(! isIdentical(root.right, subRoot.right)) return false;

          return true;
       }
        public static boolean isSubTree(Node root,Node subRoot){

          if(root.data == subRoot.data)
          if(isIdentical(root,subRoot)){
            return true;
          }

          return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }
    
    }
       public static class  INFO{
       
        Node node;
        int hd;
        public INFO(Node r,int h){
          this.node = r;
          this.hd = h;
        }
        
       }
       public static void topView(Node root){
       
        Queue<INFO> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        q.add(new INFO(root, 0));
        q.add(null);
        int min  = 0;int max = 0;
        
        while(!q.isEmpty()){
          INFO curr = q.remove();
          if(curr == null){
            if(q.isEmpty()){
              break;
            }
            else{
              q.add(null);
            }
          }

          else{
            if(!map.containsKey(curr.hd)){
            map.put(curr.hd, curr.node);
          }

          if(curr.node.left !=null ){
            q.add(new INFO(curr.node.left,curr.hd-1));
            min = Math.min(min,curr.hd-1);
          }
           if(curr.node.right !=null ){
            q.add(new INFO(curr.node.right,curr.hd+1));
            max = Math.max(max,curr.hd+1);
          } 
          }
        }
         System.out.print("Top view of tree is -> ");
        for(int i = min;i<=max;i++){
          System.out.print(map.get(i).data +" ");
        }
        System.out.println();

       }
       

    public static void main(String args[]){
   int Node[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
     
    BinaryTrees obj = new BinaryTrees();
     Node root = obj.buildTree(Node);
          //  obj.printPreOrder(root);
          // obj.printInOrder(root);
          // obj.printPostOrder(root);
          // obj.levelOrder(root);
        // System.out.println("height is "+ obj.height(root));
        //  System.out.println("Sum of node is "+ obj.nodeSum(root));
        //  System.out.println("Diameter  of tree is "+ obj.Diameter(root));
        //  System.out.println("Diameter  of tree is "+ obj.Diameter2(root).diam);

         Node node = new Node(1);
         node.left= new Node(2);
         node.left.left= new Node(4);
         node.left.right= new Node(5);
         node.right = new Node(3);
         node.right.left = new Node(6);
         node.right.right = new Node(7);
        //  topView(node);
     
    }
}
