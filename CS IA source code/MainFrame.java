import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
  private static JButton getLate_btn= new JButton("Get all late list");
  private static JButton sign_btn= new JButton("Sign In");
  private static JButton modify_btn= new JButton("Modify student information");
  private Sign sign=new Sign();

  public static void main(String[] args){
    MainFrame mainFrame=new MainFrame();
    /*mainFrame.createInteractors();
    mainFrame.setTitle("Main Window");
    mainFrame.setSize(800,300);
    mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
    */

  }
  public MainFrame(){
    createInteractors();
    setTitle("Main Window");
    setSize(800,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
  //set up how the interface window should look like
  public void createInteractors(){
    MyListener listener= new MyListener();
    //layout
    Panel pnl=new Panel();
    add(pnl, BorderLayout.CENTER);

    //components
    pnl.add(getLate_btn);
    getLate_btn.addActionListener(listener);

    pnl.add(sign_btn);
    sign_btn.addActionListener(listener);

    pnl.add(modify_btn);
    modify_btn.addActionListener(listener);

  }

  public class MyListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==getLate_btn){
        dispose();
        GetAllFrame getAllFrame=new GetAllFrame(sign);
        getAllFrame.setVisible(true);
        //getAllFrame.createInteractors();

      }
      else if(e.getSource()==sign_btn){
        dispose();
        SignFrame signFrame=new SignFrame(sign);
        signFrame.setVisible(true);
        //signFrame.createInteractors();
      }
      else if(e.getSource()==modify_btn){
        dispose();
        Identify identify =new Identify(sign);
        identify.setVisible(true);
        //ModifyFrame modifyFrame=new ModifyFrame();
      }
    }

  }

}
