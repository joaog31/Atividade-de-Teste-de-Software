package br.com.meujogo;

import java.util.Objects;
import java.util.Random;

public class LutaDeDados {
	private int jogador1Vida;
	private int jogador2Vida;
	private final Random dado;

	private static final int VIDA_INICIAL = 250;

	public LutaDeDados() {
		this(new Random(), VIDA_INICIAL, VIDA_INICIAL);
	}

	LutaDeDados(Random dado, int jogador1Vida, int jogador2Vida) {
		this.dado = Objects.requireNonNull(dado, "dado nao pode ser nulo");
		this.jogador1Vida = jogador1Vida;
		this.jogador2Vida = jogador2Vida;
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
