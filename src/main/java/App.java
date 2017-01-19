public class App{
  public static void main(String[] args) {
    double[][] array1 = {{1,2,3},
                          {1,2,3},
                          {1,2,3}};
    double[][] array2 = {{2,1,1,1,0},
                          {1,1,1,1,1},
                          {1,1,1,1,1}};

    double[][] product = Matrices.matrixMultiply(array1, array2);
    for(int i = 0; i < product.length; i++) {
      for(int j = 0; j < product[0].length;j++) {
        if(j < product[0].length-1) {
          System.out.print(product[i][j] + " ");
        } else {
          System.out.println(product[i][j]);
        }
      }
    }
  }
}
