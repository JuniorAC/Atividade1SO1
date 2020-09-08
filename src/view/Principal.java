package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	
	public static void main(String[] args) {
		RedesController redesC = new RedesController();
		String os = System.getProperty("os.name");//pega SO utilizado
		int op=0;
		
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1 - IP" + "\n2 - Ping" + "\n99 - Sair"));

			switch(op){
			case 1:
				redesC.ip(os);
				break;
			case 2:
				redesC.ping(os);
				break;
			
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;	
			default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
			}
		}
	
	
	}
}
