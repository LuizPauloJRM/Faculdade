#Faça um programa que lê as duas notas parciais obtidas por um aluno numa disciplina ao longo de um semestre,
# e calcule a sua média. A atribuição de conceitos obedece à tabela abaixo:
#Média de Aproveitamento	Conceito
#Entre 9.0 e 10.0	A
#Entre 7.5 e 9.0	B
#Entre 6.0 e 7.5	C
#Entre 4.0 e 6.0	D
#Entre 4.0 e zero	E
class Aluno:
    def __init__(self, nota1, nota2):
        self.nota1 = nota1
        self.nota2 = nota2

    def calcular_media(self):
        return (self.nota1 + self.nota2) / 2

    def atribuir_conceito(self, media):
        if 9.0 <= media <= 10.0:
            return 'A : Aprovado'
        elif 7.5 <= media < 9.0:
            return 'B : Aprovado'
        elif 6.0 <= media < 7.5:
            return 'C : Aprovado'
        elif 4.0 <= media < 6.0:
            return 'D : Recuperação'
        elif 0 <= media < 4.0:
            return 'E : Reprovado'
        else:
            return 'Nota inválida'

nota1 = float(input("Digite a primeira nota: "))
nota2 = float(input("Digite a segunda nota: "))

aluno = Aluno(nota1, nota2)

media = aluno.calcular_media()
conceito = aluno.atribuir_conceito(media)

print(f"Média do aluno: {media:.2f}")
print(f"Classificação: {conceito}")
9