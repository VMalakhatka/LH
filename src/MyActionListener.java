import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    static String selectedDepartment;
    static String selectedSpeciality;
    static String selectedDiscipline;

    DBHandling dbHandling = new DBHandling();
    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        try {JComboBox<String> combo = (JComboBox)e.getSource();
            if(e.getSource() == combo){
                label = combo.getSelectedItem().toString();
                for(int i = 0; i < DBHandling.specialities.size(); i++){
                    if(label.equals(DBHandling.specialities.get(i))){
                        selectedSpeciality = DBHandling.specialities.get(i);
                    }
                }
                for(int i = 0; i < DBHandling.disciplines.size(); i++){
                    if(label.equals(DBHandling.disciplines.get(i))){
                        selectedDiscipline = DBHandling.disciplines.get(i);
                    }
                }
                for(int i = 0; i < DBHandling.departments.size(); i++){
                    if(label.equals(DBHandling.departments.get(i))){
                        selectedDepartment = DBHandling.departments.get(i);
                    }
                }
            }
        }
        catch (Exception ex){

        }

        if(label.equals("Добавить")){
            AddWindow addWindow = new AddWindow("Добавление");
            addWindow.pack();
            addWindow.setSize(800, 500);
            addWindow.setResizable(false);
            addWindow.setVisible(true);
        }
        if(label.equals("Дисциплины")){
            dbHandling.selectВDisciplines();

        }

        if(label.equals("Часы лабораторных работ")){
            dbHandling.selectLabHours();
        }

        if(label.equals("Нагрузка кафедры")){
            dbHandling.selectDepHours();
        }

        if(label.equals("На выбранной кафедре")){
            dbHandling.selectDepartmentDis();
        }

        if(label.equals("Минимальная и максимальная продолжительность")){
            dbHandling.selectMinMaxDis();
        }

        if(label.equals("На заданной кафедре")){
            dbHandling.controlQuantity();
        }
    }

}
