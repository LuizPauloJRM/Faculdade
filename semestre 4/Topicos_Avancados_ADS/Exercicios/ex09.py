

'''
	Faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
•	"Telefonou para a vítima?"
•	"Esteve no local do crime?"
•	"Mora perto da vítima?"
•	"Devia para a vítima?"
•	"Já trabalhou com a vítima?" 
O programa deve no final emitir uma classificação sobre a participação da pessoa no crime. 
Se a pessoa responder positivamente a 2 questões ela 
deve ser classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassino".
Caso contrário, ele será classificado como "Inocente".
Função para fazer uma pergunta e obter a resposta do usuário
'''
def fazer_pergunta(pergunta):
    resposta = input(pergunta + " (s/n): ").strip().lower()
    return resposta == 's'
def classificar_participacao(respostas_positivas):
    if respostas_positivas == 5:
        return "Assassino"
    elif 3 <= respostas_positivas <= 4:
        return "Cúmplice"
    elif respostas_positivas == 2:
        return "Suspeita"
    else:
        return "Inocente"
perguntas = [
    "Telefonou para a vítima?",
    "Esteve no local do crime?",
    "Mora perto da vítima?",
    "Devia para a vítima?",
    "Já trabalhou com a vítima?"
]
respostas_positivas = 0
for pergunta in perguntas:
    if fazer_pergunta(pergunta):
        respostas_positivas += 1
classificacao = classificar_participacao(respostas_positivas)
print(f"Classificação: {classificacao}")
