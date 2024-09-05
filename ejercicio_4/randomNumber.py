import random


file = open("numbers.txt", "w")
for i in range(1000):
	new_line = str(random.randint(1,1000)) + "\n" 
	file.write(new_line)
file.close()
