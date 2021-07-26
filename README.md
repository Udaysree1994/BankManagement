# BankManagement

Java application to calculate relative balances of transactions from a given csv file.

#Technology used
  1. Java 8
  2. JUnit 5 for unit testing

#Working
  1. Relative balance is calculated based on all the transactions in the given time window
  2. Any reversal of transactions which fall outside the time window but belonging to the actual time window is omitted
  3. Currently one reversal is removed to keep logic simple for simple input files (can be extended for larger input data sets)


#Running the project
  1. Run the Driver class
     Input the Accountnumber, fromDate and toDate
     Output - Relative balance in the given time window and the number of transactions
  2. Run the tests in the com.tests package to run the unit tests
