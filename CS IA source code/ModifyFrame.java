import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModifyFrame extends JFrame{
  private static JButton name_btn= new JButton("Change Name");
  private static JButton status_btn= new JButton("Change late status");
  private static JButton time_btn= new JButton("Take out on late time");
  private static JButton exit_btn=new JButton("Exit");
  private Student student;
  private Sign sign;


  public ModifyFrame(Student student, Sign sign){
    this.student=student;
    this.sign=sign;
    createInteractors();
    setTitle("Modify student Information");
    setSize(800,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void createInteractors(){
      MyListener listen= new MyListener();

      Panel pnl1=new Panel();
      Panel pnl2=new Panel();
      Panel pnl3=new Panel();
      add(pnl1, BorderLayout.CENTER);
      add(pnl2, BorderLayout.SOUTH);

      name_btn.addActionListener(listen);
      pnl1.add(name_btn);

      status_btn.addActionListener(listen);
      pnl1.add(status_btn);

      time_btn.addActionListener(listen);
      pnl1.add(time_btn);

      exit_btn.addActionListener(listen);
      pnl2.add(exit_btn);

  }

  public class MyListener implements ActionListener{
    private JFrame frame=new JFrame();
    private JLabel label;
    @Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==name_btn){
        dispose();
        NameFrame nameFrame=new NameFrame(student, sign);
        nameFrame.setVisible(true);
      }
      else if(e.getSource()==status_btn){
        dispose();
        StatusFrame statusFrame=new StatusFrame(student, sign);
        statusFrame.setVisible(true);
      }
      else if(e.getSource()==time_btn){
        dispose();
        frame=new JFrame();
        if(student.getLateTime()>0){
          student.takeOffT();
          label=new JLabel("You have changed "+student.getName()+" has a total late time of "+student.getLateTime());

        }
        else{
          label=new JLabel("The student is never late, so the operation is invalid.");
        }
        frame.add(label);
        frame.add(exit_btn, BorderLayout.SOUTH);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
      }
      else if(e.getSource()==exit_btn){
        dispose();
        if(frame!=null){
          frame.dispose();
        }
        Identify identify=new Identify(sign);
        identify.setVisible(true);
      }
    }
  }
}
