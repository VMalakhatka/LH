import javax.swing.*;
import java.awt.*;



public class Main  extends JFrame {
    static DBHandling dbHandling = new DBHandling();

    static JTextArea area;

    public static void main(String[] args) {
      // dbHandling.open();
       // dbHandling.selectMinMaxDis();
       dbHandling.open();
//        Main main = new Main("Информационная система");
//        main.pack();
//        main.setSize(800, 700);
//        main.setVisible(true);
    }

    public Main(String title) {
        super(title);
        setResizable(false);

        JMenuBar menuList = new JMenuBar();
        JMenu menu1 = new JMenu("Специальность");
        JMenuItem item1 = new JMenuItem("Дисциплины");
        JMenuItem item2 = new JMenuItem("Часы лабораторных работ");
        JMenuItem item3 = new JMenuItem("Нагрузка кафедры");
        item1.addActionListener(new MyActionListener());
        item2.addActionListener(new MyActionListener());
        item3.addActionListener(new MyActionListener());
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);
        menuList.add(menu1);

        JMenu menu2 = new JMenu("Дисциплины");
        JMenuItem item4 = new JMenuItem("На выбранной кафедре");
        JMenuItem item5 = new JMenuItem("Минимальная и максимальная продолжительность");
        item4.addActionListener(new MyActionListener());
        item5.addActionListener(new MyActionListener());
        menu2.add(item4);
        menu2.add(item5);
        menuList.add(menu2);

        JMenu menu3 = new JMenu("Экзамены и зачеты");
        JMenuItem item6 = new JMenuItem("На заданной кафедре");
        item6.addActionListener(new MyActionListener());
        menu3.add(item6);
        menuList.add(menu3);
        JMenu menu4 = new JMenu("Управление");
        JMenuItem item7 = new JMenuItem("Добавить");
        item7.addActionListener(new MyActionListener());
        menu4.add(item7);
        menuList.add(menu4);
        setJMenuBar(menuList);

        Label label = new Label("Cпециальность");
        Label label1 = new Label("Кафедра");
        Label label2= new Label("Дисциплина");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 0));

        panel.add(label);
        panel.add(label1);
        panel.add(label2);

        JPanel comboPanel = new JPanel();

        JComboBox<String> combo1 = new JComboBox<>();
        for(int i = 0 ; i < dbHandling.getSpecialities().size(); i++) {
            combo1.addItem(dbHandling.getSpecialities().get(i));
        }
        combo1.addActionListener(new MyActionListener());
        combo1.setFont(new Font("Serif", Font.BOLD, 20));
        comboPanel.add(combo1);

        JComboBox<String> combo2 = new JComboBox<>();
        for(int i = 0 ; i < dbHandling.getDepartments().size(); i++) {
            combo2.addItem(dbHandling.getDepartments().get(i));
        }
        combo2.setFont(new Font("Serif", Font.BOLD, 20));
        comboPanel.add(combo2);

        JComboBox<String> combo3 = new JComboBox<>();
        for(int i = 0 ; i < dbHandling.getDisciplines().size(); i++) {
            combo3.addItem(dbHandling.getDisciplines().get(i));
        }
        combo3.setFont(new Font("Serif", Font.BOLD, 20));
        comboPanel.add(combo3);
        comboPanel.add(combo1);
        comboPanel.add(combo2);
        comboPanel.add(combo3);

        area = new JTextArea(38, 77);
        JPanel areaPanel = new JPanel();
        areaPanel.add(comboPanel);
        areaPanel.add(new JScrollPane(area));

        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);
        mainPanel.add(comboPanel);
        mainPanel.add(areaPanel);

        setContentPane(mainPanel);
    }
}
