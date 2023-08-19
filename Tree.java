

public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Binarytreee{
        static int indx=-1;
        public Node buildtree(int[] nodes){
            indx++;
            if(nodes[indx]==-1){
                return null;
            }
            Node newnode=new Node(nodes[indx]);
            newnode.left=buildtree(nodes);
            newnode.right=buildtree(nodes);
            return newnode;
        }
    }

    public static void main(String[] args) {
        int nodes[]={2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytreee b=new Binarytreee();
        Node root=b.buildtree(nodes);
        System.out.println(root.data);
    }
}
