  For making sure that the program will work for numbers greater than 30.000, I used this settings:
->Run ->Edit configurations ->Modify options ->add VM options ->VM options: -Xms8G -Xmx8G -Xss1024M

  To run it you'll need to be in the src file, compile it with "javac .\optional\Main.java" and run with "java optional.Main " and add the number of your choice.

  Firstly, I verified if the user is giving just one number and if that number is not starting with 0. Then, I'm making sure if the number is containing just numbers and if
that number is an odd one.
  Then I generated a random adjacency matrix with the "ObtainRandomMatrix()" function, which is just making a new matrix and distributes random numbers from 0 to 1 to all the 
elements, making sure is symetric. In case of a number lower than 30.000, the code will display the matrix.
  By using a DFS on our adjacency matrix, we are verifying if the graph is connected or not, making sure if all vertices are connected to the first vertex. In case of not being
connected, the code will display the connected components using "DFSDisplay()" function, which is making a dfs and printing the components by updating the vector "visited", and
it prints the time that was taken to get to this point.
  If the graph is connected, the code will make a partial tree out of that graph (adjacency matrix), with the help of the function "Tree()",which is just doing a dfs and deleting
the conections between that vertices who are already taken, taken meaning if from the first vertex we have connections to the 2nd and 3rd vertex that vertices will be taken
so that if another vertex haa conections with them, we will delete that conection. The displaing of that matrix will be called in the "Tree()" function with the help of the 
function "DisplayMatrix()".
  The time will be displayed by substracting the time of the starting point from the time of the end point.
