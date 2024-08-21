#Informe  o produto comida..., e a precificação de cada item
#Obter o comprimento (ou tamanho) de uma sequência ou coleção. 
# Isso inclui strings, listas, tuplas, dicionários, conjuntos, entre outros. 
# A função retorna um valor inteiro 
# Representa o número de itens na coleção ou o número de caracteres em uma string.
comidas = ['pizza', 'sushi', 'hamburger', 'salada']
preco = [24,29,15,4]
for i in range(len(comidas)):
    print(f'{comidas[i]} R$ {preco[i]} reais')