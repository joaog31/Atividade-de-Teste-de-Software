package application;

import br.com.meujogo.LutaDeDados;

public class Program {

	public static void main(String[] args) {

		LutaDeDados ldd = new LutaDeDados();
			
		System.out.println("jogo começou!\n");
		while (ldd.getJogador1Vida() > 0 && ldd.getJogador2Vida() > 0) {
			System.out.println(ldd.turno(15, 15));
			System.out.println(ldd.verificarVencedor());
		}

	}

}
