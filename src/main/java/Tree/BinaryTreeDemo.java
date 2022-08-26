package Tree;


/**
 * @Author: Cho
 * @Date: 2022/8/21 14:51
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        NameNode root = new NameNode("cho",1);
        NameNode node2 = new NameNode("owen",2);
        NameNode node3 = new NameNode("jason",3);
        NameNode node4 = new NameNode("richard",4);

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        binaryTree.postOrderIterate();
        System.out.println("--------------------------------------------");
        binaryTree.binaryTreeDelete(node4.getNo());

        binaryTree.postOrderIterate();

        //System.out.println("previous order traversal");
        //binaryTree.postOrderIterate();

        /*NameNode resNode = binaryTree.preOrderSearch(4);
        if (resNode != null){
            System.out.printf("we find the information, no = %d name = %s",resNode.getNo(),resNode.getName());
        }else {
            System.out.printf("cannot find the information that no is %d",4);
        }

         */
    }
}

class BinaryTree{
    private NameNode root;

    public void setRoot(NameNode root) {
        this.root = root;
    }

    // previous order function
    public void preOrderIterate(){
        if(this.root != null){
            this.root.preOrderIterate();
        }else {
            System.out.println("current binary tree is empty");
        }
    }

    public void infixOrderIterate(){
        if(this.root != null){
            this.root.infixOrderIterate();
        }else {
            System.out.println("current binary tree is empty");
        }
    }

    public void postOrderIterate(){
        if(this.root != null){
            this.root.postOrderIterate();
        }else {
            System.out.println("current binary tree is empty");
        }
    }

    // pre order iterate
    public NameNode preOrderSearch(int no){
        if (root != null){
           return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public NameNode infixOrderSearch(int no){
        if (root != null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public NameNode postOrderSearch(int no){
        if (root != null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }

    public void binaryTreeDelete(int no){
        if(root != null){
            if (root.getNo() == no){
                root = null;
            }else {
                root.binaryTreeDelete(no);
            }
        }else {
            System.out.println("This is a empty tree");
        }
    }
}
class NameNode{
    private String name;
    private int no;
    private NameNode left;
    private NameNode right;

    public NameNode(String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public NameNode getLeft() {
        return left;
    }

    public void setLeft(NameNode left) {
        this.left = left;
    }

    public NameNode getRight() {
        return right;
    }

    public void setRight(NameNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NameNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    // pre order traversal
    public void preOrderIterate(){
        System.out.println(this);// print out the current node
        if(this.left != null){
            this.left.preOrderIterate();
        }
        if(this.right != null){
            this.right.preOrderIterate();
        }
    }

    public void infixOrderIterate(){
        if(this.left != null){
            this.left.infixOrderIterate();
        }
        System.out.println(this);

        if (this.right != null){
            this.right.infixOrderIterate();
        }
    }

    public void postOrderIterate(){
        if(this.left != null){
            this.left.postOrderIterate();
        }
        if (this.right != null){
            this.right.postOrderIterate();
        }
        System.out.println(this);
    }



    /***
     *
     * @param no
     * @return if find return node else null
     */
    public NameNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }
        NameNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public NameNode infixOrderSearch(int no){
        NameNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public NameNode postOrderSearch(int no){
        NameNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return  resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return null;
    }


    public void binaryTreeDelete(int id){
        if(this.left != null && this.left.no == id  ){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == id){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.binaryTreeDelete(id);
        }
        if (this.right != null){
            this.right.binaryTreeDelete(id);
        }
    }
}


