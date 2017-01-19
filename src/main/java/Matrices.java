

public class Matrices{
  public static double[][] matrixMultiply(double[][] leftMatrix, double[][] rightMatrix) {
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
}
