import org.junit.*;
import static org.junit.Assert.*;

public class MatricesTest{

  @Test
  public void equals_compares2DMatricesForEquality_boolean(){
    double[][] matrix1 = new double[][] {{1,0,1}, {0,1,0}, {1,1,0}};
    double[][] matrix2 = new double[][] {{1,0,1}, {0,1,0}, {1,1,0}};
    assertTrue(Matrices.equals(matrix1, matrix2));
  }

  @Test
  public void equals_comparesVectorsForEquality_boolean(){
    double[] vector1 = new double[] {1,0,1};
    double[] vector2 = new double[] {1,0,1};
    assertTrue(Matrices.equals(vector1, vector2));
  }

  @Test
  public void multiplyMatrix_standardMatrixMultiplication_2DdoubleArray(){
    double[][] leftMatrix = new double[][] {{1,2,3},{4,5,6},{7,8,9}};
    double[][] rightMatrix = new double[][] {{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
    double[][] knownProduct = new double[][] {{100,106,112,118,124},{235,250,265,280,295},{370,394,418,442,466}};
    double[][] testProduct = Matrices.multiplyMatrix(leftMatrix, rightMatrix);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void add_standardMatrixAddition_2DdoubleArray() {
    double[][] matrix1 = new double[][] {{1,0,1}, {0,1,0}, {1,1,3}};
    double[][] matrix2 = new double[][] {{1,1,1}, {0,1,-1}, {1,1,0}};
    double[][] knownSum = new double[][] {{2,1,2}, {0,2,-1}, {2,2,3}};
    double[][] testSum = Matrices.add(matrix1, matrix2);
    assertTrue(Matrices.equals(knownSum, testSum));
  }

  @Test
  public void add_scalarAdditionAcrossMatrix_2DdoubleArray(){
    double[][] testMatrix = new double[][] {{2,1,2}, {0,2,-1}, {2,2,3}};
    double[][] knownSum = new double[][] {{7,6,7}, {5,7,4}, {7,7,8}};
    double scalar = 5;
    double [][] testSum = Matrices.add(scalar,testMatrix);
    assertTrue(Matrices.equals(knownSum, testSum));
  }

  @Test
  public void multiplyScalar_scalarMultiplicationAcrossMatrix_2DdoubleArray(){
    double[][] testMatrix = new double[][] {{2,1,2}, {0,2,-1}, {2,2,3}};
    double[][] knownProduct = new double[][] {{10,5,10}, {0,10,-5}, {10,10,15}};
    double scalar = 5;
    double [][] testProduct = Matrices.multiplyScalar(scalar,testMatrix);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void multiplyPairwise_multipliesMatricesElementByElement_2DdoubleArray(){
    double[][] matrix1 = new double[][] {{1,0,1}, {0,-4,0}, {1,10,3}};
    double[][] matrix2 = new double[][] {{1,1,2}, {0,1,-1}, {1,10,-2}};
    double[][] knownProduct = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double[][] testProduct = Matrices.multiplyPairwise(matrix1, matrix2);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void sum_sumsAllElementsInSpecifiedDimension0_double(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double [][] knownSum = new double[][] {{94}};
    double[][] sum = Matrices.sum(0, matrix);
    assertTrue(Matrices.equals(knownSum, sum));
  }

  @Test
  public void sum_sumsAllElementsInSpecifiedDimension1_double(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double [][] knownSum = new double[][] {{3},{-4},{95}};
    double[][] sum = Matrices.sum(1, matrix);
    assertTrue(Matrices.equals(knownSum, sum));
  }

  @Test
  public void sum_sumsAllElementsInSpecifiedDimension2_double(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double [][] knownSum = new double[][] {{2,96,-4}};
    double[][] sum = Matrices.sum(2, matrix);
    assertTrue(Matrices.equals(knownSum, sum));
  }

  @Test
  public void deepCopy_returnsDeepCopyOfMatrix_2DdoubleArray(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double[][] knownCopy = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double[][] testCopy = Matrices.deepCopy(matrix);
    assertTrue(Matrices.equals(knownCopy, testCopy));
  }

  @Test
  public void column_returnsSpecifiedColumnFromMatrixAsVector_doubleArray(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double[] knownColumn = new double[] {0,-4,100};
    double[] testColumn = Matrices.column(1,matrix);
    assertTrue(Matrices.equals(knownColumn, testColumn));
  }

}
