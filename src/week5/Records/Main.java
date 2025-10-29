package week5.Records;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Enes", "Ünal","123456789");
        Student student1 = new Student("Serkan","Kahraman"
                ,"123456678");

        System.out.println("student = " + student.name() + " " + student.lastName() + " - " + student.StudentNo());
        System.out.println("student1 = " + student1.name() + " " + student1.lastName() + " - " + student1.StudentNo());
        System.out.println("student.hashCode() = " + student.hashCode());
        System.out.println("student1.hashCode() = " + student1.hashCode());
        System.out.println("student.equals(student1) = " + student.equals(student1));
    }
}