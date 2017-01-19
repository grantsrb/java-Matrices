#Matrices Operations Library

###Satchel Grant

##Description

This is a java Matrices project to assist in matrix operations that are common to neural networks programming. All operations use double types. Please contact me if you would like any specific operations to be added to the class.

##Static Methods

Method | Return Type | Description
---------------|-------|--------
add(double[][] leftMatrix, double[][] rightMatrix) | double[][] | Completes standard matrix addition. Returns deep copy of result. Returns null if matrix dimensions do not match.
add(double scalar, double[][] matrix) | double[][] | Adds scalar value to each cell in matrix and returns deep copy of result.
column(int col, double[][] matrix) | double[] | Returns column from given matrix as a vector.
deepCopy(double[][] matrix) | double[][] | returns deep copy of matrix.
deepCopy(double[] vector) | double[][] | returns deep copy of vector.
equals(double[][] matrix1, double[][] matrix2) | boolean | Returns true if two matrices are deep copies of each other.
equals(double[] vector1, double[] vector2) | boolean | Returns true if two vectors are deep copies of each other.
firstNonZeroIndex(int startIndex, double[] vector) | int | Returns index of first non-zero value in vector on or past startIndex.
maxIndex(double[] vector) | int | Returns the index of the first occurrence of the maximum value within the vector.
multiplyMatrix(double[][] leftMatrix, double[][] rightMatrix) | double[][] | Completes standard matrix multiplication. Returns null if leftMatrix column count is not equal to the rightMatrix row count.
multiplyScalar(double scalar, double[][] matrix) | double[][] | Multiplies each cell in matrix by scalar value and returns deep copy of result.
multiplyPairwise(double[][] matrix1, double[][] matrix2) | double[][] | Multiplies each cell of matrix1 by the corresponding cell of matrix2 and returns deep copy of result. Returns null if matrix dimensions do not match.
sum(int dimension, double[][] matrix) | double[][] | Finds sum of all elements in specified dimension, returns vector of sums as 2D matrix. Dimension of 0 returns sum of all elements in matrix as 2D matrix with 1 column and 1 row. Dimension 1 returns a 2D matrix with a single column and each row specifying the sum of each element in the corresponding row in the matrix. Dimension 2 returns a 2D matrix with a single row and each column specifying the sum of each element in the corresponding column in the matrix. Returns null if matrix dimensions do not match.


## Setup/Installation Requirements ##
* Java
* Gradle

## Setup/Installation ##
Depending on your project, you will likely only need the Matrices.java file located in the src/main/java/ path. The gradle project environment is only to do unit testing. So, if you do not care for the tests, here's what you need to do:

####Setup without Tests
* Clone this repository to your computer
* Within the cloned repository, navigate to the src/main/java/ file.
* Take the Matrices.java file from this location and put it into the same directory as the java file that you currently need to do matrix operations.
* Refer to Static Methods section of this README to know which methods to use for your needs.


If you're starting a new project or want to tinker with the Matrices class code, I recommend you use the project setup that I have provided. The tests will alert you if something has gone wrong with the Matrices class and you can easily set up new tests for whatever endeavor you are embarking on. Testing is good.

#### Setup with Tests
* Clone this repository to your computer
* Create new java classes in the src/main/java/ directory
* Create new test classes in the src/test/java/ directory
* Use src/main/java/App.java for user interface


## Support and Contact Details ##

Please report any bugs or issues you find to me at grantsrb@gmail.com. Also please let me know if there are any features you would like to have added.

## Technologies Used
* Java
* Gradle
* JUnit 4.+

### Legal

Copyright (c) 2016 Satchel Grant

Licensed under the MIT license
