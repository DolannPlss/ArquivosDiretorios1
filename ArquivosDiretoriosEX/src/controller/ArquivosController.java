package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	public void verificaDirTemp() throws IOException {
		File f = new File("C:\\TEMP");
		if (f.exists()) {

		} else {
			f.mkdir();
		}

	}

	public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
		File arq = new File("C:\\TEMP", arquivo);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains(Integer.toString(codigo))) {
					buffer.close();
					leitor.close();
					fluxo.close();
					return true;
				} else {

				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return false;

		} else {
			throw new IOException("arquivo invalido");
		}

	}

	public void imprimeCadastro(String arquivo, int codigo) throws IOException {
		File arq = new File("C:\\TEMP", arquivo);
		int i = 0;
		if (verificaRegistro(arquivo, codigo) == true) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains(Integer.toString(codigo))) {
					String[] arrOfStr = linha.split(";", -2);
					for (String a : arrOfStr) {
						if (i == 0) {
							System.out.println("Código: " + a);
						}
						if (i == 1) {
							System.out.println("Nome: " + a);
						}
						if (i == 2) {
							System.out.println("Email: " + a);
						}
						i++;
					}
				} else {

				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			System.out.println("codigo nao encontrado");
		}

	}

	public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
		File arq = new File("C:\\TEMP", arquivo);
		StringBuffer buffer = new StringBuffer();
		Boolean existe = true;
		String cadastro = codigo + ";" + nome + ";" + email;
		if (arq.exists() && arq.isFile()) {
			if (verificaRegistro(arquivo, codigo) == false) {
				buffer.append(cadastro);
			}
			FileWriter filewriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(filewriter);
			print.write("\n" +cadastro);
			print.flush();
			print.close();
			filewriter.close();
		} else {
			throw new IOException("Diretorio Invalido");
		}
	}
}
