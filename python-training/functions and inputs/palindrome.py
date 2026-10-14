text = input("Enter a string to check palindrome: ")

if text.lower() == text.lower()[::-1]:
    print("The string is a palindrome.")
else:
    print("The string is not a palindrome.")