package es.ekaternia.telegrambot;
import java.util.Scanner;
import java.util.Random;
import java.util.Iterator;
import java.util.Scanner;

public class Ahorcado {
	public static Iterator<Civilizacion> itrCivilizaciones = Puntuacion.civilizaciones.iterator();
	public static Integer[][] numeroVidas = new Integer[100][100];
	public static Integer[][] numeroAciertos = new Integer[100][100];
	public static Boolean palabrasActivas[][] = new Boolean[100][100];
	public static String arrayPalabras[] = new String[10];			
	static String mensajeRespuesta="";
	public static Integer tamano[] = new Integer[100];
	static char[][] respuesta = new char[100][100];
	public static String inicializaAhorcado(long chat_id) {
		
		
		//for (int i=0 ;i<Puntuacion.civilizaciones.size();i++) {
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
			Civilizacion civilizacion =itrCivilizaciones.next();
			for (int j=0;j<=10;j++) {
				System.out.println("i:"+civilizacion.getNumeros()+" j:"+j);
				numeroVidas[civilizacion.getNumeros()][j]=6;
				palabrasActivas[civilizacion.getNumeros()][j]=true;
				numeroAciertos[civilizacion.getNumeros()][j]=0;
			}
		}
		  
	        arrayPalabras[0] = "hola";
	        arrayPalabras[1] = "adios";
	        arrayPalabras[2] = "cojonudo";
	        arrayPalabras[3] = "cojonudo";
	        arrayPalabras[4] = "cojonudo";
	        arrayPalabras[5] = "cojonudo";
	        arrayPalabras[6] = "cojonudo";
	        arrayPalabras[7] = "cojonudo";
	        					
	        tamano[0]=arrayPalabras[0].length();
	        tamano[1]=arrayPalabras[1].length();
	        tamano[2]=arrayPalabras[2].length();
	        tamano[3]=arrayPalabras[3].length();
	        tamano[4]=arrayPalabras[4].length();
	        tamano[5]=arrayPalabras[5].length();
	        tamano[6]=arrayPalabras[6].length();
	        tamano[6]=arrayPalabras[7].length();
	        
	        
	        
