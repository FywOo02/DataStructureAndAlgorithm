import org.jetbrains.annotations.NotNull;

public class SparseArray {
    public static void main(String[] args) {
        //create two-dimensional array
        //0: represent no piece
        //1: represent black piece
        //2: represent blue piece
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        //print chessArray
        System.out.println("get the original td array");
        for (int[] row: chessArr1){
            for(int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        SparseArray sparseArray = new SparseArray();
        int[][] newSparseArr = sparseArray.twoDimensionalArrToSparseArr(chessArr1);
        System.out.println();
        System.out.println("get the new sparse array");
        for(int i = 0 ; i < newSparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t",newSparseArr[i][0],newSparseArr[i][1],newSparseArr[i][2]);
            System.out.println();
        }
    }
    public int[][] twoDimensionalArrToSparseArr(@NotNull int arr[][]){
        // 1. iterate td array and get count of not 0 elements
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for (int j=0; j< arr[0].length; j++){
                if(arr[i][j] != 0)
                    sum++;
            }
        }
        // 2. create sparse arr
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;

        // 3. iterate td arr and put value of not 0 elements to sparse arr
        int count = 0;
        for(int i=0; i<arr.length; i++){
            for (int j=0; j< arr[0].length; j++){
                if(arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }
}
