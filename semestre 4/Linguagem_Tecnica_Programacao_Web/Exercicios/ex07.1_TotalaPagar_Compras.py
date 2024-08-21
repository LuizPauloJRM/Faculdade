# Listas de comidas e preços correspondentes
comidas = ['pizza', 'sushi', 'hamburger', 'salada']
preco = [24, 29, 15, 4]

# Inicializando o total a pagar
total = 0

# Iterando sobre os índices das listas para exibir os itens e seus preços
for i in range(len(comidas)):
    print(f'{comidas[i]}: R$ {preco[i]} reais')
    total += preco[i]

# Exibindo o total a pagar
print(f'Total a pagar: R$ {total} reais')
