import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeManager {
	
	public static void SerializeCollection(ArrayList<Manager> mgrs) {
		try {
			FileOutputStream fos = new FileOutputStream("temp.out");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mgrs);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<Manager> DeserializeCollection() {
		ArrayList<Manager> r = new ArrayList<Manager>();
		
		try {
			FileInputStream fis = new FileInputStream("temp.out");
			ObjectInputStream oin = new ObjectInputStream(fis);
			r = (ArrayList<Manager>) oin.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return r;
	}

}
