package week5.InnerClass;

public class Employee {
    private String firstName;
    private String lastName;
    private ContactInfo contactInfo; // Inner class instance

    // Constructor
    public Employee(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        // ContactInfo yalnızca Employee'ye bağlı olarak burada oluşturuluyor
        this.contactInfo = new ContactInfo(phone, email);
    }

    // Getter / Setter (isteğe bağlı)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public ContactInfo getContactInfo(){
        return this.contactInfo;
    }

    // Çalışanın iletişim bilgilerini gösteren metot
    public void displayContactInfo() {
        System.out.println("Employee: " + firstName + " " + lastName);
        if (contactInfo != null) {
            contactInfo.display(); // iç sınıfın metodu çağrılır
        } else {
            System.out.println("No contact info available.");
        }
    }

    // Inner Class: ContactInfo
    public class ContactInfo {
        private String phone;
        private String email;

        // Constructor (sadece Employee içinde kullanılır)
        private ContactInfo(String phone, String email) {
            this.phone = phone;
            this.email = email;
        }

        // Getter / Setter
        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // İletişim bilgilerini gösteren metot
        private void display() {
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
        }
    }
}