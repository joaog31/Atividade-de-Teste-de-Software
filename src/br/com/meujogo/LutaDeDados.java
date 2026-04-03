package br.com.meujogo;

import java.util.Random;

public class LutaDeDados {
	int jogador1Vida = 250;
	int jogador2Vida = 250;
	Random dado = new Random();

	public LutaDeDados() {
	}

	public int getJogador1Vida() {
		return jogador1Vida;
	}

	public int getJogador2Vida() {
		return jogador2Vida;
	}

	private int lancarDados() {
		return dado.nextInt(1, 7);
	}

	public String turno(int danoJogador1, int danoJogador2) {
		int danoDoTurnoJogador1 = danoJogador1 + lancarDados();
		int danoDoTurnoJogador2 = danoJogador2 + lancarDados();

		jogador1Vida = jogador1Vida - danoDoTurnoJogador2;
		jogador2Vida = jogador2Vida - danoDoTurnoJogador1;

		return "Jogador 1 causou: " + danoDoTurnoJogador1 + "  de dano." + "\nJogador 2 causou: " + danoDoTurnoJogador2
				+ " de dano.\n" + "Vida atual do jogador1: " + jogador1Vida + "\n" + "Vida atual do jogador2: "
				+ jogador2Vida + "\r";
	}

	public String verificarVencedor() {
		if (jogador1Vida <= 0 && jogador2Vida <= 0) {
			return "É um empate!\r";
		} else if (jogador1Vida <= 0) {
			return "O jogador 2 Venceu!\r";
		} else if (jogador2Vida <= 0) {
			return "O jogador 1 Venceu!\r";
		} else {
			return "E o jogo continua...\r";
		}
	}

}
