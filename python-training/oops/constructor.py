class Employee:
    def __init__(self, name, salary, bond):
        self.name = name
        self.salary = salary
        self.bond = bond

    def getSalary(self):
        return self.salary  # method to get salary

    def getBond(self):
        return self.bond  # method to get bond

    def getName(self):
        return self.name  # method to get name
    
    def getDetails(self):
        return f"Name: {self.name}, Salary: {self.salary}, Bond: {self.bond} years"  # method to get all details


e = Employee("Mayank", 10000, 2)  # creating an object of the Employee class    
print(e.getDetails())  # calling method to get all details