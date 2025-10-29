package week5.InnerClass;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Ali","Biner","123456789","test@test.com");

        employee.displayContactInfo();
        employee.getContactInfo().setPhone("0500000000");
        employee.displayContactInfo();


    }
}