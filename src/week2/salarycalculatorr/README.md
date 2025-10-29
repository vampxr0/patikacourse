package week2.salarycalculator;

public interface SalaryCalculation {

    int STANDARD_WORK_HOURS = 40;
    int BONUS_PER_HOUR = 30;
    int YEAR = 2021;


    double calculateTax();

    double calculateBonus();

    double  calculateRaiseSalary() ;

    double calculateNetSalary();

    double calculateTotalSalary();
}