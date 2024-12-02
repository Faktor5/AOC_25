from functools import reduce

with open('./In/1.input', 'r') as file:
    lines = file.readlines()

data = [str.strip(li).split('   ') for li in lines if len(str.strip(li)) > 0]
data = [(d[0], d[1]) for d in data]

ll,rl = list(zip(*data))
sl = [int(i) for i in sorted(ll)]
sr = [int(i) for i in sorted(rl)]

distances = [abs(pair[0] - pair[1]) for pair in list(zip(sl,sr))]
distance = reduce(lambda x, y: x + y, distances)

print(distance)