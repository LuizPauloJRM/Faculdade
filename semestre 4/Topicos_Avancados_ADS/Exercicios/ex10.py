'''
Uma fruteira está vendendo frutas com a seguinte tabela de preços:
                               Até 5 Kg                Acima de 5 Kg
Morango         R$ 2,50 por Kg          R$ 2,20 por Kg
Maçã                R$ 1,80 por Kg          R$ 1,50 por Kg
Se o cliente comprar mais de 8 Kg em frutas ou o valor total da compra ultrapassar R$ 25,00, receberá ainda um desconto de 10% sobre este total. Escreva um algoritmo para ler a quantidade (em Kg) de morangos e a quantidade (em Kg) de maças adquiridas e escreva o valor a ser pago pelo cliente.

'''
# Solicita ao usuário a quantidade de morangos e maçãs em Kg
kg_morangos = float(input("Digite a quantidade de morangos em Kg: "))
kg_macas = float(input("Digite a quantidade de maçãs em Kg: "))

# Calcula o preço dos morangos
if kg_morangos <= 5:
    preco_morangos = kg_morangos * 2.50
else:
    preco_morangos = kg_morangos * 2.20

# Calcula o preço das maçãs
if kg_macas <= 5:
    preco_macas = kg_macas * 1.80
else:
    preco_macas = kg_macas * 1.50

# Calcula o valor total da compra
valor_total = preco_morangos + preco_macas
if (kg_morangos + kg_macas > 8) or (valor_total > 25):
    valor_total *= 0.90  # Aplica o desconto de 10%

# Exibe o valor a ser pago pelo cliente
print(f"Valor total a ser pago: R$ {valor_total:.2f}")
