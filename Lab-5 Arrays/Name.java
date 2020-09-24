package lab5;

public class Name {
	public String fullname;
	private String fname;
	private String mname;
	private String lname;
	
	Name (String name) {
		this.fullname = name;
		
		// if delimeter is ; then order is normal
		if (name.contains(",")) {
			String[] result = name.split(",");
			fname = result[0];
			mname = result[1];
			lname = result[2];
		}
		// if the delimiter is ; then the order is lname, mname and fname
		else {
			String[] result = name.split(";");
			fname = result[2];
			mname = result[1];
			lname = result[0];
		}
		
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
}
