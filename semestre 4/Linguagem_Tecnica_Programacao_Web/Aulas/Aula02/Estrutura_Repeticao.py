lista= [2,5,3,0,-1,50,15,19,25]
print(lista)

# Ordenando a lista em ordem crescente
for num in lista : 
    print(num)
for cont in range (1,11):
    print(cont)
while True : 
    
    # Entrada de dados
    num = int(input("Digite um numero inteiro: "))
    
    # Verificando se o número está na lista
    if num in lista:
        print(f"O numero {num} foi encontrado na lista.")
        break
    else:
        print("O numero não foi encontrado na lista.")