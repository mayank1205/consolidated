name = "maYaNk" #strings are immutable in python

# name[0] = "M" #this will give an error because strings are immutable


print(len(name)) #length of string
print(name.upper()) #convert to upper case
print(name.lower()) #convert to lower case
print(name.capitalize()) #capitalize the first letter
print(name.title()) #capitalize the first letter of each word
print(name.strip()) #remove whitespace from the beginning and end
print(name.lstrip()) #remove whitespace from the beginning
print(name.rstrip()) #remove whitespace from the end
print(name.replace("maYaNk", "Joshi")) #replace a string with another string
print(name.split("a")) #split a string into a list of strings
print(",".join(name.split("a")))
print(name.find("a")) #find the index of a string
print(name.index("a")) #find the index of a string
print(name.count("a")) #count the number of occurrences of a string


print(name)
print(name.startswith("m")) #check if a string starts with a string
print(name.endswith("k")) #check if a string ends with a string
print(name.isalpha()) #check if a string is alphabetic
print(name.isdigit()) #check if a string is numeric
print(name.isalnum()) #check if a string is alphanumeric
print(name.islower()) #check if a string is lowercase
print(name.isupper()) #check if a string is uppercase