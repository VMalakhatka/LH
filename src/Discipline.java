import java.util.ArrayList;

public class Discipline {
    private String title;
    private String semester;
    private ArrayList<String> specialities;
    private Structure structure;

    public Discipline(String title, String semester, int lexHours, int labHours,
                      int pracHours, String examType, ArrayList<String> spec) {
        this.title = title;
        this.semester = semester;
        structure = new Structure(lexHours, labHours, pracHours, examType);
        specialities = spec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(ArrayList<String> specialities) {
        this.specialities = specialities;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "Дисциплина: \n" +
                "Название:'" + title + '\'' +
                ",\n" + "Семестр:'" + semester + '\'' +
                ",\n" +  "Специальности: " + specialities + "\n" + structure.toString();
    }
}
