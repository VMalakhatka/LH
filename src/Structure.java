public class Structure {
    private int lexHours;
    private int labHours;
    private int pracHours;
    private String examType;

    public Structure(int lexHours, int labHours, int pracHours, String examType) {
        this.lexHours = lexHours;
        this.labHours = labHours;
        this.pracHours = pracHours;
        this.examType = examType;
    }

    public int getLexHours() {
        return lexHours;
    }

    public void setLexHours(int lexHours) {
        this.lexHours = lexHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public int getPracHours() {
        return pracHours;
    }

    public void setPracHours(int pracHours) {
        this.pracHours = pracHours;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    @Override
    public String toString() {
        return "Структура дисциплины" +
                "\n" + "Лекционные часы: " + lexHours +
                ",\n" + "Лабораторныей часы: " + labHours +
                ",\n" + "Практические часы: " + pracHours +
                ",\n" + "Вид отчетности: " + examType;
    }
}
