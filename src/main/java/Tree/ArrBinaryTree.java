package Tree;

/**
 * @Author: Cho
 * @Date: 2022/8/22 20:38
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}

class ArrayBinaryTree{
    private int[] arr; // save the information

    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if(arr == null || arr.length == 0){
            System.out.println("The array is empty ");
        }
        System.out.print(arr[index]);

        if((index*2+1) < arr.length){
            preOrder(2*index+1);
        }
        if ((index*2+2) < arr.length){
            preOrder(2*index+2);
        }
    }
}
