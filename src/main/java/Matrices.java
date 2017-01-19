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

  public static boolean equals(double[] vector1, double[] vector2) {
    try{
      for(int col = 0; col < vector1.length; col++) {
        if(Math.abs(vector1[col] - vector2[col]) > 0.00001d){
          return false;
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
    double[][] product = new double[leftMatrix.length][leftMatrix[0].length];
    try{
      for(int row = 0; row < leftMatrix.length; row++){
        for(int col = 0; col < leftMatrix[0].length; col++) {
          product[row][col] = leftMatrix[row][col] * rightMatrix[row][col];
        }
      }
      return product;
    } catch(IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static double[][] sum(int dimension, double[][] matrix) {
    double[][] sum;
    if(dimension == 0) {
      sum = new double[1][1];
      for(int row = 0; row < matrix.length; row++) {
        for(int col = 0; col < matrix.length; col++) {
          sum[0][0] += matrix[row][col];
        }
      }
    } else if(dimension == 1) {
      sum = new double[matrix.length][1];
      for(int row = 0; row < matrix.length; row++) {
        for(int col = 0; col < matrix.length; col++) {
          sum[row][0] += matrix[row][col];
        }
      }
    } else{
      sum = new double[1][matrix[0].length];
      for(int row = 0; row < matrix.length; row++) {
        for(int col = 0; col < matrix.length; col++) {
          sum[0][col] += matrix[row][col];
        }
      }
    }
    return sum;
  }

  // public static double[][] reducedRowForm(double[][] matrix) {
  //
  //   for(int col = 0; col < matrix[0].length; col++){
  //     for(int row = 0; row < matrix.length; row++) {
  //       double ratio = matrix[col][]
  //     }
  //   }
  // }

  public static int maxIndex(double[] vector){
    int index = 0;
    for(int i = 1; i < vector.length; i++){
      if(vector[index] < vector[i]){
        index = i;
      }
    }
    return index;
  }

  public static double[][] deepCopy(double[][] matrix){
    double[][] copy = new double[matrix.length][matrix[0].length];
    for(int row = 0; row < matrix.length; row++) {
      for(int col = 0; col < matrix[0].length; col++) {
        copy[row][col] = matrix[row][col];
      }
    }
    return copy;
  }

  public static double[] deepCopy(double[] vector){
    double[] copy = new double[vector.length];
    for(int i = 0; i < vector.length; i++) {
      copy[i] = vector[i];
    }
    return copy;
  }

  public static double[] column(int col, double[][] matrix) {
    double[] columnVector = new double[matrix.length];
    for(int row = 0; row < matrix.length; row++) {
      columnVector[row] = matrix[row][col];
    }
    return columnVector;
  }
}
