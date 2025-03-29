package victor.campoMinado.logic;

import java.util.ArrayList;
import java.util.List;



public class Campo {

	private final int linha;
	private final int coluna;
	private int bombasAdjacentes;
	public String coord;
	
	private boolean aberto = false;
	private boolean mina = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();
	private List<CampoObserver> observers = new ArrayList<>();
	
	public Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
		this.coord = linha + ", " + coluna;
	}
	
	public void registrarObservador(CampoObserver observer) {
		observers.add(observer);
	}
	
	private void notificarObservers(CampoEvento evento) {
		observers.stream().forEach(o -> o.eventoOcorreu(this, evento));
	}
	
	void adicionarVizinho (Campo vizinho){
		if(Math.abs(vizinho.linha - this.linha) <= 1) {
			if(Math.abs(vizinho.coluna - this.coluna) <= 1) {
				this.vizinhos.add(vizinho);
			}
		}
	}
	
	void quantasBombas() {
		int minas = 0;
		
		for(int i = 0; i < vizinhos.size(); i++) {
			Campo vAtual = vizinhos.get(i);
			if(vAtual.mina) {
				minas += 1;
			}
		}
		this.bombasAdjacentes = minas;
	}
	
	public void alternarMarcacao() {
		if(!this.aberto) {
			this.marcado = !this.marcado;
			
			if(this.marcado) {
				notificarObservers(CampoEvento.MARCAR);
			}
			else {
				notificarObservers(CampoEvento.DESMARCAR);
			}
		}
	}
	
	public void abrir() {
		if(!this.aberto && !this.marcado) {
			this.aberto = true;
			this.setAberto();
			
			if(this.mina) {				
				notificarObservers(CampoEvento.EXPLODIR);
			}
			
			if(this.vizinhosSeguros()) {
				this.vizinhos.stream().forEach(v -> v.abrir());
			}
		}
	}	
	
	boolean vizinhosSeguros() {
		return this.vizinhos.stream().noneMatch(v -> v.mina);
	}
	
	void reiniciar() {
		aberto = false;
		mina = false;
		marcado = false;
		vizinhos.clear();
		notificarObservers(CampoEvento.REINICIAR);
	}
	
	void minar() {
		mina = true;
	}
	
	
	public boolean isMina() {
		return this.mina;
	}
	
	public boolean objetivoAlcancado() {
		if(this.mina && this.marcado) {
			return true;
		}
		else if(!this.mina && this.aberto) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setAberto() {
		if(this.aberto) {
			notificarObservers(CampoEvento.ABRIR);
		}
	}
	
	public int getMinas() {
		return bombasAdjacentes;
	}
	
}
