import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

public class Identify extends JFrame{
  private static JButton enter_btn=new JButton("Enter");
  private static JButton exit_btn=new JButton("Exit");
  private static JTextField sid_text= new JTextField(7);
  private static JLabel sid_label=new JLabel("Student ID number: ");
  private Student student;
  private Sign sign;

  public Identify(Sign sign){
    this.sign=sign;
    createInteractors();
    setTitle("Identify student");
    setSize(800,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void createInteractors(){
    MyListener listen= new MyListener();

    Panel pnl1=new Panel();
    Panel pnl2=new Panel();
    add(pnl1, BorderLayout.CENTER);
    add(pnl2, BorderLayout.SOUTH);

    pnl1.add(sid_label);

    sid_text.setDocument(new JTextFieldLimit(7));
    sid_text.setActionCommand("Enter");
    sid_text.addActionListener(listen);
    pnl1.add(sid_text);

    enter_btn.addActionListener(listen);
    pnl1.add(enter_btn);

    exit_btn.addActionListener(listen);
    pnl2.add(exit_btn);
  }

  public class JTextFieldLimit extends PlainDocument {
    private int limit;
    JTextFieldLimit(int limit) {
      super();
      this.limit = limit;
    }
    @Override
    public void insertString( int offset, String  str, AttributeSet attr) throws BadLocationException{
      if (str == null) return;

      if ((getLength() + str.length()) <= limit) {
        super.insertString(offset, str, attr);
      }
    }
  }
  //make specific action listener

  public class MyListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e){
      //when click enter or pressed "return"
      if(e.getSource()==enter_btn || e.getSource()==sid_text){
        //get the input ID nnumber in the text field
        int id=Integer.parseInt(sid_text.getText());
        //sign in
        student=sign.getStudent(id);
        if(student!=null){
          dispose();
          ModifyFrame modifyFrame=new ModifyFrame(student, sign);
          modifyFrame.setVisible(true);
        }
      }
      else if(e.getSource()==exit_btn){
        dispose();
        MainFrame mainFrame=new MainFrame();
      }
    }
  }
}
