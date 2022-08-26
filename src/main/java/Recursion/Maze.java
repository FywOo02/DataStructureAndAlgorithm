package Recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        // set the wall
        for(int i=0; i<7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for(int i=0; i<8; i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // set the barrier
        map[3][1] = 1;
        map[3][2] = 1;

        // print the map n
        System.out.println("original map");
        showMap(map);

        setWay(map,1,1);

        System.out.println("After map");
        showMap(map);
    }
    // instruction
    // 1. i,j represents the start point in the ma
    // 2. if the ball arrives map[6][5] successfully, it means we find the right way
    /* 3. Covenant: map[i][j] = 0  Never pass through
                    map[i][j] = 1  Wall
                    map[i][j] = 2  Access successfully
                    mao[i][j] = 3  have passed here but wrong way
     */
    // 4.
    /**
     * recursion method for looking for the way out
     *
     * @param map
     * @param i start point
     * @param j
     * @return if we find the way return true otherwise false
     */
    public static boolean setWay(int map[][], int i, int j){
        if(map[6][5] == 2){
            // find the right way
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i+1,j))
                    return true;
                else if(setWay(map,i,j+1))
                    return true;
                else if(setWay(map,i-1,j))
                    return true;
                else if (setWay(map,i,j-1))
                    return true;
                else {
                    // wrong way
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
    public static void showMap(int map[][]){
        for(int i=0; i<8; i++){
            for(int j=0; j<7; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
