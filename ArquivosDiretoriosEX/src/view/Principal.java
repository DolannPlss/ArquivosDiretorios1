package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();
		String arquivo = "teste.csv";
		String nome = "";
		int codigo = 0;
		String email = "";
		int opc = 0;
		while (opc != 9) {
			opc =Integer.parseInt(JOptionPane.showInputDialog("1-VerificaDirTemp\n2-VerificaRegistro"
					+ "\n3-ImprimeCadastro\n4-insereCadastro\n9-Finalizar"));
			switch (opc) {
			case 1:
				try {

					arqCont.verificaDirTemp();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					codigo =Integer.parseInt(JOptionPane.showInputDialog("insira codigo"));
					System.out.println("codigo existe? " + arqCont.verificaRegistro(arquivo, codigo));

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					codigo =Integer.parseInt(JOptionPane.showInputDialog("insira codigo"));
					arqCont.imprimeCadastro(arquivo, codigo);

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					codigo =Integer.parseInt(JOptionPane.showInputDialog("insira codigo"));
					nome =(JOptionPane.showInputDialog("insira nome"));
					email =(JOptionPane.showInputDialog("insira email"));
					arqCont.insereCadastro(arquivo, codigo, nome, email);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 9:
				System.out.println("finalizando");
				break;

			default:
				break;
			}
		}
		try {

//			arqCont.verificaDirTemp();
//			System.out.println("codigo existe? "+arqCont.verificaRegistro(arquivo, codigo));
//			arqCont.imprimeCadastro(arquivo, codigo);
			arqCont.insereCadastro(arquivo, codigo, nome, email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
