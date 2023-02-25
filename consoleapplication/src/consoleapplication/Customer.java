package consoleapplication;
import java.util.*;
class Customer
{
    int id;
    String name;
    String password;
    int age;
    char gender;
    Customer(int id,String name,String password,int age)
    {
        this.id=id;
        this.name=name;
        this.password=password;
        this.age=age;
       
    }
	private int getId() {
		return id;
	}
	private String getName() {
		return name;
	}
	private String getPassword() {
		return password;
	}
	private int getAge() {
		return age;
	}
	private char getGender() {
		return gender;
	}
}

 
	

		
	



