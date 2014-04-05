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
		Fragata fragata = new Fragata();
		Torpedeiro torpedeiro = new Torpedeiro();
		Submarino submarino = new Submarino();
		
		//insere navios no campo
		//altera o valor objetos
		while(campo.insereNavio(porta) == false);
		campo.addObjetosCampo(porta.getTamanho());
		for (int i = 0; i < 2; i++) {
			while(campo.insereNavio(destroyer) == false);
			campo.addObjetosCampo(destroyer.getTamanho());
			while(campo.insereNavio(fragata) == false);
			campo.addObjetosCampo(fragata.getTamanho());
		}
		for (int i = 0; i < 3; i++) {
			while(campo.insereNavio(torpedeiro) == false);
			campo.addObjetosCampo(torpedeiro.getTamanho());
		}
		for (int i = 0; i < 5; i++) {
			while(campo.insereNavio(submarino) == false);
			campo.addObjetosCampo(submarino.getTamanho());
		}
		
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
				mensagem.acertou("SUBMARINO");
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				pontos.acerto();
				break;
			case 2:
				mensagem.acertou("TORPEDEIRO");
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				
				pontos.acerto();
				break;
			case 3:
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				mensagem.acertou("FRAGATA");
				pontos.acerto();
				break;
			case 4:
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				mensagem.acertou("DESTROYER");
				pontos.acerto();
				break;
			case 5:
				
				visao.alteraCampo('O', linha, coluna);
				pontos.disparo();
				campo.insereAlvejado(linha, coluna);
				mensagem.acertou("PORTA-AVIÕES");
				pontos.acerto();
				break;
			default:
				mensagem.erro1();
				
				System.exit(0);
				
			}//fim switch
			mensagem.totalPontos(pontos.getPontos());
			
			visao.imprimeCampo();
			
			
		}//fim while
		
		System.out.println("Jogo encerrado!");
		
		sc.close();
		System.exit(0);
		
		
	}

}
