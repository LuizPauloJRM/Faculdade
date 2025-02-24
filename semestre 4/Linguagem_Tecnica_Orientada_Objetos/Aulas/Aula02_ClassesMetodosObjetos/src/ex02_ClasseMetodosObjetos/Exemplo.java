package ex02_ClasseMetodosObjetos;
public class Exemplo {
	private double resultado;//Atributo da classe 
	public void soma() {
		double n1,n2;
		n1=6;
		n2=7;
		resultado = n1+n2;
		System.out.println(n1+" + "+n2+" = "+resultado);
	}
	public void subtracao() {
		double s1,s2;
		s1=20;
		s2=12;
		resultado=s1-s2;
		System.out.print(s1+" - "+s2+" = " +resultado);
	}
}
