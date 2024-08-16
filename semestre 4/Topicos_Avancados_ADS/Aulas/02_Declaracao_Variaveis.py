print("hello")
ano = 2024
nome = 'Luiz'
#Imprimir o tipo de variáveis "Type"
"""
print(type(ano))
print(type(nome))
"""
print("Hello world",ano,nome)
#Entrada de dados
nome = input("Digite seu nome : ")
ano = input ("Digite o seu ano de nascimento:")
print(f'O seu nome é {nome}, nasceu em {ano}')# f string 
#Convertendo em tipo inteiro
ano = int(input('Digite outro ano de nascimento :  '))
print(f'O outro usuário nasceu em {ano} ')
#Estruturas condicionais
if ano < 2000 : 
    print("Maior de idade")
else: 
    print("Menor de idade")
#Encadeamento if/elif
n=int(input("Digite um numero inteiro: "))
if n < 0 :
    print('Número negativo')
elif n > 0 : 
    print('Número positivo')
else: 
    print('zero')