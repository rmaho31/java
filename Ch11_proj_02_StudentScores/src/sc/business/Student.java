package sc.business;

public class Student implements Comparable{
	private String fname;
	private String lname;
	private int score;
	
	public Student(String lname, String fname, int score) {
		this.fname = fname;
		this.lname = lname;
		this.score = score;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		if(getLname().compareToIgnoreCase(s.getLname()) == 0) {
			return this.getFname().compareToIgnoreCase(s.getFname());
		} else {
			return this.getLname().compareToIgnoreCase(s.getLname());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return lname + ", " + fname + ": " + score;
	}
}
