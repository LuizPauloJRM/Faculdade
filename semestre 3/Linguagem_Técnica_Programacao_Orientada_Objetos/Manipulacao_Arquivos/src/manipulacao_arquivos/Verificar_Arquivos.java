package manipulacao_arquivos;

import java.io.File;
import java.text.DateFormat;

public class Verificar_Arquivos {

    public static void main(String[] args) {
        File arquivo = new File("C:\\Users\\Acer\\Desktop\\Faculdade\\semestre 3\\Linguagem_Técnica_Programacao_Orientada_Objetos\\Manipulacao_Arquivos\\src\\manipulacao_arquivos");

        if (arquivo.exists()) {
            System.out.println("Arquivo existe!");
            System.out.println("Tamanho: " + arquivo.length() + " bytes");
            System.out.println("Caminho completo: " + arquivo.getAbsolutePath());
            System.out.println("Última modificação: " + arquivo.lastModified());

            DateFormat df = DateFormat.getDateTimeInstance();
            System.out.println("Última modificação formatada: " + df.format(arquivo.lastModified()));
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
