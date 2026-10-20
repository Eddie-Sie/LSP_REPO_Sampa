# Assignment 5 — Java Collections Framework

**Course:** CSCI 363 — Large Scale Programming  
**Institution:** Howard University  
**Student:** Edward Sie

## Project Overview

This assignment implements a custom `IntegerSet` class using Java's Collections Framework.

The class represents a mathematical set of integers, where duplicate values are not permitted and elements are maintained in ascending order.

## Implementation

The implementation uses `TreeSet<Integer>` as its underlying data structure.

A `TreeSet` was selected because it:

- Automatically prevents duplicate elements.
- Maintains integers in sorted order.
- Supports efficient insertion, removal, and membership checks.
- Provides built-in collection operations that simplify mathematical set operations.

## Supported Operations

The `IntegerSet` class supports:

- Adding and removing integers
- Clearing a set
- Checking membership and set size
- Finding the smallest and largest elements
- Comparing sets for equality
- Union and intersection
- Difference and complement
- Subset and disjointness checks
- Symmetric difference
- Checking whether a set is empty
- Displaying elements in ascending order

Set operations that return an `IntegerSet` create independent result objects without modifying the original sets.

## Compilation and Execution

From the repository root, compile the Java source files using:

```bash
javac -d out src/org/howard/edu/lsp/assignment5/IntegerSet.java src/org/howard/edu/lsp/assignment5/Driver.java
```

Run the driver using:

```bash
java -cp out org.howard.edu.lsp.assignment5.Driver
```

These commands assume the Java source files are located in the `src` directory.

## Testing

The assignment includes a professor-provided `Driver.java` that checks the correctness of the `IntegerSet` methods.

The implementation was previously tested in a separate environment, with 47 of 47 functional tests passing. Final verification in the GitHub repository is still required.

## AI Usage

ChatGPT was used to assist with understanding the assignment, generating and explaining Java code, and preparing project documentation.

See `AI_Usage_Report.md` for details.
