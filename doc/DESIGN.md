# Assignment 3 Design

## Overview

Assignment 3 refactors the Employee Payroll ETL Pipeline from Assignment 2
using object-oriented programming principles. The goal of the refactoring
was to separate responsibilities into different classes while preserving
the same input, transformation rules, output format, and results from
Assignment 2.

The pipeline reads employee data from a CSV file, validates and transforms
the data, calculates payroll information, and writes the transformed
employees to a new CSV file.

## Class Responsibilities

### Employee

The `Employee` class represents one valid employee record.

It stores:

- Employee ID
- Name
- Department
- Hours Worked
- Hourly Rate

The fields are private and are accessed through getter methods. This
encapsulates the employee's data and prevents other classes from directly
changing the fields.

### EmployeeParser

The `EmployeeParser` class is responsible for converting a CSV row into an
`Employee` object.

It handles:

- Splitting the CSV row into fields
- Trimming input values
- Converting numeric values
- Converting employee names to uppercase
- Checking for invalid or negative values
- Rejecting blank or malformed rows

If a row is invalid, the parser returns `null`.

This keeps input validation and parsing separate from the main ETL pipeline.

### PayrollCalculator

The `PayrollCalculator` class is responsible for calculating an employee's
gross pay.

It handles:

- Regular pay
- Overtime pay for hours above 40
- The 1.5 overtime multiplier
- The 5% bonus for employees in the IT department
- Rounding GrossPay to two decimal places using HALF_UP rounding

Separating payroll calculations into their own class makes the calculation
logic easier to understand and maintain.

### PayLevel

`PayLevel` is an enum that represents the possible employee pay levels:

- Low
- Standard
- High
- Executive

The `fromGrossPay()` method determines the appropriate pay level based on
the final rounded GrossPay.

Using an enum prevents unrelated values from being used as pay levels and
makes the possible states explicit.

### EmploymentStatus

`EmploymentStatus` is an enum representing the two possible employment
statuses:

- Part-Time
- Full-Time

The `fromHours()` method determines the employee's status based on hours
worked.

An employee who works fewer than 30 hours is classified as Part-Time;
otherwise, the employee is classified as Full-Time.

## ETLPipeline

The `ETLPipeline` class coordinates the overall ETL process.

Its responsibilities include:

1. Opening the input and output files
2. Reading the input header
3. Reading each employee row
4. Tracking rows read
5. Passing rows to `EmployeeParser`
6. Passing valid employees to `PayrollCalculator`
7. Determining PayLevel
8. Determining EmploymentStatus
9. Writing transformed records to the output CSV
10. Tracking transformed and skipped rows
11. Printing the final summary

The `main()` method serves as the entry point for the application.

The class does not contain the detailed parsing or payroll calculation
logic. Instead, it delegates those responsibilities to the appropriate
classes.

## Object-Oriented Principles

### Encapsulation

The `Employee` class uses private fields and public getter methods to
protect the employee data.

For example, the employee ID is declared as:

```java
private final int employeeId;
