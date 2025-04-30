# Algorithm Benchmarking in Java
## Joe Linogao - 2025

This project is used to benchmark a collection of algorithms using a basic start-stop benchmarking
strategy. The program performs each sort 10 times and saves the average runtime in milliseconds for 
every array size the user has requested. The algorithms currently implemented are as follows:
- Bubble Sort
- Counting Sort
- Insertion Sort
- Merge Sort
- Selection Sort 

## Running the program
Note that this project requires JDK 21 or higher to run. To run the program...
1. Clone this repository to your local machine
2. Compile and run `src/BenchmarkRunner.java`
3. Follow the instructions shown in the terminal

### How to run program from jar file
When running this program you have two options:
1) Run the included .jar file using `java -cp ./algorithm-benchmarking-in-java.jar BenchmarkRunner` to begin the program

The steps I used to generate a `.jar` artefact in Intellij can be found
[here](https://stackoverflow.com/questions/2025607/how-to-create-a-jar-file-or-export-jar-in-intellij-idea-like-eclipse-java-arch)
