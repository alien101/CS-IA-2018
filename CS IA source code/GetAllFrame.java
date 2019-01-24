import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GetAllFrame extends JFrame{
    private static JButton exit_btn=new JButton("Exit");
    private Sign sign;

    public GetAllFrame(Sign sign){
      this.sign=sign;
      createInteractors();
      setTitle("Overall Late Result");
      setSize(500,400);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
    }

    public void createInteractors(){
      MyListener listener=new MyListener();
      String text= sign.getAll();
      JTextArea area= new JTextArea(text);
      area.setEditable(false);
      add(area,BorderLayout.CENTER);
      Panel pnl=new Panel();
      pnl.add(exit_btn);
      add(pnl, BorderLayout.SOUTH);
      exit_btn.addActionListener(listener);
    }
    public class MyListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit_btn){
          dispose();
          MainFrame mainFrame=new MainFrame();
        }
      }
    }

}
