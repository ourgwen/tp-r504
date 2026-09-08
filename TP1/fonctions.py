def puiss(a, b):
    if not type(a) is int:
        raise TypeError("Only integers are allowed")

    if not type(b) is int:
        raise TypeError("Only integers are allowed")

    if a == 0 and b < 0:
        raise ValueError("Undefined operation")

    res = 1

    if b >= 0:
        for i in range(b):
            res = res * a
    else:
        for i in range(-b):
            res = res * a
        res = 1 / res

    return res

