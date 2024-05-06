package MyPack;

public class Student {

	public int rollno;
	public String name;
	public int java;
	public int sl;
	public int ls;
	public float perc;
	
	
	public Student()
	{
		rollno=0;;
		name="";
		java=0;
		sl=0;
		ls=0;
		perc=0;
	}
	
	public float percentage()
	{
		float perc;
		perc=(java+sl+ls)/3;
		return perc;
	}
}
