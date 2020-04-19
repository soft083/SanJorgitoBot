package es.ekaternia.telegrambot;

import java.util.Iterator;

public class ObtenerItem {
	public static Iterator<Civilizacion> itrCivilizaciones = Puntuacion.civilizaciones.iterator();
	//public static Boolean ItemActivos[][] = new Boolean[100][100];
	public static Boolean[][] ItemActivo = new Boolean[100][100];
	public static String[] palabras = new String[]{"ropa", "cerebro", "herramientas", "casa","pluma", "pergamino", "caballo", "armadura","sombrero", "barba", "vara", "caldero","templo", "fieles", "cielo", "poderes"};
	
	
	
	public static String inicializaItem(long chat_id, String texto) {
		
		
		//for (int i=0 ;i<Puntuacion.civilizaciones.size();i++) {
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
			Civilizacion civilizacion =itrCivilizaciones.next();
			for (int j=0;j<=50;j++) {
				System.out.println("i:"+civilizacion.getNumeros()+" j:"+j);
			ItemActivo[civilizacion.getNumeros()][j]=true;
			}
		}
		  
	return "true";
	}

	public static String visualizarItem(long chat_id, String texto) {
		String respuesta="Item disponibles a comprar: \n ";
		String grupo= chat_id+"";
		  Integer numero=0;
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
					numero=civilizacion.getNumeros();
					
				}
				
			}
			
			
			  for (int i=0;i< palabras.length; i++) {
				  if (ItemActivo[numero][i] ) {
					  respuesta= respuesta + palabras[i]+" , ";
				  }
			  }
			
		
		return respuesta;
	}
	
	  public static String compraItem(long chat_id, String texto) {
		  String respuesta=" ";
		  
			String grupo= chat_id+"";
		  Integer numero=0;
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
					numero=civilizacion.getNumeros();
					
				}
				
			}
			
			  String cadena[] = texto.split("/obteneritem ");
			  //int grupo =(int)chat_id;
			  
			  String Item = cadena[1];
			  System.out.println("0 "+cadena[0]);
			  
			  System.out.println("Item "+Item);
			  
			  for (int i=0;i< palabras.length; i++) {
				  System.out.println("Item "+Item);
				  System.out.println("i "+i);
				  System.out.println("palabras "+palabras[i]);
				  if (Item.equalsIgnoreCase(palabras[i]) && ItemActivo[numero][i] ) {
					  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
					  while (itrCivilizaciones.hasNext()) {
						  
							Civilizacion civilizacion =itrCivilizaciones.next();
							if (civilizacion.getNumeros()==numero && civilizacion.getPuntos() >=50) {
								
								civilizacion.setPuntos(civilizacion.getPuntos()-50);
								respuesta= "\n Civilización "+civilizacion.getNombre()+": Item "+Item+" comprado y actualizados los PioPuntos \n";
								ItemActivo[numero][i]=false;
								Puntuacion.EscribirFichero();
							}else {
								respuesta= "\n no tienes PioPuntos suficientes\n";
							}
							
						}
					  
					  return respuesta;
					  
					  
				  }else {
						respuesta= "\n item incorrecto para comprar o ya comprado\n";
				  }
					  
			  }
			  
		
			
			
		  
		  
		  return respuesta;
		  
		  
		  
	  }
	

}
