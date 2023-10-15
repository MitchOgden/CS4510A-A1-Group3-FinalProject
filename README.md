# CS4510 Final Project: Refactoring RPN Calculator

## Purpose

The purpose of this project is to refactor the RPN Calculator from Project 13 to use the arbitrary precision `BigDecimal` type instead of the `double` type. This project aims to help us understand the importance of unit and integration tests in refactoring code.

## Student Learning Outcomes/Expected Outcomes

- SLO/EO: 2, 4, 5, 2d, 4e, 5a-5c

## Group Members

- Michael Charara
- Tyler Colwell
- Adriawna Khan
- Mitchell Ogden
- Michael Ohlsson
- Steven Rendon

## Instructions

### Final Project Proposal Details

- Review the documentation and APIs for the `java.math.BigDecimal` data type.
- Do a technical analysis of what it will take to refactor the RPN Calculator from Project 13 to use `BigDecimal` instead of `double` data types.
- Document in your report what types of changes are needed, what additional tests are needed, and what additional classes or code will be needed.

### Issue Tracking

Your instructor will set up a free online issue tracking system for you to use in this course. You will create issues to assign work to team members and report bugs that you find in your own code or other’s code and assign it to be fixed.

### Final Project First Draft Details

- Divide up the source files among the team members.
- Refactor each class to use `BigDecimal` type instead of `double`.
- Create a new class called `BigDecimalUtils`.

### Final Project Second Draft Details

- Implement the needed `BigDecimalUtils` methods using Test-Driven Development.
- Test using a `MathContext.DECIMAL64`.
- Create unit test stubs for the methods in `BigDecimalUtils`.

### Final Project Details

- Change your code to test with a `MathContext.DECIMAL128`.
- Refactor the `BigDecimalUtils` so that they use native `BigDecimal` math to implement the functionality.

## Resources

- Wolfram Alpha Calculator
