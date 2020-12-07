package lesson_h;

public class Main {
    public static int[][] matrix;

    public static void main(String[] args) {
        createMatrix(4, 7);
    }

    public static void createMatrix(int x, int y) {
        int dx = 0;
        int dy = 0;
        int offsetX = 1;
        int offsetY = 0;
        matrix = new int[x][y];

        for (int i = 1; i <= x * y; i++) {
            matrix[dx][dy] = i;
            if(dx == matrix.length - 1 - offsetY && dy == matrix[0].length - 1 - offsetY)offsetX++;
            // право и вниз
            if(offsetX % 2 !=0){
                if(dy < matrix[0].length - 1 - offsetY)++dy;
                else if(dy == matrix[0].length - 1 - offsetY)++dx;
            }
            // влево и вверх
            if(offsetX % 2 == 0){
                if(dx == matrix.length - 1 - offsetY && dy != offsetY)dy--;
                else if(dy == offsetY)--dx;
            }
            if(dx == offsetX -1 && dy == offsetY){
                offsetX++;
                offsetY++;
            }
        }
        for(int xTest = 0; xTest < matrix.length; xTest++){
            for(int yTest = 0; yTest <matrix[xTest].length; yTest++){
                System.out.print(matrix[xTest][yTest]);
                System.out.print('|');
            }
            System.out.println('\n');
        }

    }
}
