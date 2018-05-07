import java.util.ArrayList;
import java.util.Scanner;

import Exceprions.InvalidCastException;
import Exceprions.InvalidMathException;
import Exceprions.MenuItemSelectionException;

public class Main {
	
	private static int[] menuItems = new int[] {1, 2};
	
	private static int toInt(String s) throws InvalidCastException {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			throw new InvalidCastException("The value '" + s + "' cannot be converted to int");
		}
	}
	
	private static int getMenuItemSelection(int i) throws MenuItemSelectionException {
		int r = -1;
		for(int x : menuItems) {
			if(x == i) {
				r = i;
				break;
			}
		}
		
		if(r < 0) {
			throw new MenuItemSelectionException("No such menu item ('" + i + "')");
		}
		return r;
	}
	
	public static void main(String[] args) {
		
		try {
			ArrayList<Manager> mgrs = SerializeManager.DeserializeCollection();
			
			Scanner sc = new Scanner(System.in);
			
			boolean loop = true;
			while (loop) {
				try {
					System.out.print("Menu: " + menuItems[0] + " - Enter manager, " + menuItems[0] + " - Perform task: ");
					String input = sc.nextLine();
					
					int mi = getMenuItemSelection(toInt(input));
					
					if(mi == menuItems[0]) {
						System.out.print("Enter name : ");
						String name = sc.nextLine();
						
						System.out.print("Enter age : ");
						String a = sc.nextLine();
						int age = toInt(a);
						
						System.out.print("Enter performance (1 or 0) : ");
						String p= sc.nextLine();
						boolean performance = false;
						if(toInt(p) == 1) {
							performance = true;
						}
						Manager m = new Manager(name, age, performance);
						mgrs.add(m);
					}
					
					try {
						if(mi == menuItems[1]) {
							loop = false;
							
							int pCount = 0;
							float totalAge = 0;
							System.out.println();
							for(Manager m : mgrs) {
								System.out.println("Name: " + m.Name + " age: " + m.Age + " performance: "
										 + m.Performance);
								
								if(m.Performance) {
									pCount++;
								}
								totalAge += m.Age;
							}
							
							if(mgrs.size() > 0) {
								totalAge = totalAge / mgrs.size(); 
							}
							
							System.out.println();
							System.out.println("Count of managers which have good performance: " + pCount);
							System.out.println("Middle age: " + totalAge);
						}
					} catch (Exception e) {
						throw new InvalidMathException(e.getMessage());
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			sc.close();
			SerializeManager.SerializeCollection(mgrs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
