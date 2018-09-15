package acount;

public class AnimalCounterApp {

	public static void main(String[] args) {
		System.out.println("Counting Alligators \n");
		Alligator a1 = new Alligator();
		count(a1, 3);
		
		System.out.println("Counting Sheep\n");
		Sheep s1 = new Sheep("Blackie");
		count(s1, 2);
		Sheep s2 = null;
		try {
			s2 = (Sheep) s1.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Cloning machine malfunction!\n");
		}
		s2.setName("Dolly");
		count(s2, 2);
		count(s1,1);
	}
	
	public static void count(Countable c, int maxcount) {
		while(maxcount > 0) {
			maxcount--;
			c.incrementCount();
			System.out.println(c.getCountString());
		}
		c.resetCount();
		System.out.println();
	}
}
