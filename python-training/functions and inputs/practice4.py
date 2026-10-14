def greet():
    print("Hello, Pythod Learner!")

def square(num):
    return num * num

def fullName(first, last):
    return first + " " + last

def area(length, width = 10):
    return length * width

add = lambda x, y: x + y

greet()
print(square(5))  # Output: 25
print(fullName("John", "Doe"))  # Output: John Doe
print(area(5))  # Output: 50
print(area(5, 20))  # Output: 100
print(add(5, 10))  # Output: 15

list1 = [1,2,3,4,5]
print(list(map(square, list1)))


def sum_of_digits(n):
    if n == 0:
        return 0
    else:
        return n % 10 + sum_of_digits(n // 10)

print(sum_of_digits(81319))  # Output: 6