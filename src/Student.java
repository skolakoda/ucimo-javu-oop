public class Student extends Osoba {
	
  public Student(String ime) {
    super(ime);
  }

  public String toString() {
    return super.toString() + ", da da";
  }

  public static void main(String[] args) {
    Osoba otac = new Osoba("Babo");
    Student ucenik = new Student("Luko");

    System.out.println("Tvoje ime je " + otac);
    System.out.println("Moje ime je " + ucenik);
  }
}