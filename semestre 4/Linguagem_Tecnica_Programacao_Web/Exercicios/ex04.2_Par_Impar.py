lista=[]
for num in range(4):
    lista.append(int(input('Digite um número: ')))#Append adiconar 
    par=0
    impar=0
    #Verificar a lista para cada número dentro da lista 
    
    for num in lista:
        if int(num) % 2 == 0:
            par += 1
        else:
            impar += 1
    print(lista)
    print(f'Números pares: {par}, Números ímpares: {impar}')