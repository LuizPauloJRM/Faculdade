#Temperaturas em  graus cº  de 1 até 100 e o equivalente em Fº 
for celcius in range(1,101):
    f = celcius *1.8 + 32
    print(celcius,'Cº é de ', round(f,1), 'Fº')
    