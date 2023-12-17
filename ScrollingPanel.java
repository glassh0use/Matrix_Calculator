import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ScrollingPanel extends JPanel{
    private JLabel label;
    protected JTextArea area;
    private JScrollPane scroller;
    protected JButton run;
    protected JButton load;

    public void clear(){
        area.setText("");
    }
    public void visible(boolean visible){
        area.setVisible(visible);
        run.setVisible(visible);
        load.setVisible(visible);
    }

    public void get_text(){
        area.getText();
    }

    public void load_file(){
        try{
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                clear();
                FileReader fr = new FileReader(fc.getSelectedFile());
                BufferedReader br = new BufferedReader(fr);
                int i = br.read();
                while (i != -1){
                    area.append(String.valueOf((char)i));
                    i = br.read();
                }
                br.close();
                repaint();
            }
        } catch (Exception ee){
            JOptionPane.showMessageDialog(null, "Unable to load", "Fail to load", JOptionPane.ERROR_MESSAGE);
        }
    }

    ScrollingPanel(boolean editable, String name){
        label = new JLabel(name);
        area = new JTextArea(15, 25);
        scroller = new JScrollPane(area);
        run = new JButton("Run");
        load = new JButton("Load");

        if(name.contains("input")){
            add(load);
        }else{
            add(run);
        }

        area.setEditable(editable);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        add(label);
        add(scroller);
    }

}
