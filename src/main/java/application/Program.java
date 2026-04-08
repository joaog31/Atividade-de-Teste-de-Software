package application;

import java.util.logging.Logger;

import br.com.meujogo.LutaDeDados;

public class Program {

	private static final Logger LOGGER = Logger.getLogger(Program.class.getName());

	public static void main(String[] args) {

		LutaDeDados ldd = new LutaDeDados();

		LOGGER.info("jogo começou!\n");
		while (ldd.getJogador1Vida() > 0 && ldd.getJogador2Vida() > 0) {
			LOGGER.info(ldd.turno(15, 15));
			LOGGER.info(ldd.verificarVencedor());
		}

	}

}
