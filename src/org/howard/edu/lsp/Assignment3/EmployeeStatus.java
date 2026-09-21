package org.howard.edu.lsp.assignment3;

public enum EmploymentStatus {

    PART_TIME,
    FULL_TIME;

    public static EmploymentStatus fromHours(double hoursWorked) {

        if (hoursWorked < 30) {
            return PART_TIME;
        }

        return FULL_TIME;
    }

    @Override
    public String toString() {

        switch (this) {
            case PART_TIME:
                return "Part-Time";

            case FULL_TIME:
                return "Full-Time";

            default:
                throw new IllegalStateException("Unknown employment status");
        }
    }
}
