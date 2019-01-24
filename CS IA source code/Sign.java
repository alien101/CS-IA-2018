import java.io.*;
import java.util.*;
import javax.swing.*;


public class Sign{
  //holds the list of students who are late
  private ArrayList<String> lateList;
  //holds each student's file and can be searched by ID number
  private HashMap<Integer, Student> stuList;

  //Class Sign constructor
  public Sign(){
		try{
      stuList=new HashMap<>();
      lateList=new ArrayList<>();
  		Scanner input= new Scanner(new File ("student.txt"));
  			while(input.hasNext()){
  				Student stu = new Student(input.next(), input.nextInt(), input.next(), input.nextInt());
  				stuList.put(stu.getId(), stu);
  			}
  			input.close();
  		}
  		catch(FileNotFoundException e){
  			System.out.println("Do not find file.");
  		}
  	}

  //Method SignIn takes in student ID number to reecord that the student is present in the student's file
  public void signIn(int studentId){
    boolean valid=false;
      for(Integer id : stuList.keySet()){
        if(studentId==id){
          Student a= stuList.get(id);
          a.setLate(false);
          valid=true;
        }
      }
    //check whether the id number input is valid
    if(valid){
        valid=false;
    }
    else{
      JFrame frame=new JFrame("Invalid ID Number");
      JLabel label=new JLabel("The ID number you enter does not exist. \n Please enter again.");
      frame.add(label);
      frame.setSize(400,200);
      frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
      frame.setVisible(true);
    }
  }

  public Student getStudent(int studentId){
    for(Integer id : stuList.keySet()){
      if(studentId==id){
        Student a= stuList.get(id);
        return a;
      }
    }
    JFrame frame=new JFrame("Invalid ID Number");
    JLabel label=new JLabel("The ID number you enter does not exist. \n Please enter again.");
    frame.add(label);
    frame.setSize(400,200);
    frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
    return null;
  }

  //Method endSign stops students from beinng allowed to record
  //Make the late list
  public void endSign(){
    for (Integer id : stuList.keySet()){
        Student a= stuList.get(id);
        if(a.getLate()==true){
          lateList.add(a.getName());
          a.addLateT();
        }
        else {
          a.setLate(true);
        }
    }
  }

  //Method getLateList returns the list of students who are late
  public ArrayList getLateList(){
    return lateList;
  }

  //Method clearLateList earase the late list of that day
  public void clearLateList(){
    lateList.clear();
  }

  public HashMap getStuList(){
    return stuList;
  }

  public String getAll(){
    String text="";
    for (Integer id : stuList.keySet()){
      Student a=stuList.get(id);
      text += a.getTie()+" tie "+a.getName()+" is totally late for "+ a.getLateTime()+" times. \n";
    }
    return text;
  }
}
