package victor.campoMinado.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import victor.campoMinado.logic.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{
	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		
	}
}
