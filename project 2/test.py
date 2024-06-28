import sys

# Assigning small integers to variables
x = 280132948348892475747575729375927598723957237598725798327597327598732597235975987325973259875973259210804922090285080254
y = 2801329483488924757475757293759275987239572375987257983275973275987325972359759873259732598759732592108049220902850802540476024

# Getting memory addresses of x and y
addr_x = id(x)
addr_y = id(y)

# Getting sizes of x and y in memory
size_x = sys.getsizeof(x)
size_y = sys.getsizeof(y)

# Output memory addresses and sizes
print("Memory address of x:", addr_x)
print("Memory address of y:", addr_y)
print("Size of x in memory:", size_x, "bytes")
print("Size of y in memory:", size_y, "bytes")

# Checking if x and y refer to the same object
if addr_x == addr_y:
    print("x and y refer to the same object.")
else:
    print("x and y refer to different objects.")
