from collections import Counter

def sortFunc(str):
    freq = Counter(str)  # count frequencies
    freq_arr = sorted(freq.items(), key= lambda lst: (-lst[1], lst[0]))
    output = "".join(char * count for char, count in freq_arr)

    print(output)

sortFunc("football")