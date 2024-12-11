import java.util.Scanner;
public class TopLefttoBottomRight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();
        int [][] matrix = new int[R][C];
        int [][] path = new int[R][C];
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                matrix[row][col] = in.nextInt();
                path[row][col] = 0;
            }
        }
        path[0][0] = matrix[0][0];

        for(int col=1;col<C;col++){
            if(matrix[0][col] == 1){
                path[0][col] = path[0][col-1];
            }
        }

        for(int row=1;row<R;row++){
            if(matrix[row][0] == 1){
                path[row][0] = path[row-1][0];
            }
        }

        for(int row=1;row<R;row++){
            for(int col=1;col<C;col++){
                if(matrix[row][col] == 1){
                    path[row][col] = path[row][col-1] + path[row-1][col];
                }

            }
        }

        if(path[R-1][C-1] > 0){
            System.out.print("Yes");
            System.out.print(path[R-1][C-1]);
        }
        else{
            System.out.print("No");
        }


    }
}
