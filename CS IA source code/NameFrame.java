import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;



public class NameFrame extends JFrame{
    private static JButton enter_btn=new JButton("Enter");
    private static JButton exit_btn=new JButton("Exit");
    private static JTextField sid_text= new JTextField(50);
    private static JLabel sid_label=new JLabel("Alternated Name: ");
    private Sign sign;
    private Student student;

    public NameFrame(Student student, Sign sign){
      this.sign=sign;
      this.student=student;
      createInteractors();
      setTitle("Modify Student Name");
      setSize(700,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void createInteractors(){
      MyListener listen= new MyListener();

      Panel pnl1=new Panel();
      Panel pnl2=new Panel();
      add(pnl1, BorderLayout.CENTER);
      add(pnl2, BorderLayout.SOUTH);

      pnl1.add(sid_label);

      sid_text.setActionCommand("Enter");
      sid_text.addActionListener(listen);
      pnl1.add(sid_text);

      enter_btn.addActionListener(listen);
      pnl1.add(enter_btn);

      exit_btn.addActionListener(listen);
      pnl2.add(exit_btn);
    }
    public class MyListener implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
        if(e.getSource()==enter_btn || e.getSource()==sid_text){
          String old_name=student.getName();
          String name=sid_text.getText();
          student.setName(name);
          JFrame frame=new JFrame("Succeed");
          JLabel label=new JLabel("You have now changed student "+ old_name+ " into student "+ name);
          frame.add(label);
          frame.setSize(400,200);
          frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
          frame.setVisible(true);

        }
        else if(e.getSource()==exit_btn){
          dispose();
          ModifyFrame modifyFrame=new ModifyFrame(student, sign);
          modifyFrame.setVisible(true);
        }
      }
    }
}
