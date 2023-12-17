import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {

    protected JFrame window;
    protected JButton addition;
    protected JButton subtraction;
    protected JButton multiplication;
    protected JButton determinant;
    protected JPanel button_panel;
    protected ScrollingPanel mop1;
    protected ScrollingPanel mip2;
    protected ScrollingPanel mip1;
    protected int ID = 0;

    public MainWindow(){
        window = new JFrame(); // новый объект окна
        window.setTitle("Matrix calculator");
        window.setSize(1300,350); // размер окна
        window.setLocationRelativeTo(null); // появление окна в центре
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при закрытии окна программа завершается
    }
    public void buttons(){
        // создаем новые кнопки
        addition = new JButton("Addition");
        subtraction = new JButton("Subtraction");
        multiplication = new JButton("Multiplication");
        determinant = new JButton("Determinant");

        //создаем панель для отображения кнопок
        button_panel = new JPanel();
        button_panel.setLayout(null);

        //устанавливаем размеры кнопок
        addition.setBounds(10, 135, 100, 40);
        determinant.setBounds(10, 255, 100, 40);
        subtraction.setBounds(10, 175, 100, 40);
        multiplication.setBounds(10, 215, 100, 40);

        //добавляем кнопки на панель
        button_panel.add(addition);
        button_panel.add(subtraction);
        button_panel.add(multiplication);
        button_panel.add(determinant);

        //добавляем панель на основное окно
        window.getContentPane().add(button_panel);
    }

    public void output(){
        //создаем новый экз класса панели
        mop1 = new ScrollingPanel(false, "output panel");
        //задаем ему размер
        mop1.setBounds(950, 10, 300, 300);
        //добавляем на окно
        window.add(mop1);
        mop1.visible(false);
    }

    public void input(){
        mip1 = new ScrollingPanel(true, "input panel 1");
        mip1.setBounds(150, 10, 300, 300);
        window.add(mip1);
        mip1.visible(false);

        mip2 = new ScrollingPanel(true, "input panel 2");
        mip2.setBounds(550, 10, 300, 300);
        window.add(mip2);
        mip2.visible(false);
    }
    public void show(){
        // отображаем кнопки и панели
        this.output();
        this.input();
        this.buttons();
        //метод для отображения окна
        window.setVisible(true);
    }

    public void listener(){
        addition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = 1;
                mop1.visible(true);
                mip1.visible(true);
                mip2.visible(true);
                //System.out.println(ID);
            }
        });

        subtraction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = 2;
                mop1.visible(true);
                mip1.visible(true);
                mip2.visible(true);
                //System.out.println(ID);
            }
        });

        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = 3;
                mop1.visible(true);
                mip1.visible(true);
                mip2.visible(true);
                //System.out.println(ID);
            }
        });

        determinant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ID = 4;
                mop1.visible(true);
                mip1.visible(true);
                mip2.visible(false);
                //System.out.println(ID);
            }
        });

        mop1.run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ID == 1){
                    int matrix1[][];
                    int matrix2[][];
                    try {
                        matrix1 = Matrix.text_to_matrix(mip1.area.getText());
                        matrix2 = Matrix.text_to_matrix(mip2.area.getText());
                        mop1.clear();
                        mop1.area.append(Matrix.matrix_to_text(Matrix.sum(matrix1, matrix2)));
                    }catch(Exception exc){
                        mop1.clear();
                        mop1.area.append(exc.getLocalizedMessage() + "\n");
                        mop1.area.append("Invalid Matrix.\nMatrix should be m by n,\nentries should be separated by space,\nand there should be no extra empty lines.");
                    }
                }else if(ID == 2){
                    int matrix1[][];
                    int matrix2[][];
                    try {
                        matrix1 = Matrix.text_to_matrix(mip1.area.getText());
                        matrix2 = Matrix.text_to_matrix(mip2.area.getText());
                        mop1.clear();
                        mop1.area.append(Matrix.matrix_to_text(Matrix.substract(matrix1, matrix2)));
                    }catch(Exception exc) {
                        mop1.clear();
                        mop1.area.append(exc.getLocalizedMessage() + "\n");
                        mop1.area.append("Invalid Matrix.\nMatrix should be m by n,\nentries should be separated by space,\nand there should be no extra empty lines.");
                    }
                }else if(ID == 3){
                    int matrix1[][];
                    int matrix2[][];

                    try {
                        matrix1 = Matrix.text_to_matrix(mip1.area.getText());
                        matrix2 = Matrix.text_to_matrix(mip2.area.getText());
                        mop1.clear();
                        mop1.area.append(Matrix.matrix_to_text(Matrix.multiplication(matrix1, matrix2)));
                    }catch(Exception exc) {
                        mop1.clear();
                        mop1.area.append(exc.getLocalizedMessage() + "\n");
                        mop1.area.append("Invalid Matrix.\nMatrix should be m by n,\nentries should be separated by space,\nand there should be no extra empty lines.");
                    }
                } else if (ID == 4) {
                    int matrix1[][];
                    try {
                        matrix1 = Matrix.text_to_matrix(mip1.area.getText());
                        mop1.clear();
                        mop1.area.append(String.valueOf(Matrix.matrixDeterminant(matrix1)));
                    }catch(Exception exc) {
                        mop1.clear();
                        mop1.area.append(exc.getLocalizedMessage() + "\n");
                        mop1.area.append("Invalid Matrix.\nMatrix should be n by n,\nentries should be separated by space,\nand there should be no extra empty lines");
                    }
                }
            }
        });

        mip1.load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mip1.load_file();
            }
        });

        mip2.load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mip2.load_file();
            }
        });

    }
}

