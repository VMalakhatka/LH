import java.util.ArrayList;

public class Department {
    private String title;
    private String telephoneNumber;
    private String faculty;
    private String speciality;

    public Department(String title, String telephoneNumber, String faculty, String speciality) {
        this.title = title;
        this.telephoneNumber = telephoneNumber;
        this.faculty = faculty;
        this.speciality = speciality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Кафедра:" +
                "\n" + "Название: " + title +
                ",\n" + "Номер телефона: " + telephoneNumber +
                ",\n" + "Факультет: " + faculty +
                "\n" + speciality.toString();
    }
}
