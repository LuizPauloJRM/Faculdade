#Tem vogais na frase'A-E-I-O-U / a-e-i-o-u'
vogais = 'AEIOUaeiou'
frase = input('Digite qualquer frase: ')
total_vogais = 0 

for letra in frase: 
    if letra in vogais:
        total_vogais += 1

print('TOTAL DE VOGAIS:', total_vogais)

