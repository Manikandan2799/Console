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
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
}

 
	

		
	



