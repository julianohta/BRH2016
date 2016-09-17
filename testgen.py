import random
import math


with open("data.csv", "w") as text_file:
    time = 0

    for x in xrange(20):
        divider = ","

        v = 80 + (math.sin(x*math.pi/1440)+1)*30 + random.uniform(0, 10)

        v = 1/v*60000
        time += v/1000

        text_file.write("%s,%s \n" % (time, v))