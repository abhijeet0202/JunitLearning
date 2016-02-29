package abhijeet.constructor;

public class Student {
 
 private String name;
   
  
 public Student(){
	
 }
 
 public Student(String name){
	  this.name = name;
	 }
  
 public String getName() {
  return name;
 }
  
 public void setName(String name) {
  this.name = name;
  
  Marks m1 = new Marks(24);
  m1.setMarks(12);
 }
 
 public void setNameMultiple(String name) {
	  this.name = name;
	  
	  Marks m1 = new Marks(24);
	  m1.setMarks(12);
	  Marks m2 = new Marks("abhijeet");
	  Marks m3 = new Marks(12.2);
	  System.out.println(m1.i);
	  System.out.println(m2.i);
	  System.out.println(m3.i);
	 }
}