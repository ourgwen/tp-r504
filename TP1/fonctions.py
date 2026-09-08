def puiss(a, b):
    if type(a) is not int or type(b) is not int:
        raise TypeError("Only integers are allowed")

    if a == 0 and b < 0:
        raise ValueError("Undefined operation")

    resultat = 1

    for i in range(abs(b)):
        resultat = resultat * a

    if b < 0:
        resultat = 1 / resultat

    return resultat

