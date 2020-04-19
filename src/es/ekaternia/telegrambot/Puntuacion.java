package es.ekaternia.telegrambot;
import java.io.*;
import java.util.*;
//import java.util.List;
//import java.util.Properties;
//import java.util.Scanner;

public class Puntuacion {
    
    //static Properties grupoCiv = new Properties();
    //static Properties civPuntos = new Properties();
    //static String[] Grupos= {"-448061919 ","-425662793 ","-409705638 ","-447367676 ","-480159340 ","-462274624 "};
    //static String[] Civilizaciones= {"Japonesa","Griega","Azteca","Egipcia","Vikinga","Kraal"};
    //static String [][] grupoCivPunt;
    public static ArrayList<Civilizacion> civilizaciones = new ArrayList<Civilizacion>();
    static File archivo = new File ("puntuacion.txt");
    static    Scanner s = null;
    public static Iterator<Civilizacion> itrCivilizaciones = civilizaciones.iterator();
    Civilizacion civilizacion = new Civilizacion();
    
	public static String devolverPuntuacion(long chat_id) {
	LeerFichero();
	String respuesta= null;
	String grupo= chat_id+"";
	System.out.println("grupo:"+grupo+":");
	if (grupo.equalsIgnoreCase("155589819")) {
		return "nulo";
	}else {
		itrCivilizaciones = civilizaciones.iterator();
		while (itrCivilizaciones.hasNext()) {
			Civilizacion civilizacion =itrCivilizaciones.next();
			if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
				//civilizacion.setPuntos(civilizacion.getPuntos()+1);
				respuesta=  "La piopuntuación actual de la Civilizacion "+civilizacion.getNombre()+" es: "+ civilizacion.getPuntos() +" piopuntos";
			}
			
		}
	}
	return respuesta;
	
	}
	
	public static String devolverTodaPuntuacion(long chat_id) {
	LeerFichero();
	String respuesta="";
	String grupo= chat_id+"";
	System.out.println("grupo:"+grupo+":");
	if (grupo.equalsIgnoreCase("155589819")) {
		return "nulo";
	}else {
		itrCivilizaciones = civilizaciones.iterator();
		while (itrCivilizaciones.hasNext()) {
			Civilizacion civilizacion =itrCivilizaciones.next();
			//if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
				//civilizacion.setPuntos(civilizacion.getPuntos()+1);
				respuesta=respuesta+  ""+civilizacion.getNombre()+" es: "+ civilizacion.getPuntos() +"\n";
			//}
			
		}
	}
	return respuesta;
	
	}
	
	
	
	public static String  LeerFichero() {
		try {
			BorrarArray();
			s = new Scanner(archivo);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				String [] cortarString= linea.split("::");
				Civilizacion civilizacion = new Civilizacion();
				civilizacion.setGrupo(cortarString[0]);
				civilizacion.setNombre(cortarString[1]);
				civilizacion.setPuntos(Integer.parseInt(cortarString[2]));
				civilizacion.setNumeros(Integer.parseInt(cortarString[3]));
				civilizaciones.add(civilizacion);
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			try {
				if (s != null)
					s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

return "Leido";
		
	   }

	public static String EscribirFichero()
    {
		 FileWriter fichero = null;
	        PrintWriter pw = null;
	        //String NombreFichero="puntuacion.txt";
	        try
	        {
	        	System.out.println("asd");
	        	
	            fichero = new FileWriter(archivo);
	            pw = new PrintWriter(fichero);
	            System.out.println("dsa");
	            itrCivilizaciones = civilizaciones.iterator();
	while(itrCivilizaciones.hasNext()) {
		System.out.println("aaaa");
		Civilizacion civilizacion = itrCivilizaciones.next();
		System.out.println(civilizacion.getGrupo()+"::"+civilizacion.getNombre()+"::"+civilizacion.getPuntos());
		pw.println(civilizacion.getGrupo()+"::"+civilizacion.getNombre()+"::"+civilizacion.getPuntos()+"::"+civilizacion.getNumeros());
		
	}



	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	        System.out.println("Escrito");
return "Escrito";
		
    }
		public static String sumarPuntos(long chat_id) {
			LeerFichero();
			String respuesta= null;
			String grupo= chat_id+"";
			System.out.println("grupo:"+grupo+":");
			if (grupo.equalsIgnoreCase("155589819")) {
				respuesta="";
			}else {
				itrCivilizaciones = civilizaciones.iterator();
				while (itrCivilizaciones.hasNext()) {
					Civilizacion civilizacion =itrCivilizaciones.next();
					if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
						civilizacion.setPuntos(civilizacion.getPuntos()+1);
						respuesta=  "La piopuntuación actual de la Civilizacion "+civilizacion.getNombre()+" es: "+ civilizacion.getPuntos() +" piopuntos";
					}
					
				}
				
				
				
				
			}
			EscribirFichero();
			return respuesta;
			
		}
		
		public static void BorrarArray() {
			System.out.println(civilizaciones.size());
			if (civilizaciones.size()>0) {
			itrCivilizaciones = civilizaciones.iterator();
			
			while (itrCivilizaciones.hasNext()) {
				
				itrCivilizaciones.remove();

				}
			}
		}
		
		
		public static String sumarPuntos(long chat_id, String message_text) {
			String puntoSuma[]=message_text.split(" ");
			System.out.print(puntoSuma[0]+":"+puntoSuma[1]+":"+puntoSuma[2]);
			String nombreGrupo= puntoSuma[1];
			String respuesta = null;
			LeerFichero();

			itrCivilizaciones = civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getNombre().equalsIgnoreCase(nombreGrupo)) {
					civilizacion.setPuntos(civilizacion.getPuntos()+Integer.parseInt(puntoSuma[2]));
					respuesta=  "La piopuntuación actual de la Civilizacion "+civilizacion.getNombre()+" es: "+ civilizacion.getPuntos() +" piopuntos";
				}
				
			}
			

			EscribirFichero();
			return respuesta;
		}
}
