count = 0
def increment(num):
    global count
    count += 1
    return num + 1

increment(5)
increment(5)
increment(5)
increment(5)
increment(5)
print(count)