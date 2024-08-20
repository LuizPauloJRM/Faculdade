pares = 0
impares = 0

# Solicitar ao usuário que insira os números até que digite 'sair'
while True:
    entrada = input("Digite um número (ou 'sair' para terminar): ")
    
    if entrada.lower() == 'sair':
        break
    
    try:
        num = int(entrada)
        if num % 2 == 0:
            pares += 1
        else:
            impares += 1
    except ValueError:
        print("Por favor, digite um número válido ou 'sair' para terminar.")

print(f"Números pares: {pares}")
print(f"Números ímpares: {impares}")
