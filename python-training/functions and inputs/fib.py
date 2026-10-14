num = int(input("Enter a number to generate fibonacci sequence up to: "))

# fibonacci using recursion
def fib(num):
    if num <= 0:
        return []
    elif num == 1:
        return [0]
    elif num == 2:
        return [0, 1]
    else:
        fib_sequence = fib(num - 1)
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])
        return fib_sequence

print(fib(num))  # Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]