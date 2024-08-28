#Faça um programa que pergunte o preço de três produtos e informe qual produto você deve comprar, 
# sabendo que a decisão é sempre pelo mais barato.
produto1 = input("Digite o nome do primeiro produto: ")
preco1 = float(input(f"Digite o preço do {produto1}: "))
produto2 = input("Digite o nome do segundo produto: ")
preco2 = float(input(f"Digite o preço do {produto2}: "))
produto3 = input("Digite o nome do terceiro produto: ")
preco3 = float(input(f"Digite o preço do {produto3}: "))
if preco1 <= preco2 and preco1 <= preco3:
    print(f"O produto mais barato é: {produto1} que custa R$ {preco1:.2f}")
elif preco2 <= preco1 and preco2 <= preco3:
    print(f"O produto mais barato é: {produto2} que custa R$ {preco2:.2f}")
else:
    print(f"O produto mais barato é: {produto3} que custa R$ {preco3:.2f}")
