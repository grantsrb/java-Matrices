import org.junit.*;
import static org.junit.Assert.*;

public class MatricesTest{
  double[][] leftMatrix;
  double[][] rightMatrix;
  double[][] knownProduct;

  @Before
  public void initialize(){
    this.leftMatrix = new double[][] {{1,2,3},
                                  {4,5,6},
                                  {7,8,9}};
    this.rightMatrix = new double[][] {{10,11,12,13,14},
                                        {15,16,17,18,19},
                                        {20,21,22,23,24}};
    this.knownProduct = new double[][] {{100,106,112,118,124},{235,250,265,280,295},{370,394,418,442,466}};
  }

  @Test
  public void equals_compares2DMatricesForEquality_boolean(){
    double[][] matrix1 = new double[][] {{1,0,1}, {0,1,0}, {1,1,0}};
    double[][] matrix2 = new double[][] {{1,0,1}, {0,1,0}, {1,1,0}};
    assertTrue(Matrices.equals(matrix1, matrix2));
  }

  @Test
  public void multiplyMatrix_standardMatrixMultiplication_2DdoubleArray(){
    double[][] testProduct = Matrices.multiplyMatrix(this.leftMatrix, this.rightMatrix);
    assertTrue(Matrices.equals(this.knownProduct, testProduct));
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

  // @Test
  // public void multiplyPairwise_

}
