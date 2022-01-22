package br.com.simulador.util;

/**
 * Declara as constantes que ser�o usadas pelo app simulador.
 * 
 * @author Stenio Sarmento
 * @version 1.0
 */
public class ConstantsSimulador {

	public static String ESTADO_S = "S";
	public static String ESTADO_F = "F";
	public static String ESTADO_P = "P";
	public static String ESTADO_E = "E";
	public static String ESTADO_S_EXT = "Solicitado";
	public static String ESTADO_P_EXT = "Em processamento";
	public static String ESTADO_E_EXT = "Processado com erro";
	public static String ESTADO_F_EXT = "Finalizado";
	public static String ESTADO_ERROR = "Estado n�o localizado";

	private ConstantsSimulador() {
		throw new AssertionError();
	}

}