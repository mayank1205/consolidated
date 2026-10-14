a = input("Enter a day of the week: ").lower()

match a:
    case "sunday":
        print("It's the weekend!")
    case "saturday":
        print("It's the weekend!")
    case _:
        print("It's not the weekend.")