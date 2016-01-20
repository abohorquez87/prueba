package pe.gob.mimp.sispoi.util;

import java.util.ArrayList;

public class Parametro {

	private ArrayList<ArrayList<String>> parametros;
	
	public Parametro() {
		parametros = new ArrayList<ArrayList<String>>();
	}

	public ArrayList<ArrayList<String>> getParametros() {
		return parametros;
	}

	public void setParametros(ArrayList<ArrayList<String>> parametros) {
		this.parametros = parametros;
	}
	
	public void adicionar(String campo, String valor)
	{
		ArrayList<String> parametro = new ArrayList<String>();
		parametro.add(campo);
		parametro.add(valor);
		
		getParametros().add(parametro);
	}
}
