#Quantos números são pares e ímpares 
                    # entre 1 e 100?
pares = 0
impares = 0

for num in range(1, 25):
    if num % 2 == 0:
        pares += 1
    else: 
        impares += 1
