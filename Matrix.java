
public class Matrix {
    public static String matrix_to_text(int[][] a) {
        StringBuffer output = new StringBuffer("");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                output.append(a[i][j] + " ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static int[][] text_to_matrix(String text) {
        String[] rows = text.split("\n");

        int rowCount = rows.length;
        int columnCount = rows[0].split(" ").length;
        int[][] matrix = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            String[] numbers = rows[i].split(" ");
            for (int j = 0; j < columnCount; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }


        return matrix;
    }

    public static int[][] multiplication(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int rows1 = b.length;
        int columns1 = b[0].length;
        int[][] result = new int[rows][columns];

        if(rows == rows1 && columns == columns1){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = a[i][j] * b[i][j];
                }
            }
        }else if(rows == columns1 && columns == rows1){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result[i][j] = a[i][j] * b[j][i];
                }
            }
        }
        return result;
    }

    public static int[][] substract(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result; // сделать исключения
    }

    public static int[][] sum(int[][] a, int[][] b) {
        int rows = a.length;
        int columns = a[0].length;
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result; //сделать исключения
    }
    public static int matrixDeterminant (int[][] matrix) {
        int temporary[][];
        int result = 0;

        if (matrix.length == 2 && matrix[0].length == matrix.length) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new int[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, i) * matrixDeterminant (temporary);
        }
        return (result);
    }

}
