# 📂 Ödev - Records
Bir okul, öğrencilerinin bilgilerini saklamak için basit bir öğrenci kayıt sistemi geliştirmektedir. Bu sistemde, her öğrencinin adı, soyadı ve öğrenci numarası gibi bilgilerini saklamak için Java Records kullanılacaktır.

Senaryo:

Bir öğrenci, adı, soyadı ve öğrenci numarası gibi temel bilgilere sahip olacaktır. Bu bilgileri tutacak bir Record sınıfı kullanarak öğrencilerin bilgilerini saklayın. Bu kayıt sınıfının immutable (değiştirilemez) olmasını sağlayın.

Yapmanız gerekenler:

Student adında bir Record sınıfı oluşturun.

Öğrencinin adı, soyadı ve öğrenci numarası gibi bilgileri içermelidir.

Student sınıfını kullanarak birkaç öğrenci oluşturun ve öğrencilerin bilgilerini ekrana yazdırın.

Student sınıfının hashCode ve equals metodlarının doğru şekilde çalıştığından emin olun.


### Örnek Girdi
    Student student = new Student("Ali", "Biner","123456789");
    Student student1 = new Student("Serkan","Kahraman"
    ,"123456678");

### Örnek Çıktı

    student = Ali Biner - 123456789
    student1 = Serkan Kahraman - 123456678
    student.hashCode() = 185839839
    student1.hashCode() = -132385613
    student.equals(student1) = false