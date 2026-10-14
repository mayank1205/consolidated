public class EmployeeBuilder {

	public static void main(String[] args) {
        Employee employee = new Employee.Builder()
                .name("new employee")
                .salary(20000.00)
                .address("indore")
                .departmentId(1)
                .build();
        System.out.println("Employee Name: " + employee.name);
        System.out.println("Employee salary: " + employee.salary);
        System.out.println("Employee address: " + employee.address);
        System.out.println("Employee departmentId: " + employee.departmentId);
    }

}

class Employee {
	String name;
	Double salary;
	String address;
	int departmentId;
	
	public Employee(Builder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.salary = builder.salary;
		this.departmentId = builder.departmentId;
	}
	
	public static class Builder {
	
		String name;
		Double salary;
		String address;
		int departmentId;
	
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder salary(Double salary) {
			this.salary = salary;
			return this;
		}
		
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		
		public Builder departmentId(int departmentId) {
			this.departmentId = departmentId;
			return this;
		}
		
		public Employee build() {
			return new Employee(this);
		}
	
	}
}