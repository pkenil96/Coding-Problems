package string;

/*
	This program reads the details of the employees from a file
	and prints it on the console in a formatted manner.
	It also writes the data in the formatted manner into a new file*/
import java.io.*;


class Employee{
	String name; 
	int age;
	String position;
	String location;

	public Employee(String name, int age, String position, String location){
		this.name = name;
		this.age = age;
		this.position = position;
		this.location = location;
	}
}

class StringJustify{
	public static void main(String[] args) {
		try{
			String line;
			
			FileReader fr = new FileReader(new File("string/employees.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			PrintStream p = new PrintStream("string/formatted_employees.txt");
			p.printf("%20s\t%20s\t%20s\t%20s\n", "Name", "Age", "Position", "Location");
			p.printf("%20s\t%20s\t%20s\t%20s\n", "----", "---", "--------", "--------");

			System.out.printf("%20s\t%20s\t%20s\t%20s\n", "Name", "Age", "Position", "Location");
			System.out.printf("%20s\t%20s\t%20s\t%20s\n", "----", "---", "--------", "--------");

			while((line = br.readLine()) != null){
				String [] employee = line.split(",");
				String name = employee[0];
				int age = Integer.parseInt(employee[1].trim());
				String position = employee[2];
				String location = employee[3];
				//writing to the console
				System.out.printf("%20s|\t%20d|\t%20s|\t%20s\n", name, age, position, location);
				p.printf("%20s\t|\t%20d|\t%20s\t%20s|\n", name, age, position, location);
			}
			fr.close();
			p.close();
		} catch(IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}
}
