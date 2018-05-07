import java.io.Serializable;

public class Manager implements Serializable {
	private static final long serialVersionUID = 1416351891L;
	
	public String Name = "";
	public int Age = 0;
	public boolean Performance = false;
	
	public Manager(String name, int age, boolean performance) {
		Name = name;
		Age = age;
		Performance = performance;
	}
	
	
}
