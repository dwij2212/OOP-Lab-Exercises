package lab5;

class StudentList { 
	public static Student[] list = new Student[10]; 
	// list of students 
	public static int count =0;
	// count of students added in the list 
	public static void addStudent(Student std) { 
		// if count is already 20 or more then return
		if(count>= 20) 
			return; 
		 
		list[count] = std; 
		count++; 
		}
	public static Student[] getStudentsWithAge(int age) {
		/* This method returns all the students whose age
		 *  is equal to age parameter of this method. If no 
		 *  such student is found then it returns null. */ 
		// Write Your Code From Here 
		
		//creating an array of 10 students since linked lists have
		// not yet been covered
		
		Student[] result = new Student[10];

		int j = 0;
		for (int i = 0; list[i] != null; i++) {
			if(list[i].getAge() == age) {
				result[j] = list[i];
				j++;
			}
		}
		
		if (j == 0) {
			return null;
		}
		
		else {
			return result;
		}
	} 
	public static Student[] getStudentsWithLastName(String lastName) { 
		/* This method returns all the students whose last
		 *  name attribute value matches with lastName parameter 
		 *  of this method. If no such students is found then
		 *   it returns null. */ // Write Your Code From Here
		//creating an array of 10 students since linked lists have
				// not yet been covered
				Student[] result = new Student[10];
				int j = 0;
				for (int i = 0; list[i] != null; i++) {
					if(list[i].getName().getLname().equals(lastName)) {
						result[j] = list[i];
						j++;
					}
				}
				
				if (j == 0) {
					return null;
				}
				
				else {
					return result;
				}
		} 
	public static Student[] getStudentsInRange(int minAge, int maxAge) { 
		/* This method returns all the students whose age 
		 * falls between minAge and maxAge (both parameters inclusive)
		 *  */ // Write Your Code From Here 
		
		//creating an array of 10 students since linked lists have
		// not yet been covered
		Student[] result = new Student[10];
		int j = 0;
		for (int i = 0; list[i] != null; i++) {
			if(list[i].getAge() <= maxAge && list[i].getAge() >= minAge) {
				result[j] = list[i];
				j++;
			}
		}
		
		if (j == 0) {
			return null;
		}
		
		else {
			return result;
		}
		}
}

