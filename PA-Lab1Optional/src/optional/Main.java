package optional;

import java.util.Arrays;

//1: cd .\src
//2: javac .\optional\Main.java
//3: java optional.Main
public class Main {
    //->Run ->Edit configurations ->Modify options ->add VM options ->VM options: -Xms8G -Xmx8G -Xss1024M
    public static void main(String[] args) {
        long startTime = System.nanoTime(); // starting the counting
        if (args.length != 1 || Character.compare(args[0].charAt(0), '0') == 0) { // For what we will offer to the command
            System.out.println("Give a natural number!");                      // a single number that is not starting
            System.exit(-1);                                              // with 0
        }

        for (int i = 0; i < args[0].length(); i++) { // Go thru the number
            int ok = 0;              // variable that makes sure the number is int and not other type
            for (int j = 0; j <= 9; j++) {
                char letter = (char)(j + '0');      // transform nat number into string
                if (Character.compare(args[0].charAt(i), letter) == 0) {     // comparing
                    ok = 1;
                }
            }
            if (ok == 0) {       // if we have a letter in our number
                System.out.println("Give a natural number!");
                System.exit(-1);
            }
        }

        int number = Integer.parseInt(args[0]); // getting our number to int form
        if (number % 2 != 1) {     // making sure our number is odd
            System.out.println("Give an odd natural number!");
            System.exit(-1);
        }

        int[][] matrix = ObtainRandomMatrix(number); // obtaining the random adjacency matrix of number*number elements
        if (number < 30000) {
            DisplayMatrix(matrix);    // display the matrix
        }

        Boolean[] visited = new Boolean[matrix.length]; // for making sure which vertex was checked
        visited[0] = true;
        Arrays.fill(visited, Boolean.FALSE);    // filling our array with false statement
        visited = DFS(matrix, 0, visited);  // DFS function for testing the matrix

        for (int i = 0; i < matrix.length; i++) { // testing the vector, if one element is false
            if (!visited[i]) {                   // then the matrix is not connected
                System.out.println("The graph is not connected!");
                Arrays.fill(visited, Boolean.FALSE);
                for (int j = 0; j < matrix.length; j++) {
                    if (!visited[j]) {
                        System.out.print("The connected components: ");
                        visited = DFSDisplay(matrix, j, visited); // displaying connected components
                        System.out.println();
                    }
                }
                long endTime   = System.nanoTime(); // ending the counting
                long totalTime = endTime - startTime; // calculating the total time

                System.out.println("Execution time: " + totalTime + " nanoseconds");    // displaying the time
                System.exit(-1);
            }
        }
        System.out.println("The graph is connected!");

        Tree(matrix, number); // creating and displaying our partial tree

        long endTime   = System.nanoTime(); // ending the counting
        long totalTime = endTime - startTime; // calculating the total time

        System.out.println("Execution time: " + totalTime + " nanoseconds");    // displaying the time
        System.exit(-1);
    }
    public static int[][] ObtainRandomMatrix(int n) { // function that returns a random adjacency matrix of n*n elements
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
            for (int j= i + 1; j < n; j++) {
                matrix[i][j] = matrix[j][i] = (int)(Math.random() * 2); // 2 is the range of our random numbers
            }                                                          // (max - min +1)(1;0)
        }
        return matrix;
    }
    public static void DisplayMatrix(int[][] matrix) { // function for displaying the matrix using unicode
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print("\u2B2C ");
                } else {
                    System.out.print("\u2B2D ");
                }
            }
            System.out.println();
        }
    }
    public static Boolean[] DFS(int[][] matrix, int n, Boolean[] visited) { // functions that is doing a DFS on the
        visited[n] = true;                                                 // matrix and makes sure all components are
        for (int i = 0; i < matrix.length; i++) {                         // connected by starting from the first vertex
            if (!visited[i] && matrix[n][i] == 1) {                      // and going thru all neighbors
                visited[n] = true;
                visited = DFS(matrix, i, visited);
            }
        }
        return visited;     // returning the visited vertexes
    }
    public static Boolean[] DFSDisplay(int[][] matrix, int n, Boolean[] visited) { // for displaying the connected components
        visited[n] = true;
        System.out.print(n + " ");
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i] && matrix[n][i] == 1) {
                visited[n] = true;
                visited = DFSDisplay(matrix, i, visited);
            }
        }
        return visited;
    }
    public static void Tree(int[][] matrix, int number) { // making a tree out of our graph from the matrix
        Boolean[] taken = new Boolean[matrix.length];
        Arrays.fill(taken, Boolean.FALSE);
        taken[0] = true;
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1 && !taken[j]) {
                    taken[j] = true;
                } else {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        for (i = 0; i < matrix.length; i++) {    // making the matrix symmetrical
            for (j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[j][i] = 1;
                }
            }
        }
        if (number < 30000) { // displaying only if our number is less then 30 000
            System.out.println("The tree will be like this: ");
            DisplayMatrix(matrix);
        }
    }
}