package victor.campoMinado.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import victor.campoMinado.logic.BotaoMenu;
import victor.campoMinado.logic.BotaoMenuEvento;
import victor.campoMinado.logic.BotaoMenuObserver;
import victor.campoMinado.logic.Tabuleiro;

@SuppressWarnings("serial")
public class Menu extends JFrame
implements BotaoMenuObserver{
	private Tabuleiro t;
	private int Linhas;
	private int Colunas;
	private int Minas;
	GridBagLayout layout = new GridBagLayout();
	GridBagConstraints cons = new GridBagConstraints();
	
	Menu(Tabuleiro t){
		
		this.Linhas = t.getLinhas();
		this.Colunas = t.getColunas();
		this.Minas = t.getMinas();		
		
		setLayout(layout);
		this.cons.fill = GridBagConstraints.BOTH;
		this.cons.weightx = 1;
		this.cons.weighty = 1;
		this.cons.gridheight = 1;
		this.cons.gridwidth = 1;
		
		setVisible(false);
		setSize(500, 360);
		setLocationRelativeTo(null);
		
		JButton cabeca = new JButton();
		cabeca.setBackground(new Color(225,225,225));
		String jogoAtual = 
				"Jogo atual: "+this.Linhas+
				" Linhas, "+this.Colunas+
				" Colunas, "+this.Minas+" Minas";
			
		this.cons.gridwidth = 4;
		cabeca.setText(jogoAtual);
		Font fonte = cabeca.getFont();
		cabeca.setFont(fonte);
		add(cabeca, this.cons);
		
		this.cons.gridwidth = 1;
		adicionarBotao(BotaoMenuEvento.MAIS10L, 0, 1);
		adicionarBotao(BotaoMenuEvento.MAIS1L, 1, 1);
		adicionarBotao(BotaoMenuEvento.MENOS10L, 2, 1);
		adicionarBotao(BotaoMenuEvento.MENOS1L, 3, 1);		 
		
		adicionarBotao(BotaoMenuEvento.MAIS10C, 0, 3);
		adicionarBotao(BotaoMenuEvento.MAIS1C, 1, 3);
		adicionarBotao(BotaoMenuEvento.MENOS10C, 2, 3);
		adicionarBotao(BotaoMenuEvento.MENOS1C, 3, 3);
		
		adicionarBotao(BotaoMenuEvento.MAIS10M, 0, 5);
		adicionarBotao(BotaoMenuEvento.MAIS1M, 1, 5);
		adicionarBotao(BotaoMenuEvento.MENOS10M, 2, 5);
		adicionarBotao(BotaoMenuEvento.MENOS1M, 3, 5);
		
		adicionarBotao(BotaoMenuEvento.REINICIO, 0, 6, 4, 1);

		
		this.t = t;
	}

	@Override
	public void eventoOcorreu(BotaoMenuEvento evento) {
		// TODO Auto-generated method stub
		switch(evento) {
		case MAIS10L:
			t.setLinhas(this.Linhas < 50 ? (this.Linhas + 10) : this.Linhas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MAIS10C:
			t.setColunas(this.Colunas < 50 ? (this.Colunas + 10) : this.Colunas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MAIS10M:
			t.setMinas(this.Minas < 100 ? (this.Minas + 10) : this.Minas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break; 
		case MAIS1L:
			t.setLinhas(this.Linhas < 50 ? (this.Linhas + 1) : this.Linhas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MAIS1C:
			t.setColunas(this.Colunas < 50 ? (this.Colunas + 1) : this.Colunas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MAIS1M:
			t.setMinas(this.Minas < 100 ? (this.Minas + 1) : this.Minas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break; 
		case MENOS10L:
			t.setLinhas(this.Linhas > 10 ? (this.Linhas - 10) : this.Linhas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MENOS10C:
			t.setColunas(this.Colunas > 10 ? (this.Colunas - 10) : this.Colunas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MENOS10M:
			t.setMinas(this.Minas > 10 ? (this.Minas - 10) : this.Minas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break; 
		case MENOS1L:
			t.setLinhas(this.Linhas > 5 ? (this.Linhas - 1) : this.Linhas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MENOS1C:
			t.setColunas(this.Colunas > 5 ? (this.Colunas - 1) : this.Colunas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break;
		case MENOS1M:
			t.setMinas(this.Minas > 1 ? (this.Minas - 1) : this.Minas);
			this.Linhas = t.getLinhas();
			this.Colunas = t.getColunas();
			this.Minas = t.getMinas();
			break; 
		case REINICIO:
			t.NovoTamanho();
			t.reiniciarT();
			this.setVisible(false);
			break;
		}
	}
	
	private void adicionarBotao(BotaoMenuEvento e, int x, int y,
			int wX, int wY) {
		BotaoMenu bot = new BotaoMenu(e);
		BotaoMenuView botView = new BotaoMenuView(bot, this);
		this.cons.gridx = x;
		this.cons.gridy = y;
		this.cons.gridwidth = wX;
		this.cons.gridheight = wY;
		add(botView, this.cons);
	}
	
	private void adicionarBotao(BotaoMenuEvento e, int x, int y) {
		BotaoMenu bot = new BotaoMenu(e);
		BotaoMenuView botView = new BotaoMenuView(bot, this);
		this.cons.gridx = x;
		this.cons.gridy = y;
		add(botView, this.cons);
	}
	
}
