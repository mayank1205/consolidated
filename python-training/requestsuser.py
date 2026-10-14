import requests

a = requests.get('https://api.github.com')
print(a.json())  # Output: 200