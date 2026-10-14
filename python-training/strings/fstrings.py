template = "Dear {}, You are awesome, take this {}$ bag"

a = "John"
a1 = 10000
b = "Jack"
b1 = 20000
c = "Mary"
c1 = 30000

s1 = template.format(a, a1)
s2 = template.format(b, b1)
s3 = template.format(c, c1)
print(s1)
print(s2)
print(s3)

print(f"Dear {a}, You are awesome, take this {a1}$ bag")
print(f"Dear {b}, You are awesome, take this {b1}$ bag")
print(f"Dear {c}, You are awesome, take this {c1}$ bag")