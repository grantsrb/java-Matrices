public class App{
  public static void main(String[] args) {
    double[][] array1 = new double[][] {{1,2,3},
                                  {4,5,6},
                                  {7,8,9}};
    double[][] array2 = new double[][] {{10,11,12,13,14},
                                        {15,16,17,18,19},
                                        {20,21,22,23,24}};

    double[][] product = Matrices.multiplyMatrix(array1, array2);
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
