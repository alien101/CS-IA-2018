import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;



public class SignFrame extends JFrame{
    private static JButton enter_btn=new JButton("Enter");
    private static JButton end_btn=new JButton("End Sign In");
    private static JButton exit_btn=new JButton("Exit");
    private static JTextField sid_text= new JTextField(7);
    private static JLabel sid_label=new JLabel("Your student ID number: ");
    private Sign sign;

    public SignFrame(Sign sign){
      this.sign=sign;
      createInteractors();
      setTitle("Sign In");
      setSize(500,400);
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

      end_btn.addActionListener(listen);
      pnl2.add(end_btn);

      exit_btn.addActionListener(listen);
      pnl2.add(exit_btn);

    }

    //make the maximum word count of the text field to be seven
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
      private JFrame frame;

      @Override
      public void actionPerformed(ActionEvent e){
        //when click enter or pressed "return"
        if(e.getSource()==enter_btn || e.getSource()==sid_text){
          //get the input ID nnumber in the text field
          int id=Integer.parseInt(sid_text.getText());
          //sign in
          sign.signIn(id);
          //clear out the text field for new input
          sid_text.setText("");
        }
        //when click end
        else if(e.getSource()==end_btn){
          //stop students from signing in & create late list
          sign.endSign();
          setVisible(false);
          frame=new JFrame("These people are not here");
          JTextArea area= new JTextArea(sign.getLateList().toString());
          area.setEditable(false);
          frame.add(area);
          frame.setSize(300,400);
          frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
          frame.setVisible(true);
          frame.add(exit_btn, BorderLayout.SOUTH);
          exit_btn.addActionListener(this);
          //clear out the list for the next sign in
          sign.clearLateList();
        }
        else if(e.getSource()==exit_btn){
          dispose();
          if(frame!=null){
            frame.dispose();
          }
          MainFrame mainFrame=new MainFrame();
        }
      }

    }

}
