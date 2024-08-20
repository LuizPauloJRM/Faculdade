#Verificar se o numero esta na lista de 10 números 
lista = 1,2,6,8,10,3,9,2,7,5
num=int(input('Voce quer verificar qual número , DIGITE um número inteiro : '))
for i in range(num):
    if num in lista:
        print(f'O numero {num} esta na lista.')
        break
    else:
        print(f'O numero {num} não esta na lista.')
        break