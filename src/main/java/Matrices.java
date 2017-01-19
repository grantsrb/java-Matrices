import java.lang.Math;

public class Matrices{
  public static double[][] multiplyMatrix(double[][] leftMatrix, double[][] rightMatrix) {
    double[][] product = new double[leftMatrix.length][rightMatrix[0].length];
    try{
      for(int rightCol = 0; rightCol < rightMatrix[0].length; rightCol++){
        for(int row = 0; row < leftMatrix.length; row++){
          for(int leftCol = 0; leftCol < leftMatrix[0].length; leftCol++) {
            product[row][rightCol] += leftMatrix[row][leftCol] * rightMatrix[leftCol][rightCol];
          }
        }
      }
      return product;
    } catch(IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static boolean equals(double[][] matrix1, double[][] matrix2) {
    try{
      for(int row = 0; row < matrix1.length; row++){
        for(int col = 0; col < matrix1[0].length; col++) {
          if(Math.abs(matrix1[row][col] - matrix2[row][col]) > 0.00001d){
            return false;
          }
        }
      }
      return true;
    } catch(IndexOutOfBoundsException e) {
      return false;
    }
  }

  public static double[][] add(double[][] leftMatrix, double[][] rightMatrix) {
    double[][] sum = new double[leftMatrix.length][leftMatrix[0].length];
    try{
      for(int row = 0; row < sum.length; row++) {
        for(int col = 0; col < sum[0].length; col++) {
          sum[row][col] = leftMatrix[row][col] + rightMatrix[row][col];
        }
      }
      return sum;
    } catch(IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static double[][] add(double scalar, double[][] matrix) {
    double[][] sum = new double[matrix.length][matrix[0].length];
    for(int row = 0; row < sum.length; row++) {
      for(int col = 0; col < sum[0].length; col++) {
        sum[row][col] = scalar + matrix[row][col];
      }
    }
    return sum;
  }

  public static double[][] multiplyScalar(double scalar, double[][] matrix){
    double[][] product = new double[matrix.length][matrix[0].length];
    for(int row = 0; row < matrix.length; row++) {
      for(int col = 0; col < matrix[0].length; col++) {
        product[row][col] = scalar * matrix[row][col];
      }
    }
    return product;
  }

  public static double[][] multiplyPairwise(double[][] leftMatrix, double[][] rightMatrix) {
    return null;
  }
}
