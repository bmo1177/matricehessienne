# Hessian Matrix Analysis

## Description
This project performs an analysis of the Hessian matrix of a given function. It computes the characteristic polynomial, eigenvalues, determinant, and provides a conclusion about convexity or concavity.

## Features
- Defines the Hessian matrix
- Computes the characteristic polynomial
- Computes eigenvalues using EigenDecomposition
- Determines the determinant of the Hessian matrix
- Analyzes convexity based on eigenvalues

## Prerequisites
- Java 21
- Apache Maven
- NetBeans 24 (recommended for development)
- Apache Commons Math3 library

## Installation & Setup
1. Clone the repository or copy the project files.
2. Ensure Maven is installed and configured.
3. Navigate to the project root and run:
   ```sh
   mvn clean install
   ```
4. Run the project using:
   ```sh
   mvn exec:java
   ```

## Project Structure
```
project-root/
│── src/main/java/com/mycompany/matrixh/
│   ├── HessianAnalysis.java
│── pom.xml
│── README.md
```

## Dependencies
This project uses the Apache Commons Math3 library:
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-math3</artifactId>
    <version>3.6.1</version>
</dependency>
```

## Example Output
```
### Étape 1 : Définition de la Matrice Hessienne ###
  0.00   2.00  -1.00
  3.00  -2.00   0.00
 -2.00   2.00   1.00

### Étape 2 : Calcul du Polynôme Caractéristique ###
...

### Étape 3 : Calcul des Valeurs Propres ###
lamda = 2.0
lamda = -4.0
lamda = 1.0

### Étape 4 : Calcul du Déterminant ###
Det(H_f) = -8.0

### Étape 5 : Conclusion ###
La matrice Hessienne est indéfinie : f(x, y) n'est ni convexe ni concave.
```

## Author
- Developed by bmo1177

## License
This project is licensed under the MIT License.

