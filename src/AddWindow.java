import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AddWindow extends JFrame {
    static String strDisciplineName;
    static String strSemester;
    static String strSpeciality;
    static String strLexHours;
    static String strLabHours;
    static String strPracHours;
    static String strExamType;
    static String strPhoneNuber;
    static String strDepartmentName;
    static String strCode;
    static String strSpecName;
    static String strQualification;
    static String strForm;
    static String strDisciplines;
    static String strFaculty;


    public AddWindow(String title) {
        super(title);
        JTextField disciplineName = new JTextField(18);        // Название дисциплины
        JTextField semester = new JTextField(14);
        JTextField speciality = new JTextField(18);            // Специальность
        JTextField lexHours = new JTextField(20);
        JTextField labHours = new JTextField(22);
        JTextField pracHours = new JTextField(18);
        JTextField examType = new JTextField(20);
        JTextField phoneNumber = new JTextField(22);         //Телефон кафедры
        JTextField departmentName = new JTextField(18);      //Название кафедры
        JTextField code = new JTextField(20);
        JTextField specName = new JTextField(22);           // ---
        JTextField qualification = new JTextField(18);
        JTextField form = new JTextField(22);
        JTextField disciplines = new JTextField(18);
        JTextField faculty = new JTextField(20);
        DBHandling dbHandling = new DBHandling();

        JLabel label1 = new JLabel("Введите название дисциплины");
        JLabel label2 = new JLabel("Введите номер семестра");
        JLabel label3 = new JLabel("Введите название специальности");
        JLabel label4 = new JLabel("Введите кол-во лекционных часов");
        JLabel label5 = new JLabel("Введите кол-во лабораторных часов");
        JLabel label6 = new JLabel("Введите кол-во практических часов");
        JLabel label7 = new JLabel("Введите вид отчетности                 ");
        JLabel label8 = new JLabel("Введите номер телефона              ");
        JLabel label9 = new JLabel("Введите название кафедры    ");
        JLabel label10 = new JLabel("Введите код профессии                  ");
        JLabel label11= new JLabel("Введите название профессии                ");
        JLabel label12 = new JLabel("Введите квалификацию");
        JLabel label13= new JLabel("Введите форму обучения                       ");
        JLabel label14 = new JLabel("Введите изучаемые дисциплины         ");
        JLabel label15 = new JLabel("Введите название факультета         ");
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 20));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(disciplineName);
        panel.add(semester);
        panel.add(speciality);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(lexHours);
        panel.add(labHours);
        panel.add(pracHours);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(examType);
        panel.add(phoneNumber);
        panel.add(departmentName);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);
        panel.add(code);
        panel.add(specName);
        panel.add(qualification);
        panel.add(label13);
        panel.add(label14);
        panel.add(label15);
        panel.add(form);
        panel.add(disciplines);
        panel.add(faculty);


        JButton addBtn1 = new JButton("Добавить кафедру");
        addBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strDisciplineName =  disciplineName.getText();
                strSemester = semester.getText();
                strSpeciality = speciality.getText();
                strLexHours = lexHours.getText();
                strLabHours = labHours.getText();
                strPracHours = pracHours.getText();
                strExamType = examType.getText();
                strPhoneNuber = phoneNumber.getText();
                strDepartmentName = departmentName.getText();
                strCode = code.getText();
                strSpecName = specName.getText();
                strQualification = qualification.getText();
                strForm = form.getText();
                strDisciplines = disciplines.getText();
                strFaculty = faculty.getText();
                if(dbHandling.open()){
                       dbHandling.insertDepartment();
                }
            }
        });
        panel.add(addBtn1);

        JButton addBtn2 = new JButton("Добавить дисциплину");
        addBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strDisciplineName =  disciplineName.getText();
                strSemester = semester.getText();
                strSpeciality = speciality.getText();
                strLexHours = lexHours.getText();
                strLabHours = labHours.getText();
                strPracHours = pracHours.getText();
                strExamType = examType.getText();
                strPhoneNuber = phoneNumber.getText();
                strDepartmentName = departmentName.getText();
                strCode = code.getText();
                strSpecName = specName.getText();
                strQualification = qualification.getText();
                strForm = form.getText();
                strDisciplines = disciplines.getText();
                strFaculty = faculty.getText();
                if(dbHandling.open()){
                    dbHandling.insertDiscipline();
                }
            }
        });
        panel.add(addBtn2);
        JButton addBtn3 = new JButton("Добавить специальность");
        addBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strDisciplineName =  disciplineName.getText();
                strSemester = semester.getText();
                strSpeciality = speciality.getText();
                strLexHours = lexHours.getText();
                strLabHours = labHours.getText();
                strPracHours = pracHours.getText();
                strExamType = examType.getText();
                strPhoneNuber = phoneNumber.getText();
                strDepartmentName = departmentName.getText();
                strCode = code.getText();
                strSpecName = specName.getText();
                strQualification = qualification.getText();
                strForm = form.getText();
                strDisciplines = disciplines.getText();
                strFaculty = faculty.getText();
                if(dbHandling.open()){
                    dbHandling.insertSpeciality();
                }
            }
        });
        panel.add(addBtn3);
        setContentPane(panel);

    }
}
