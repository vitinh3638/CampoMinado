package victor.campoMinado.view;

import javax.swing.JFrame;

import victor.campoMinado.logic.Tabuleiro;
import victor.campoMinado.logic.TabuleiroObserver;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame implements TabuleiroObserver{
	
	private Tabuleiro t;
	private PainelTabuleiro Painel;
	private Menu menu;
	
	TelaPrincipal(){
		t = new Tabuleiro(20, 20, 40);
		t.minar();
		t.definirVizinhos();
		t.registrarComoObserver();
		t.registrarObservador(this);
		menu = new Menu(t);
		t.registrarObserver(j ->{
			if(j.booleanValue()) {
				menu.setTitle("Você Venceu!");
				menu.setVisible(true);
			}
			else {
				t.paraCada(c -> c.abrir());
				menu.setTitle("Você Perdeu!");
				menu.setVisible(true);
			}
		});
		
		this.Painel = new PainelTabuleiro(t);
		
		add(Painel);
		
		setVisible(true);
		setSize(1180, 680);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Campo Minado 2");
		setLocationRelativeTo(null);
		
	}
	
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}

	@Override
	public void ReinicioOcorreu(int L, int C, int M) {
		
		this.Painel.removeAll();
		this.menu.removeAll();
		
//		this.t = new Tabuleiro(L, C, M);
		this.t.minar();
		this.t.definirVizinhos();
		this.t.registrarComoObserver();
//		this.t.registrarObservador(this);
		
		
		this.menu = new Menu(t);
		this.t.registrarObserver(j ->{
			if(j.booleanValue()) {
				menu.setTitle("Você Venceu!");
				menu.setVisible(true);
			}
			else {
				this.t.paraCada(c -> c.abrir());
				menu.setTitle("Você Perdeu!");
				menu.setVisible(true);
			}
		});
		
		
		this.Painel = new PainelTabuleiro(this.t);
		
		add(Painel);
		
		setVisible(true);
		setSize(1180, 680);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Campo Minado 2");
		setLocationRelativeTo(null);
		
	}

}
