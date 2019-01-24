/*
Program name: Student.java
Program description: creates a student's information card
Programmer: Nerissa Lien
Version: 2/26/18
*/

public class Student{

  private String name;
  //student name

  private int id;
  //student ID number

  private String tieColor;
  //student tie color

  private int lateT;
  //Total times the student has been late

  private boolean late;
  //whether the student is currently late

  /*
    Constructor: to input student name, ID number, and tie color ahead
  */
  public Student(String tieColor, int id, String name, int lateT){
    this.name=name;
    this.id=id;
    this.tieColor=tieColor;
    this.lateT=lateT;
    late=true;
  }

  public void setName(String name){
    this.name=name;
  }
  //This method is a setter to change the late status of the student
  public void setLate(boolean status){
    late=status;
  }

  public void addLateT(){
    lateT++;
  }

  public void takeOffT(){
    lateT--;
  }

  public String getName(){
      return name;
  }

  public int getId(){
    return id;
  }

  public String getTie(){
    return tieColor;
  }

  public int getLateTime(){
    return lateT;
  }

  public boolean getLate(){
    return late;
  }
}
