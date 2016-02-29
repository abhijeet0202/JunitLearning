package abhijeet.constructor;

public class Marks {
	int i = 10;
	
	Marks(int i){
		System.out.println("Hello i am");
	}
	
	Marks(String str){
		System.out.println("Hello i str");
	}
	
	Marks(double lng){
		System.out.println("Hello i lng");
	}
	void setMarks(int i){
		this.i =i;
	}
	

}