		return "true";
	}
	
	
	
	public static String visualizarAhorcado(long chat_id,String texto) {
		String grupo= chat_id+"";
		mensajeRespuesta="";
		  Integer numero=0;
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
					numero=civilizacion.getNumeros();
					
				}
				
			}
        
			String cadena[] = texto.split("/visualizarahorcado");
			Integer cadenaRespuesta= Integer.parseInt(cadena[1].replace(" ",""));
       System.out.println("cadenaRespuesta "+cadenaRespuesta);


        for (int i = 0; i < tamano[cadenaRespuesta]; i++) {
            respuesta[numero][i] = 'X';
            mensajeRespuesta= mensajeRespuesta+respuesta[numero][i]+"";
        }
        
        //mensajeRespuesta= respuesta[numero][cadenaRespuesta]+"";
	
	
	
        return mensajeRespuesta;

	
	
	}
	

	
	
	public static String ResuelveAhorcado(long chat_id, String texto) {
		mensajeRespuesta="\n";
		String grupo= chat_id+"";
		  Integer numero=0;
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
			while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getGrupo().equalsIgnoreCase(grupo)) {
					numero=civilizacion.getNumeros();
					
				}
				
			}
		  System.out.println("numeros"+numero);
		  

		  //
		  int contador=0;
		  String cadena[] = texto.split("/resuelveahorcado");
		  String cadenaRespuesta[] = cadena[1].split(":");
		  Integer NumeroRespuesta = Integer.parseInt(cadenaRespuesta[0].replace(" ", ""));
		  String Titulo = cadenaRespuesta[1].replace(" ","");
		  String palabra = arrayPalabras[numero];
		  System.out.println("Ti"+Titulo);
		  System.out.println("pa"+palabra);
		  System.out.println("NumRe"+NumeroRespuesta);
		  mensajeRespuesta="\n"+mensajeRespuesta+dibujar(numeroVidas[numero][NumeroRespuesta])+"\n";
		  if (palabra.contains(Titulo)) {
			  System.out.println("palabracontais");
			  System.out.println("tamano[NumeroRespuesta]"+tamano[NumeroRespuesta]);
			  for(int i =0; i< tamano[NumeroRespuesta];i++) {
				  
				  if (palabra.charAt(i)==Titulo.charAt(0)) {
					  respuesta[numero][i] = Titulo.charAt(0);
					  System.out.println("res"+respuesta[numero][i]);
					  System.out.println("char"+Titulo.charAt(0));
					  contador++;
				  }
				  
			  }
				numeroAciertos[numero][NumeroRespuesta]=numeroAciertos[numero][NumeroRespuesta] +contador;
				
		  }else
		  {
			  numeroVidas[numero][NumeroRespuesta]--;

		  }
		  if (numeroVidas[numero][NumeroRespuesta]==0) {
			  mensajeRespuesta="\n"+mensajeRespuesta+dibujar(numeroVidas[numero][NumeroRespuesta])+"\n";
		  }else {
			/*  for (int i=0; i <tamano[NumeroRespuesta];i++) {
				  mensajeRespuesta="_"+respuesta[numero][NumeroRespuesta]+"_";
			  }*/
		       for (int i = 0; i < tamano[NumeroRespuesta]; i++) {
		            //respuesta[numero][i] = 'X';
		            mensajeRespuesta= mensajeRespuesta+respuesta[numero][i]+"";
		        }
		        
		  }
		
		return mensajeRespuesta;
	}
	
    
     /**
     * Esto desguaza el String en un array de caracteres
     * @return array de letras.
     */
    private static char[] desguazaa(String palAzar){
        char[] letras;
        letras = new char[palAzar.length()];
        for(int i = 0; i < palAzar.length(); i++){
            letras[i] = palAzar.charAt(i);
        }
        return letras;
    }
    
    /**
     * Esto imprime la palabra con espacios
     * @param tusRespuestas el array de caracteres
     */
    private static void imprimeOculta(char[] tusRespuestas){
        
        for(int i = 0; i < tusRespuestas.length; i++){
            System.out.print(tusRespuestas[i] + " ");
        }
    }
    
    /**
     * Esto nos pregunta si queremos volver a jugar y comprueba los caracteres
     * introducidos
     * @param men texto para mostrar al usuario
     * @return caracter de respuesta (s/n)
     */
    public static char pregunta(String men, Scanner teclado) {
        char resp;
        System.out.println(men + " (s/n)");
        resp = teclado.next().toLowerCase().charAt(0);
        while (resp != 's' && resp != 'n') {
            System.out.println("Error! solo se admite S o N");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    
		
	}
	public static String aaaaaresuelveAhorcado(long chat_id,String message) {
		String respuesta= "\n";
respuesta= respuesta+ (" ---------------------\n");
respuesta= respuesta+ (" |                     |\n");
respuesta= respuesta+ (" |                     |\n");
respuesta= respuesta+ (" |                  -------\n");
respuesta= respuesta+ (" |                 | X  X  |\n");
respuesta= respuesta+ (" |                 |   o   |\n");
respuesta= respuesta+ (" |                  -------\n");
respuesta= respuesta+ (" |                     |   \n");
respuesta= respuesta+ (" |                   / | \\ \n");
respuesta= respuesta+ (" |                  /  |   \\ \n");
respuesta= respuesta+ (" |                 /   |     \\ \n");
respuesta= respuesta+ (" |                     |   \n");
respuesta= respuesta+ (" |                    / \\ \n");
respuesta= respuesta+ (" |                   /   \\  \n");
respuesta= respuesta+ (" |                  /     \\ \n");
		
		return respuesta;
	}
	
	private static String dibujar(int i) {
		String msg_respuesta="";
        switch (i) {
            case 6:
            	msg_respuesta=msg_respuesta+" ---------------------\n";
                for (int j = 0; j <15; j++) {
                	msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 5:
            	msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | -  -  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                for (int j = 0; j <10; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 4:
                msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | -  -  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                for (int j = 0; j < 5; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 3:
                msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | -  -  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                   / |   \n";
                msg_respuesta=msg_respuesta+" |                 /   |   \n";
                msg_respuesta=msg_respuesta+" |                /    |   \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                for (int j = 0; j < 5; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 2:
                msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | -  -  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                   / | \\ \n";
                msg_respuesta=msg_respuesta+" |                  /  |   \\ \n";
                msg_respuesta=msg_respuesta+" |                 /   |     \\ \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                for (int j = 0; j < 5; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 1:
                msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | -  -  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                   / | \\ \n";
                msg_respuesta=msg_respuesta+" |                  /  |   \\ \n";
                msg_respuesta=msg_respuesta+" |                 /   |     \\ \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                    /  \n";
                msg_respuesta=msg_respuesta+" |                   /      \n";
                msg_respuesta=msg_respuesta+" |                  /       \n";
                for (int j = 0; j < 2; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                break;
 
            case 0:
               msg_respuesta=msg_respuesta+" ---------------------\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                     |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                 | X  X  |\n";
                msg_respuesta=msg_respuesta+" |                 |   o   |\n";
                msg_respuesta=msg_respuesta+" |                  -------\n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                   / | \\ \n";
                msg_respuesta=msg_respuesta+" |                  /  |   \\ \n";
                msg_respuesta=msg_respuesta+" |                 /   |     \\ \n";
                msg_respuesta=msg_respuesta+" |                     |   \n";
                msg_respuesta=msg_respuesta+" |                    / \\\n";
                msg_respuesta=msg_respuesta+" |                   /   \\  \n";
                msg_respuesta=msg_respuesta+" |                  /     \\ \n";
                for (int j = 0; j < 2; j++) {
                    msg_respuesta=msg_respuesta+" |\n";
 
                }
                msg_respuesta=msg_respuesta+"__________\n";
                msg_respuesta=msg_respuesta+"GAME OVER\n";
                break;
        }
        return msg_respuesta;
    }
	
}
