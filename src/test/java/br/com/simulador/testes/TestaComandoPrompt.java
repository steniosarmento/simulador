package br.com.simulador.testes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Teste de execuçãoo de comando no prompt.
 * 
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.testes
 * 
 */

public class TestaComandoPrompt {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Hora: " + dtf.format(now));

		String s = null;

		try {

			String[] cmd;
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				cmd = new String[] {"cmd.exe", "/c", "dir"};
			} else {
				cmd = new String[] {"/bin/bash", "-c", "ls"};
			}
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

			System.out.println("Aqui é a saída do comando:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}

			System.out.println("\n");
			System.out.println("Aqui é o erro do comando (se houver):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

			System.exit(0);
		} catch (IOException e) {
			System.out.println("Exception - Aqui está o log: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}