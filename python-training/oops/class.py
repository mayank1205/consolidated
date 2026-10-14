#class: a class is a blueprint for creating objects. It defines a set of attributes and methods that the created objects will have. Classes allow for encapsulation, inheritance, and polymorphism in object-oriented programming.


#object: an object is an instance of a class. It is a specific implementation of the class blueprint, with its own unique state and behavior. Objects can interact with each other and can be used to model real-world entities in programming.


class Employee:
    company = "ABC Corp"  # class attribute

    def getSalary(self):
        return 10000  # method to get salary


e = Employee()  # creating an object of the Employee class
print(e.company)  # accessing class attribute
print(e.getSalary())  # calling method to get salary