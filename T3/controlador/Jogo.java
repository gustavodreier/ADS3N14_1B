package controlador;
import java.util.Scanner;

import modelo.*;
import modelo.estrutura.*;
import visao.*;

public class Jogo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mensagens mensagem = new Mensagens();
		
		VisaoCampo visao = new VisaoCampo();
		
		visao.imprimeCampo();
		
		//cria um novo campo de jogo
		CampoDados campo = new CampoDados();
		Pontos pontos = new Pontos();
		
		PortaAvioes porta = new PortaAvioes();
		Destroyer destroyer = new Destroyer();
		Destroyer destroyer1 = new Destroyer();
		Fragata fragata = new Fragata();
		Fragata fragata1 = new Fragata();
		Torpedeiro torpedeiro = new Torpedeiro();
		Torpedeiro torpedeiro1 = new Torpedeiro();
		Torpedeiro torpedeiro2 = new Torpedeiro();
		Submarino submarino = new Submarino();
		Submarino submarino1 = new Submarino();
		Submarino submarino2 = new Submarino();
		Submarino submarino3 = new Submarino();
		Submarino submarino4 = new Submarino();
		
		//insere navios no campo
		//altera o valor objetos
		while(campo.insereNavio(porta) == false);
		campo.addObjetosCampo(porta.getTamanho());
		
		while(campo.insereNavio(destroyer) == false);
		campo.addObjetosCampo(destroyer.getTamanho());
		while(campo.insereNavio(destroyer1) == false);
		campo.addObjetosCampo(destroyer1.getTamanho());
		
		while(campo.insereNavio(fragata) == false);
		campo.addObjetosCampo(fragata.getTamanho());
		while(campo.insereNavio(fragata1) == false);
		campo.addObjetosCampo(fragata1.getTamanho());
		
		
		
		while(campo.insereNavio(torpedeiro) == false);
		campo.addObjetosCampo(torpedeiro.getTamanho());
		while(campo.insereNavio(torpedeiro1) == false);
		campo.addObjetosCampo(torpedeiro1.getTamanho());
		while(campo.insereNavio(torpedeiro2) == false);
		campo.addObjetosCampo(torpedeiro2.getTamanho());
		
		
		while(campo.insereNavio(submarino) == false);
		campo.addObjetosCampo(submarino.getTamanho());
		while(campo.insereNavio(submarino1) == false);
		campo.addObjetosCampo(submarino1.getTamanho());
		while(campo.insereNavio(submarino2) == false);
		campo.addObjetosCampo(submarino2.getTamanho());
		while(campo.insereNavio(submarino3) == false);
		campo.addObjetosCampo(submarino3.getTamanho());
		while(campo.insereNavio(submarino4) == false);
		campo.addObjetosCampo(submarino4.getTamanho());
		
		
		//apos as posicoes serem criadas o jogo pode ser iniciado
		Jogada jogada = new Jogada();
		Objeto obj;
		
		Scanner sc = new Scanner(System.in);
		int linha;
		char linhaChar;
		int coluna;
		GameOver fim = new GameOver();
		
		//System.out.println("Objetos Campo = " +campo.getObjetosCampo());
		//System.out.println("Pontos = " + pontos.getPontos());
		while(fim.isGameOver(campo, pontos) == false) {
			
			mensagem.digiteLinha();
			linhaChar = sc.next().charAt(0);
			
			mensagem.digiteColuna();
			coluna = sc.nextInt();
			
			jogada.novaJogada(linhaChar, coluna);
			
			linha = jogada.getLinha();
			coluna = jogada.getColuna();
			//System.out.println(coluna);
			
			//verifica o que tem na posicao jogada
			obj = campo.getCampo(jogada.getLinha(), jogada.getColuna());
			
			//realiza as checagens e ações apartir da posição passada.
			switch (obj.getValor()) {
			case -1:
				mensagem.alvejado();
				//não deve ser descontado pontos
				break;
			case 0:
				mensagem.erro();
				visao.alteraCampo('-', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				break;
			case 1:
				
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				if (obj.estaDestruido(campo)) {
					mensagem.destruiu("SUBMARINO");
					pontos.destroi();
				} else {
					mensagem.acertou("SUBMARINO");
					pontos.acerto();
				}
					
				break;
			case 2:
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				if (obj.estaDestruido(campo)) {
					mensagem.destruiu("TORPEDEIRO");
					pontos.destroi();
				} else {
					mensagem.acertou("TORPEDEIRO");
					pontos.acerto();
				}
				break;
			case 3:
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				if (obj.estaDestruido(campo)) {
					mensagem.destruiu("FRAGATA");
					pontos.destroi();
				} else {
					mensagem.acertou("FRAGATA");
					pontos.acerto();
				}
				
				break;
			case 4:
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				if (obj.estaDestruido(campo)) {
					mensagem.destruiu("DESTROYER");
					pontos.destroi();
				} else {
					mensagem.acertou("DESTROYER");
					pontos.acerto();
				}
				
				break;
			case 5:
				
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				if (obj.estaDestruido(campo)) {
					mensagem.destruiu("PORTA-AVÕES");
					pontos.destroi();
				} else {
					mensagem.acertou("PORTA-AVÕES");
					pontos.acerto();
				}
				break;
			default:
				mensagem.erro1();
				
				System.exit(0);
				
			}//fim switch
			mensagem.totalPontos(pontos.getPontos());
			
			visao.imprimeCampo();
			
			
		}//fim while
		
		//System.out.println("Jogo encerrado!");
		mensagem.erro1();
		
		sc.close();
		System.exit(0);
		
		
	}

}
