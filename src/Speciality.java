import java.util.ArrayList;

public class Speciality {
    private String code;
    private String title;
    private String qualification;
    private String form;
    private String disciplines;

    public Speciality(String code, String title, String qualification, String form, String disciplines) {
        this.code = code;
        this.title = title;
        this.qualification = qualification;
        this.form = form;
        this.disciplines = disciplines;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Специальность: " +
                "\n"+ "Код: " + code +
                ",\n" + "Название:  " + title +
                ",\n" + "Квалификация:  " + qualification +
                ",\n" + "Форма обучения: " + form +
                ",\n" + "Дисциплины: " + disciplines;
    }
}
