package br.com.meujogo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LutaDeDadosTest {

	private LutaDeDados luta;

	@BeforeEach
	void setUp() {
		luta = new LutaDeDados();
	}

	@Test
	void testeInicializacao() {
		assertEquals(250, luta.getJogador1Vida());
		assertEquals(250, luta.getJogador2Vida());
	}

	@Test
	void testeDanoNoTurno() {
		luta = new LutaDeDados(new Random() {
			@Override
			public int nextInt(int origin, int bound) {
				return 6;
			}
		}, 250, 250);

		luta.turno(10, 20);

		assertEquals(224, luta.getJogador1Vida());
		assertEquals(234, luta.getJogador2Vida());
	}

	@Test
	void testeVitoriaJogador1() {
		luta = new LutaDeDados(new Random() {
			@Override
			public int nextInt(int origin, int bound) {
				return 1;
			}
		}, 10, 0);

		assertEquals("O jogador 1 Venceu!\r", luta.verificarVencedor());
	}

	@Test
	void testeDerrotaJogador1() {
		luta = new LutaDeDados(new Random() {
			@Override
			public int nextInt(int origin, int bound) {
				return 1;
			}
		}, 0, 10);

		assertEquals("O jogador 2 Venceu!\r", luta.verificarVencedor());
	}

	@Test
	void testeEmpate() {
		luta = new LutaDeDados(new Random() {
			@Override
			public int nextInt(int origin, int bound) {
				return 1;
			}
		}, 0, -5);

		assertEquals("É um empate!\r", luta.verificarVencedor());
	}

	@Test
	void testeJogoEmAndamento() {
		assertEquals("E o jogo continua...\r", luta.verificarVencedor());
	}

	@Test
	void testeMetodoLancarDadosPorComportamentoDoTurno() {
		luta = new LutaDeDados(new Random() {
			@Override
			public int nextInt(int origin, int bound) {
				return 6;
			}
		}, 250, 250);

		luta.turno(0, 0);

		assertEquals(244, luta.getJogador1Vida());
		assertEquals(244, luta.getJogador2Vida());
	}
}
