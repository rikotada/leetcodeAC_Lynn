package testTest;

public class TestPerson {
	
	class Person{
		String name;
		int age;
		
		Person(String name,int age){
			this.name = name;
			this.age = age;
		}
		
		public boolean compareTo(Person p1) {
			if(p1.name.equals(this.name) && p1.age == this.age) {
				return true;
			}
			return false;
		}
	}
	
	Person p1 = new Person("Mary",15);
	Person p2 = new Person("Rose",18);
	boolean result = p2.compareTo(p1);
	
	
	

}
