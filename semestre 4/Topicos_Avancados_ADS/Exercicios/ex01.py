
# Criar uma  lista e inicializar com os valores a seguir
#lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, 60, 60, -20, -20]
#imprimir a lista
#exibir a lista na ordem inversa
#exibir o menor numero da lista
#exibir o maior numero da lista
#exibir o total de numeros da lista
#exibir a soma da lista
#exibir a media dos numeros da lista
#exibir quantas vezes o numero -20 apareceu na lista
lista = [10,20,30,20,20,30,40, 50,-20,-20] 
print(lista)
#Ordem inversa
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
lista.reverse()
print(lista)
#Outra forma
#lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
#lista_inversa = lista[::-1]
#print(lista_inversa)
#Menor número da lista
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
menor_numero = min(lista)
print(menor_numero)
#Maior numero da lista 
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
maior_numero = max(lista)
print(maior_numero)
#Total numero da lista
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
total_numero = len(lista)
print(total_numero)
#Soma da lista
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
soma_numeros = sum(lista)
print(soma_numeros)
#Media 
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
media = sum(lista) / len(lista)
print(media)
#Quantas vezes "-20" aparece na lista 
lista = [10, 20, 30, 20, 20, 30, 40, 50, -20, -20]
quantidade = lista.count(-20)
print(quantidade)


