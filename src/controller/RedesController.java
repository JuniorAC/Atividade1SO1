package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController () {
		super();
	}
	
	public void ip(String os) {
		String testeIp = " "; 
		//escoher comando para qual SO esta usando 
		 if (os.contains("Windows")) {
			  testeIp = "ipconfig";
		  }
		  else if (os.contains("Linux")) {
			  testeIp = "ipconfig";
		  }
	    try {
			Process ip = Runtime.getRuntime().exec(testeIp);
			InputStream fluxo = ip.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
		    String linha = buffer.readLine();
		    while (linha != null) {
		    	if(linha.contains("Adaptador Ethernet")){
		    	System.out.println(linha);}
		    	else if (linha.contains("IPv4")) {
		         System.out.println(linha);	}
		    	
		    	linha = buffer.readLine();
		    }
		    buffer.close();
		    leitor.close();
		    fluxo.close();
		    
	    } catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void ping(String os) {
		String ping = " "; 
		//escoher comando para qual SO esta usando 
		 if (os.contains("Windows")) {
			  ping = "PING -t10 www.google.com.br";
		  }
		  else if (os.contains("Linux")) {
			  ping = "Ping google.com.br";
		  }
	    try {
			Process ip = Runtime.getRuntime().exec(ping);
			InputStream fluxo = ip.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
		    String linha = buffer.readLine();
		    System.out.println("Disparando www.google.com.br [172.217.29.3] com 32 bytes de dados:");
		    while (linha != null) {
		    	if (linha.contains("tempo"))
		    	System.out.println(linha.substring(35,45));
		    	linha = buffer.readLine();
		    }
		    buffer.close();
		    leitor.close();
		    fluxo.close();
		    
	    } catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
