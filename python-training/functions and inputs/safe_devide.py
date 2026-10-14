def safeDevide(a, b):
    """
    Safely divides two numbers, handling division by zero.

    Parameters:
    a (int or float): The numerator.
    b (int or float): The denominator.

    Returns:
    float: The result of the division if b is not zero, otherwise None.
    """
    if b == 0:
        return "Error: Division by zero is not allowed."
    else:
        return a / b

print(safeDevide(10, 2))  # Output: 5.0
print(safeDevide(10, 0))  # Output: Error: Division by zero is not allowed.