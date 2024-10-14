package exercicio1;
import java.util.Scanner;

public class Main {
	//Função que calcula o total em dias
	static int calculaEmDias(int anos, int meses, int dias) {
		int totalEmDias = anos * 365 + meses * 30 + dias;
		return totalEmDias;
	}
	
	//Função main
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite sua idade:");
		
		System.out.println("Quantos anos você tem? ");
		int anos = ler.nextInt();
		
		System.out.println("Alem de da quantidade de anos, quantos meses?");
		int meses = ler.nextInt();
		
		System.out.println("E por fim, quantos dias?");
		int dias = ler.nextInt();
		
		System.out.printf("%d anos, %d meses e %d dias = %d dias.", anos, meses, dias ,calculaEmDias( anos, meses, dias));
		}

}
