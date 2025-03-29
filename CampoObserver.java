package victor.campoMinado.logic;

@FunctionalInterface
public interface CampoObserver {
	public void eventoOcorreu(Campo campo, CampoEvento evento);
}
