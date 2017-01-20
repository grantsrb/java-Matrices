import java.lang.Math;

public class Matrices{
  public static double[][] multiply(double[][] leftMatrix, double[][] rightMatrix) {
    if(leftMatrix[0].length != rightMatrix.length){
      return null;
    }
    double[][] product = new double[leftMatrix.length][rightMatrix[0].length];
    for(int rightCol = 0; rightCol < rightMatrix[0].length; rightCol++){
      for(int row = 0; row < leftMatrix.length; row++){
        for(int leftCol = 0; leftCol < leftMatrix[0].length; leftCol++) {
          product[row][rightCol] += leftMatrix[row][leftCol] * rightMatrix[leftCol][rightCol];
        }
      }
    }
    return product;
  }

  public static boolean equals(double[][] matrix1, double[][] matrix2) {
    if(matrix1 == null || matrix2 == null){
      if(matrix1 == matrix2){
        return true;
      } else {
        return false;
      }
    }
    if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
      return false;
    }
    for(int row = 0; row < matrix1.length; row++){
      for(int col = 0; col < matrix1[0].length; col++) {
        if(Math.abs(matrix1[row][col] - matrix2[row][col]) > 0.00001d){
          return false;
        }
      }
    }
    return true;
  }

  public static boolean equals(double[] vector1, double[] vector2) {
    if(vector1 == null || vector2 == null){
      if(vector1 == vector2){
        return true;
      } else {
        return false;
      }
    }
    if(vector1.length != vector2.length){
      return false;
    }
    for(int col = 0; col < vector1.length; col++) {
      if(Math.abs(vector1[col] - vector2[col]) > 0.00001d){
        return false;
      }
    }
    return true;
  }

  public static double[] add(double scalar, double[] vector) {
    double[] sum = new double[vector.length];
    for(int i = 0; i < sum.length; i++) {
      sum[i] = scalar + vector[i];
    }
    return sum;
  }

  public static double[] add(double[] vector1, double[] vector2) {
    if(vector1.length != vector2.length){
      return null;
    }
    double[] sum = new double[vector1.length];
    for(int i = 0; i < sum.length; i++) {
      sum[i] = vector1[i] + vector2[i];
    }
    return sum;
  }

  public static double[][] add(double[][] leftMatrix, double[][] rightMatrix) {
    double[][] sum = new double[leftMatrix.length][leftMatrix[0].length];
    if(leftMatrix.length != rightMatrix.length || leftMatrix[0].length != rightMatrix[0].length){
      return null;
    }
    for(int row = 0; row < sum.length; row++) {
      for(int col = 0; col < sum[0].length; col++) {
        sum[row][col] = leftMatrix[row][col] + rightMatrix[row][col];
      }
    }
    return sum;
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

  public static double[][] multiply(double scalar, double[][] matrix){
    double[][] product = new double[matrix.length][matrix[0].length];
    for(int row = 0; row < matrix.length; row++) {
      product[row] = Matrices.multiply(scalar, matrix[row]);
    }
    return product;
  }

  public static double[] multiply(double scalar, double[] vector){
    double[] product = new double[vector.length];
    for(int i = 0; i < vector.length; i++) {
      product[i] = scalar * vector[i];
    }
    return product;
  }

  public static double[] multiplyPairwise(double[] vector1, double[] vector2) {
    if(vector1.length != vector2.length){
      return null;
    }
    double[] product = new double[vector1.length];
    for(int i = 0; i < vector1.length; i++){
      product[i] = vector1[i] * vector2[i];
    }
    return product;
  }

  public static double[][] multiplyPairwise(double[][] leftMatrix, double[][] rightMatrix) {
    if(leftMatrix.length != rightMatrix.length || leftMatrix[0].length != rightMatrix[0].length){
      return null;
    }
    double[][] product = new double[leftMatrix.length][leftMatrix[0].length];
    for(int row = 0; row < leftMatrix.length; row++){
      for(int col = 0; col < leftMatrix[0].length; col++) {
        product[row][col] = leftMatrix[row][col] * rightMatrix[row][col];
      }
    }
    return product;
  }

  public static double sum(double[] vector) {
    double sum = 0d;
    for(int i = 0; i < vector.length; i++) {
      sum += vector[i];
    }
    return sum;
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

  public static double[][] reducedRowForm(double[][] matrix) {
    double[][] reducedMatrix = Matrices.deepCopy(matrix);
    int pivotLevel = 0;
    for(int col = 0; col < reducedMatrix[0].length; col++){
      if(col < reducedMatrix.length) {
        int pivotIndex = Matrices.firstNonZeroIndex(Matrices.column(col, reducedMatrix), pivotLevel);
        if(pivotIndex > -1){
          Matrices.swapRows(reducedMatrix,pivotLevel, pivotIndex);
          reducedMatrix[pivotLevel] = Matrices.multiply(1.0d/reducedMatrix[pivotLevel][col], reducedMatrix[pivotLevel]); // normalize row
          for(int row = pivotLevel+1; row < reducedMatrix.length; row++) {
            double ratio = reducedMatrix[row][col]/reducedMatrix[pivotLevel][col];
            double[] reductionRow = Matrices.multiply(-ratio, reducedMatrix[pivotLevel]);
            reducedMatrix[row] = Matrices.add(reductionRow, reducedMatrix[row]);
          }
          pivotLevel++;
        }
      } else {
        break;
      }
    }
    return reducedMatrix;
  }

  // public static double[][] rref(double[][] matrix) {
  //   double reducedMatrix = Matrices.reducedRowForm(matrix);
  //   for(int col = reducedMatrix[0].length-1; col >=0; col--){
  //
  //   }
  // }

  public static void swapRows(double[][] matrix, int row1, int row2) {
    double[] temp = matrix[row1];
    matrix[row1] = matrix[row2];
    matrix[row2] = temp;
  }

  public static int maxIndex(double[] vector){
    int index = 0;
    for(int i = 1; i < vector.length; i++){
      if(vector[index] < vector[i]){
        index = i;
      }
    }
    return index;
  }

  public static int firstNonZeroIndex(double[] vector) {
    for(int i = 0; i < vector.length; i++) {
      if(vector[i] != 0) {
        return i;
      }
    }
    return -1;
  }

  public static int firstNonZeroIndex(double[] vector, int startPoint) {
    for(int i = startPoint; i < vector.length; i++) {
      if(vector[i] != 0) {
        return i;
      }
    }
    return -1;
  }

  public static int firstNonZeroIndex(double[] vector, int startPoint, boolean reversed) {
    startPoint = startPoint >= vector.length ? vector.length-1 : startPoint;
    if(reversed){
      for(int i = startPoint; i >= 0; i--) {
        if(vector[i] != 0) {
          return i;
        }
      }
    } else {
      for(int i = startPoint; i < vector.length; i++) {
        if(vector[i] != 0) {
          return i;
        }
      }
    }
    return -1;
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

  public static double[][] transpose(double[][] matrix) {
    double[][] transpose = new double[matrix[0].length][matrix.length];
    for(int row = 0; row < matrix.length; row++) {
      for(int col = 0; col < matrix[0].length; col++){
        transpose[col][row] = matrix[row][col];
      }
    }
    return transpose;
  }

  public static void printMatrix(double[][] matrix) {
    for(int row = 0; row < matrix.length; row++){
      for(int col = 0; col < matrix[0].length; col++) {
        if(col < matrix[0].length-1){
          System.out.print(matrix[row][col] + " ");
        } else {
          System.out.println(matrix[row][col]);
        }
      }
    }
  }
}
