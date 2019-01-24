import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatusFrame extends JFrame{
  private JButton true_btn =new JButton("Late");
  private JButton false_btn =new JButton("Not Late");
  private JButton exit_btn=new JButton("Exit");
  private Student student;
  private Sign sign;

  public StatusFrame(Student student, Sign sign){
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
    add(pnl1, BorderLayout.CENTER);
    add(pnl2, BorderLayout.SOUTH);



    true_btn.addActionListener(listen);
    pnl1.add(true_btn);

    false_btn.addActionListener(listen);
    pnl1.add(false_btn);

    exit_btn.addActionListener(listen);
    pnl2.add(exit_btn);

  }
  public class MyListener implements ActionListener{
    private JLabel label;
    public void actionPerformed(ActionEvent e){
      JFrame frame=new JFrame("Succeed");
      if(e.getSource()==true_btn || e.getSource()==false_btn){
        if(e.getSource()==true_btn){
          student.setLate(true);
          label=new JLabel("You have now changed student "+ student.getName()+ " to be late.");
        }
        else{
          student.setLate(false);
          label=new JLabel("You have now changed student "+ student.getName()+ " to be here on time.");
        }
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
