package exercicio2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite os valores de \"a\", \"b\" e \"c\" ao qual a primeira media deve ser calculada: ");
		int a = ler.nextInt();
		int b = ler.nextInt();
		int c = ler.nextInt();
		System.out.println("Digite os valores de \"d\", \"e\" e \"f\" ao qual a primeira media deve ser calculada: ");
		int d = ler.nextInt();
		int e = ler.nextInt();
		int f = ler.nextInt();
		ler.close();
		
		CalculaMedia valoresCalculaMedia1 = new CalculaMedia(a, b, c);
		CalculaMedia valoresCalculaMedia2 = new CalculaMedia(d,e,f);
		
		double media1 = valoresCalculaMedia1.calculaMedia();
		double media2 = valoresCalculaMedia2.calculaMedia();
		
		System.out.printf("Media entre %d, %d, %d = %.2f\n",a,b,c,media1);
		System.out.printf("Media entre %d, %d, %d = %.2f\n",d,e,f,media2);
		
		CalculaSomaDasMedias valoresCalculaSomaDasMedias = new CalculaSomaDasMedias(valoresCalculaMedia1,valoresCalculaMedia2);
		double somaDasMedias = valoresCalculaSomaDasMedias.calculaSomaDasMedias();
		
		System.out.printf("A soma das médias é igual a: %.2f\n",somaDasMedias);
	
		CalculaMediaDasMedias valoresCalculaMediaDasMedias = new CalculaMediaDasMedias(valoresCalculaMedia1,valoresCalculaMedia2);
		double mediaDasMedias = valoresCalculaMediaDasMedias.calculaMediaDasMedias();
		
		System.out.printf("A média entre as meéias é igual a : %.2f", mediaDasMedias);
	}

}
