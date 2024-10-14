package exercicio2;

public class CalculaMediaDasMedias {
	private CalculaMedia media1;
	private CalculaMedia media2;
	
	public CalculaMediaDasMedias(CalculaMedia media1, CalculaMedia media2){
		this.media1 = media1;
		this.media2 = media2;
	}
	
	public double calculaMediaDasMedias() {
		return (media1.calculaMedia()+media2.calculaMedia())/2;
	}
}