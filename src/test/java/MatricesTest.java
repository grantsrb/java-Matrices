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
  public void equals_comparesNullForEquality_boolean(){
    double[][] matrix1 = null;
    double[][] matrix2 = null;
    assertTrue(Matrices.equals(matrix1, matrix2));
  }

  @Test
  public void equals_comparesVectorsForEquality_boolean(){
    double[] vector1 = new double[] {1,0,1};
    double[] vector2 = new double[] {1,0,1};
    assertTrue(Matrices.equals(vector1, vector2));
  }

  @Test
  public void equals_comparesNullForEqualityVectors_boolean(){
    double[] vector1 = null;
    double[] vector2 = null;
    assertTrue(Matrices.equals(vector1, vector2));
  }

  @Test
  public void multiply_standardMatrixMultiplication_2DdoubleArray(){
    double[][] leftMatrix = new double[][] {{1,2,3},{4,5,6},{7,8,9}};
    double[][] rightMatrix = new double[][] {{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
    double[][] knownProduct = new double[][] {{100,106,112,118,124},{235,250,265,280,295},{370,394,418,442,466}};
    double[][] testProduct = Matrices.multiply(leftMatrix, rightMatrix);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void multiply_standardMatrixMultiplication_null(){
    double[][] leftMatrix = new double[][] {{1,2,3},{4,5,6},{7,8,9}};
    double[][] rightMatrix = new double[][] {{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24},{25,26,27,28,29}};
    double[][] knownProduct = null;
    double[][] testProduct = Matrices.multiply(leftMatrix, rightMatrix);
    System.out.println(testProduct == null);
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
    double[][] testSum = Matrices.add(scalar,testMatrix);
    assertTrue(Matrices.equals(knownSum, testSum));
  }

  @Test
  public void add_scalarAdditionAcrossVector_doubleArray(){
    double[] testVector = new double[] {1,2,3};
    double scalar = 5;
    double[] knownSum = new double[] {6,7,8};
    double[] testSum = Matrices.add(scalar,testVector);
    assertTrue(Matrices.equals(knownSum, testSum));
  }

  @Test
  public void add_standardVectorAddition_doubleArray(){
    double[] vector1 = new double[] {1,2,3};
    double[] vector2 = new double[] {4,5,6};
    double[] knownSum = new double[] {5,7,9};
    double[] testSum = Matrices.add(vector1,vector2);
    assertTrue(Matrices.equals(knownSum, testSum));
  }

  @Test
  public void multiply_scalarMultiplicationAcrossMatrix_2DdoubleArray(){
    double[][] testMatrix = new double[][] {{2,1,2}, {0,2,-1}, {2,2,3}};
    double[][] knownProduct = new double[][] {{10,5,10}, {0,10,-5}, {10,10,15}};
    double scalar = 5;
    double [][] testProduct = Matrices.multiply(scalar,testMatrix);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void multiply_scalarMultiplicationAcrossVector_doubleArray(){
    double[] testVector = new double[] {1,2,3};
    double scalar = 5;
    double[] knownProduct = new double[] {5,10,15};
    double[] testProduct = Matrices.multiply(scalar,testVector);
    assertTrue(Matrices.equals(knownProduct, testProduct));
  }

  @Test
  public void multiplyPairwise_multipliesVectorsElementByElement_doubleArray(){
    double[] vector1 = new double[] {1,2,3};
    double[] vector2 = new double[] {4,5,6};
    double[] knownProduct = new double[] {4,10,18};
    double[] testProduct = Matrices.multiplyPairwise(vector1, vector2);
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
    double[][] matrix = new double[][] {{1,0,2,5}, {0,-4,0,6}, {1,100,-6,7}};
    double[][] knownCopy = new double[][] {{1,0,2,5}, {0,-4,0,6}, {1,100,-6,7}};
    double[][] testCopy = Matrices.deepCopy(matrix);
    assertTrue(Matrices.equals(knownCopy, testCopy));
  }

  @Test
  public void deepCopy_returnsDeepCopyOfVector_doubleArray(){
    double[] vector = new double[] {1,0,2,5};
    double[] knownCopy = new double[] {1,0,2,5};
    double[] testCopy = Matrices.deepCopy(vector);
    assertTrue(Matrices.equals(knownCopy, testCopy));
  }

  @Test
  public void column_returnsSpecifiedColumnFromMatrixAsVector_doubleArray(){
    double[][] matrix = new double[][] {{1,0,2}, {0,-4,0}, {1,100,-6}};
    double[] knownColumn = new double[] {0,-4,100};
    double[] testColumn = Matrices.column(1,matrix);
    assertTrue(Matrices.equals(knownColumn, testColumn));
  }

  @Test
  public void maxIndex_returnsIndexOfMaxValueInVector_int(){
    double[] vector = new double[] {1,0,2,5};
    int knownIndex = 3;
    int testIndex = Matrices.maxIndex(vector);
    assertEquals(knownIndex, testIndex);
  }

  @Test
  public void firstNonZeroIndex_returnsIndexOf1stNonZeroValueInVectorOnOrPastSpecifiedValue_int() {
    double[] vector = new double[] {1,0,2,5};
    int startIndex = 1;
    int knownFirstNonZeroIndex = 2;
    int testIndex = Matrices.firstNonZeroIndex(startIndex, vector);
    assertEquals(knownFirstNonZeroIndex, testIndex);
  }

  @Test
  public void transpose_returnsTransposeOfMatrix_2DdoubleArray() {
    double[][] matrix = {{1,2,3,4},{5,6,7,8}};
    double[][] knownTranspose = {{1,5},{2,6},{3,7},{4,8}};
    double[][] testTranspose = Matrices.transpose(matrix);
    assertTrue(Matrices.equals(knownTranspose, testTranspose));
  }

}
