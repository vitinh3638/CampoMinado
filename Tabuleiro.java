package victor.campoMinado.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;



public class Tabuleiro implements CampoObserver {
	
	private int Linhas;
	private int Colunas;
	private int Minas;
	public boolean concluido = false;
	
	private List<TabuleiroObserver> myObservers = new ArrayList<>();
	private List<Campo> campos = new ArrayList<>();
	private List<Consumer<Boolean>> observers = new ArrayList<>();
	
	public Tabuleiro(int L, int C, int M){
		this.Linhas = L;
		this.Colunas = C;
		this.Minas = M;
		
		
		for(int i = 1; i < (L + 1); i++) {
			for(int j = 1; j < (C + 1); j++) {
				Campo aux = new Campo(i, j);
				campos.add(aux);
			}
		}
		//System.out.print(campos.size());
	}
	
	public void paraCada(Consumer<Campo> funcao) {
		campos.stream().forEach(funcao);
	}
	
	public void registrarComoObserver() {
		for(int i = 0; i < this.campos.size(); i++) {
			this.campos.get(i).registrarObservador(this);
		}
	}
	
	public void registrarObserver(Consumer<Boolean> observador) {
		observers.add(observador);
	}
	
	public void definirVizinhos() {
		for(int i = 0; i < campos.size(); i++) {
			Campo aux1 = campos.get(i); 
			for(int j = 0; j < campos.size(); j++) {
				Campo aux2 = campos.get(j);
				aux1.adicionarVizinho(aux2);
			}
		}
		this.campos.stream().forEach(c -> c.quantasBombas());
	}
	
	public void minar() {
		long totalDeMinas = campos.stream().filter(e -> e.isMina()).count();
		
		while(totalDeMinas != this.Minas) {
			int c = (int) (Math.random() * campos.size());
			campos.get(c).minar();
			totalDeMinas = campos.stream().filter(e -> e.isMina()).count();
		}
	}
	
	public void objetivoAlcancado() {
		if(campos.stream().allMatch(c -> c.objetivoAlcancado())) {			
			this.concluido = true;
		} //verifica para cada campo se o objetivo foi alcancado,
		// caso sim marca que o jogo foi concluido
	}
	
	public void reiniciarT() {
		//paraCada(c -> c.reiniciar());
		//this.minar();
		//this.definirVizinhos();
		//this.registrarComoObserver();
		
		this.notificarObservador();
	}
		
	public void notificarObserver(boolean resultado) {
		observers.stream().forEach(o -> o.accept(resultado));
	}
	
	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		if(evento == CampoEvento.EXPLODIR) {
			notificarObserver(false);// notifica o view que perdeu
		}
		else {
			this.objetivoAlcancado();
			if(this.concluido) {
				notificarObserver(true);// notifica o view que ganhou
			}
		}
	}
	
	public int getLinhas() {
		return this.Linhas;
	}
	
	public int getColunas() {
		return this.Colunas;
	}
	
	public int getMinas() {
		return this.Minas;
	}
	
	public void setLinhas(int L) {
		this.Linhas = L;
	}
	
	public void setColunas(int C) {
		this.Colunas = C;
	}
	
	public void setMinas(int M) {
		this.Minas = M;
	}
	
	public void NovoTamanho() {
		this.campos.clear();
		
		for(int i = 1; i < (this.Linhas + 1); i++) {
			for(int j = 1; j < (this.Colunas + 1); j++) {
				Campo aux = new Campo(i, j);
				campos.add(aux);
				
			}
		}
	}
	
	public void registrarObservador(TabuleiroObserver observer) {
		myObservers.add(observer);
	}
	
	private void notificarObservador() {
		myObservers.stream().forEach(o -> o.ReinicioOcorreu(this.Linhas,
											this.Colunas, this.Minas));
	}
	
}


