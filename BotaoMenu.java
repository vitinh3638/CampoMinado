package victor.campoMinado.logic;

import java.util.ArrayList;
import java.util.List;

public class BotaoMenu {
	
	public String displayText;
	
	public final BotaoMenuEvento meuEvento;
	
	private List<BotaoMenuObserver> observers = new ArrayList<>();
	
	public BotaoMenu(BotaoMenuEvento e){
		this.meuEvento = e;
	}
	
	public void registrarObservador(BotaoMenuObserver observer) {
		observers.add(observer);
	}
	
	private void notificarObservers(BotaoMenuEvento evento) {
		observers.stream().forEach(o -> o.eventoOcorreu(evento));
	}
	
	public void CliqueMouse() {
		notificarObservers(this.meuEvento);
	}
	
}
