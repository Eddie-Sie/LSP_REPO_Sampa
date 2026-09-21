package org.howard.edu.lsp.assignment3;

public class EmployeeParser {

    public Employee parse(String line) {

        // Blank rows are invalid
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        // Split the CSV row into fields
        String[] fields = line.split(",", -1);

        // Every valid employee row must contain exactly 5 fields
        if (fields.length != 5) {
            return null;
        }

        try {
            int employeeId = Integer.parseInt(fields[0].trim());

            String name = fields[1].trim().toUpperCase();

            String department = fields[2].trim();

            double hoursWorked = Double.parseDouble(fields[3].trim());

            double hourlyRate = Double.parseDouble(fields[4].trim());

            // Hours and rates cannot be negative
            if (hoursWorked < 0 || hourlyRate < 0) {
                return null;
            }

            return new Employee(
                    employeeId,
                    name,
                    department,
                    hoursWorked,
                    hourlyRate
            );

        } catch (NumberFormatException e) {
            // Invalid numeric data makes the row invalid
            return null;
        }
    }
}
