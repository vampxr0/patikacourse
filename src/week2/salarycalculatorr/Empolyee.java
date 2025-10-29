package week2.salarycalculatorr;


public class Employee implements SalaryCalculation{

    protected String nameAndSurname;

    protected double salary;

    protected int workingHours;

    protected int hireYear;




    public Employee(String nameAndSurname, double salary, int workingHours, int hireYear) {

        this.nameAndSurname = nameAndSurname;
        this.salary = salary;
        this.workingHours = workingHours;
        this.hireYear = hireYear;

        setNameAndSurname(nameAndSurname);

        setSalary(salary);

        setWorkHours(workingHours);

        setHireYear(hireYear);

    }

    @Override
    public String toString() {
        return  "Adı Soyadı: "+nameAndSurname +
                "\n"+"Maaşı: "+ salary+
                "\n"+"Haftalık Çalışma Saati: "+workingHours+
                "\n"+"İşe Giriş Yılı: "+hireYear +
                "\n"+"Vergi: "+ calculateTax()+
                "\n"+"Bonus: "+ calculateBonus()+
                "\n"+"Maaş Artışı: "+ calculateRaiseSalary() +
                "\n"+"Vergi ve Bonuslar ile birlikte maaş :"+ calculateNetSalary() +
                "\n"+"Toplam Maaş: "+ calculateTotalSalary();
    }

    @Override
    public double calculateTax() {
        if (salary>=1000)
            return salary * 0.03;
        return 0;
    }

    @Override
    public double calculateBonus() {
        if (workingHours>STANDARD_WORK_HOURS)
            return BONUS_PER_HOUR*(workingHours-STANDARD_WORK_HOURS);
        return 0;
    }

    @Override
    public double calculateRaiseSalary() {
        if(YEAR - hireYear < 10)
            return salary * 0.05 ;
        else if ((YEAR - hireYear) < 20)
            return salary*0.1;
        return salary*0.15;
    }


    @Override
    public double calculateNetSalary() {
        return salary + calculateBonus() -  calculateTax();
    }

    @Override
    public double calculateTotalSalary() {
        return calculateNetSalary() + calculateRaiseSalary();
    }

    public void setNameAndSurname(String nameAndSurname) {

        if (nameAndSurname != null && !nameAndSurname.isEmpty())
            this.nameAndSurname = nameAndSurname;
        else
            throw new IllegalArgumentException("İsim boş olamaz.");
    }

    public void setSalary(double salary) {

        if (salary >= 0) {
            this.salary = salary;
            calculateTax();
            calculateRaiseSalary();
            calculateNetSalary();
            calculateTotalSalary();
        }else {
            throw new IllegalArgumentException("Maaş negatif olamaz.");
        }
    }

    public void setWorkHours(int workHours) {

        if(workHours>=0){
            this.workingHours = workHours;
            calculateBonus();
            calculateNetSalary();
            calculateTotalSalary();
        }else {
            throw new IllegalArgumentException("Çalışma saati negatif olamaz.");
        }
    }

    public void setHireYear(int hireYear) {

        if (hireYear>0){
            this.hireYear = hireYear;
            calculateRaiseSalary();
            calculateTotalSalary();
        }
        else {
            throw new IllegalArgumentException("Yıl negatif olamaz.");
        }
    }
}