
public class Calculator {
	int num1;
	int num2;
	
	public Calculator() {
		int num1 = 0;
		int num2 = 0;
	}

	/**
	 * @return the num1
	 */
	public int getNum1() {
		return num1;
	}

	/**
	 * @param num1 the num1 to set
	 */
	public void setNum1(int num1) {
		this.num1 = num1;
	}

	/**
	 * @return the num2
	 */
	public int getNum2() {
		return num2;
	}

	/**
	 * @param num2 the num2 to set
	 */
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public int add() {
		return num1 + num2;
	}
	
	public int subtract() {
		return num1 - num2;
	}
	
}
