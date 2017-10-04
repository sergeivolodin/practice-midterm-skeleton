# CS305 – Software Engineering

## Practice Midterm

NOTE: Too see your code coverage, you can type `./gradlew test` and then `./gradlew jacoco` in the terminal and a report will be created in
your root folder under `/build/reports/jacoco/test/html/index.html`, this process will be automatically done during the actual midterm, you will only need to
push your code on the repository we will give you and the coverage will be displayed on Jenkins.

# Part 1: Practice [60 points]

In this part of the midterm, you will write two classes. Note that, as is usual in SwEng, the problem itself is fairly easy to reason about, and what really matters is that your code employs solid software engineering principles:

- Write correct and rock-solid code.
- Write tests for your code; aim for 100% line coverage. We provide a sample test case to ease the creation of further tests.
- Follow the SwEng coding conventions, write readable and concise code, and use comments judiciously.

We provide you with a project that can be opened and worked on in Android Studio, and built with Gradle.  
You are free to use any editor of your choice, as long as the code and tests build using `gradlew build`.

**Do not modify in any way the public interface of the code that is given to you**, not even to add checked exceptions. We will use many automated tests when grading; if we cannot build and run your code, you will receive 0 points.

Your code should fail-fast, throwing adequately specific runtime exceptions (or custom versions of these):
- When implementing known interfaces, follow their prescribed exceptions.
- Throw `IndexOutOfBoundsException` for any kind of index whose value is too low or too high.
- Throw `IllegalArgumentException` for arguments (other than indexes) whose value is invalid.

## Part 1: `Vector` [30 points]

Implement a `Vector` class, whose skeleton is in `practice-midterm/src/main/java/ch/epfl/sweng/Vector.java`. It represents a vector as a sequence of scalars.

Implement the following methods:

- The constructor, which takes the dimension of the vector
- `double getElement(int index)`, which returns the value of the scalar element at `index` (with `index` starting at 0 not at 1)
- `void setElement(int index, double value)`, which sets the element at the specified index with the given value.
- `int dimension()`, which returns the dimension of the vector (i.e., its number of elements)
- `double norm()`, which returns the euclidean norm of the vector.

## Part 2: `Matrix` [30 points]

Implement a `Matrix` class, whose skeleton is in `practice-midterm/src/main/java/ch/epfl/sweng/Matrix.java`. It represents a matrix as multiple vector of scalar values.

Implement the following methods:

- `Matrix(int height, int width)` the constructor, which takes the width and the height of the Matrix, and initialize the matrix to 0.
- `Matrix(int[][] elements)` another constructor, which take an array of elements and initialize the Matrix with those values.
- `int getHeight()`, which returns the height of the matrix.
- `int getWidth()`, which returns the width of the matrix.
- `double getElement(int height, int width)`, which return the element at the given position.
- `void setElement(int height, int width, double value)`, which update the element value at the give position.
- `void normalizeColumns()`, which normalize the columns of the matrix.
- `Vector multiply(Vector vector)`, which multiply the matrix with the given vector.


## Grading

Your grade on the practice part of the exam consists of three components: correctness, coverage, and code quality. We assigned 30 points to each of correctness and coverage, and subtracted points for code that didn't meet SwEng quality standards.

### Correctness

We wrote tests to check the correctness of your code. Many of these tests are without points: they simply give you more detailed feedback on your solution without penalizing you for not passing them.

#### `Vector` 

##### Functionality

- When initialized, the `Vector` should be initialized with zeros.
- The `dimension` of a 10-element `Vector` should be correct
- The elements of the `Vector` should be accessible.
- The elements of the `Vector` can be updated.
- The `norm` of a 10-element `Vector` should be correct.

##### Invalid arguments

- A `Vector` with a dimension < 0 should throw an exception.
- Accessing an element outside the `Vector` should throw an exception.
- Updating the value of an element outside the `Vector` should throw an exception.

#### `Matrix` 

##### Functionality 

- When initialized without elements, the `Matrix` should be initialized with zeros.
- When initialized with elements, the `Matrix` should contain these exact elements.
- The `Height` of a 10x2 matrix should be correct.
- The `Width` of a 10x2 matrix should be correct.
- Getting an element of the `Matrix` should return the correct value.
- Updating an element of the `Matrix` should update the correct element with the correct value.
- Normalizing a 10x1 `Matrix` should correctly update the elements of the `Matrix`.
- Multiplying a 3x3 `Matrix` with a 3x1 `Vector` should give the correct result.

##### Invalid arguments

- A `Matrix` should have at least of element, creating an empty `Matrix` should throw an exception.
- Creating a `Matrix` without any elements should throw an exception.
- Creating a non-rectangular `Matrix` should throw an exception.
- Getting an element outside the `Matrix` should throw an exception.
- Updating an element outside the `Matrix` should throw an exception.
- Multiplying a `Matrix` and a `Vector` of different size should throw an exception.

### Coverage

The code coverage score for your test suite is computed according to the following curve:

You get 0 points if coverage is less than 30%: the test we provided gets you almost there out of the box, and by testing basic features such as constructing a `Vector` and checking the behavior of the basic functions will easily get you over 30%. The rest of the curve rewards coverage according to a general estimate of how much effort it takes to reach that level of coverage.

### Code Quality

For this section, we manually looked at your code and assessed how well you observed the SwEng coding guidelines. Please see the grading report in your repo for details.
