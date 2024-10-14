package exercicio2;

public class CalculaMedia {
	private int valor1,valor2,valor3;
	public CalculaMedia() {
		
	}
	public CalculaMedia(int valor1,int valor2,int valor3) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
	}
	public int getValor1(int valor1) {
		return valor1;
	}
	public int getValor2(int valor2) {
		return valor2;
	}
	public int getValor3(int valor3) {
		return valor3;
	}
	public double calculaMedia() {
		return (valor1+valor2+valor3)/3.0;
	}
}
