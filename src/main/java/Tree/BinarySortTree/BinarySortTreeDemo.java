package Tree.BinarySortTree;

/**
 * @Author: Cho
 * @Date: 2022/8/24 16:20
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i: arr){
            binarySortTree.add(new Node(i));
        }

        System.out.println("Infix Order Iterate");
        binarySortTree.infixOrderIterate();
    }
}


class BinarySortTree{
    private Node root;

    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if(root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        nodeDelete(target.value);
        return target.value;
    }

    /**
     * delete node
     * @param value
     */
    public void nodeDelete(int value){
        if(root == null){
            return;
        }else {
            Node targetNode = root.search(value);
            if (targetNode == null){
                return;
            }
            if(root.left == null && root.right == null){
                root = null;
                return;
            }

            Node parentNode = root.searchParent(value);
            if(parentNode == null){
                return;
            }
            if (targetNode.left == null && targetNode.right == null){
                if(parentNode.left != null && parentNode.left.value == value){
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right == null) {
                int minVal =delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                if(targetNode.left != null){
                    if (parentNode.left.value == value){
                        parentNode.left = targetNode.left;
                    }else {
                        parentNode.right = targetNode.left;
                    }
                }else {
                    if(parentNode.left.value == value){
                        parentNode.left = targetNode.right;
                    }else {
                        parentNode.right = targetNode.right;
                    }
                }
            }
        }
    }
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrderIterate(){
        if(root != null){
            root.infixOrderIterate();
        }else {
            System.out.println("This binary sort tree is empty now");
        }
    }
}
class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if(node == null){
            return;
        }
        if (node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
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

    public Node search(int value){
        if(value == this.value){
            return this;
        } else if (value < this.value) {
            if(this.left == null) {
                return null;
            }
            return this.left.search(value);
        }else {
            if(this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value){
        if((this.left != null && this.left.value == value) || 
                (this.right != null && this.right.value == value)){
            return this;
        }else {
            if(value<this.value && this.left != null){
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
}
