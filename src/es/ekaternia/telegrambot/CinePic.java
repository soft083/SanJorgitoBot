package es.ekaternia.telegrambot;

import java.util.Iterator;

public class CinePic {
	public static Iterator<Civilizacion> itrCivilizaciones = Puntuacion.civilizaciones.iterator();
	static int grupo=0;	
	public static Boolean[][] numeroActivo = new Boolean[100][100];
	  /*public static String opcion(long chat_id, String opcion)
	    {
	        String Respuesta = "🙂";
	  
	        return Respuesta;
	    }*/
public static String inicializaCine(long chat_id, String texto) {
	
	
	//for (int i=0 ;i<Puntuacion.civilizaciones.size();i++) {
	  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
		while (itrCivilizaciones.hasNext()) {
		Civilizacion civilizacion =itrCivilizaciones.next();
		for (int j=0;j<=50;j++) {
			System.out.println("i:"+civilizacion.getNumeros()+" j:"+j);
		numeroActivo[civilizacion.getNumeros()][j]=true;
		}
	}
	  
return "true";
}

	  public static String respuestas(long chat_id, String texto) {
		  
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
		  

		  String respuesta="Fallaste";
		  String cadena[] = texto.split("/resuelvemoji");
		  //int grupo =(int)chat_id;
		  
		  String cadenaRespuesta[] = cadena[1].split(":");
		  String Numero = cadenaRespuesta[0];
		  String Titulo = cadenaRespuesta[1];
	
		  switch (Numero) {
		  
		  case " 1":
			  if (numeroActivo[numero][1]){
				  if (Titulo.equalsIgnoreCase(" Con la muerte en los talones")) {
					  respuesta=sumaPuntos(numero,1,1);
				  }
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 2":
			  if (numeroActivo[numero][2]){
			  if (Titulo.equalsIgnoreCase( " Desayuno con diamantes")) {respuesta=sumaPuntos(numero,2,1);
			  }
		  }else{
			  respuesta="Ya la acertaste";
		  }
			  break;
		  case " 3":
			  if (numeroActivo[numero][3]){
			  if (Titulo.equalsIgnoreCase( " Sonrisas y lagrimas") ){respuesta=sumaPuntos(numero,3,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 4":
			  if (numeroActivo[numero][4]){
			  if (Titulo.equalsIgnoreCase( " Cuatro bodas y un funeral") ){respuesta=sumaPuntos(numero,4,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 5":
			  if (numeroActivo[numero][5]){
			  if (Titulo.equalsIgnoreCase( " Eduardo manos-tijeras")) {respuesta=sumaPuntos(numero,5,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 6":
			  if (numeroActivo[numero][6]){
			  if (Titulo.equalsIgnoreCase( " Cantando bajo la lluvia")) {respuesta=sumaPuntos(numero,6,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 7":
			  if (numeroActivo[numero][7]){
			  if (Titulo.equalsIgnoreCase( " Abre los ojos")) {respuesta=sumaPuntos(numero,7,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 8":
			  if (numeroActivo[numero][8]){
			  if (Titulo.equalsIgnoreCase( " Diamantes de sangre") ){respuesta=sumaPuntos(numero,8,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 9":
			  if (numeroActivo[numero][9]){
			  if (Titulo.equalsIgnoreCase( " 21 vestidos") ){respuesta=sumaPuntos(numero,9,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 10":
			  if (numeroActivo[numero][10]){
			  if (Titulo.equalsIgnoreCase( " El hombre que susurraba a los caballos")) {respuesta=sumaPuntos(numero,10,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 11":
			  if (numeroActivo[numero][11]){
			  if (Titulo.equalsIgnoreCase( " Balada triste de trompeta") ){respuesta=sumaPuntos(numero,11,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 12" :
			  if (numeroActivo[numero][12]){
			  if (Titulo.equalsIgnoreCase( " Un tranvía llamado deseo") ){respuesta=sumaPuntos(numero,12,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 13":
			  if (numeroActivo[numero][13]){
			  if (Titulo.equalsIgnoreCase( " Bailando con lobos")){respuesta=sumaPuntos(numero,13,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 14":
			  if (numeroActivo[numero][14]){
			  if (Titulo.equalsIgnoreCase( " Sangre, Sudor y Lagrimas")) {respuesta=sumaPuntos(numero,14,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 15":
			  if (numeroActivo[numero][15]){
			  if (Titulo.equalsIgnoreCase( " El Señor de los Anillos")) {respuesta=sumaPuntos(numero,15,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 16" :
			  if (numeroActivo[numero][16]){
			  if (Titulo.equalsIgnoreCase( "sdfsdasedrfs")) {respuesta=sumaPuntos(numero,16,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 17":
			  if (numeroActivo[numero][17]){
			  if (Titulo.equalsIgnoreCase( " Liberad a willy")) {respuesta=sumaPuntos(numero,17,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 18":
			  if (numeroActivo[numero][18]){
			  if (Titulo.equalsIgnoreCase( " Dirty dancing")) {respuesta=sumaPuntos(numero,18,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 19":
			  if (numeroActivo[numero][19]){
			  if (Titulo.equalsIgnoreCase( " El silencio de los corderos")) {respuesta=sumaPuntos(numero,19,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 20":
			  if (numeroActivo[numero][20]){
			  if (Titulo.equalsIgnoreCase( " Gorilas en la nieve")) {respuesta=sumaPuntos(numero,20,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 21":
			  if (numeroActivo[numero][21]){
			  if (Titulo.equalsIgnoreCase( " El libro de la selva") ){respuesta=sumaPuntos(numero,21,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 22":
			  if (numeroActivo[numero][22]){
			  if (Titulo.equalsIgnoreCase( " American beauty")) {respuesta=sumaPuntos(numero,22,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 23":
			  if (numeroActivo[numero][23]){
			  if (Titulo.equalsIgnoreCase( " El Fantasma de la Ópera")) {respuesta=sumaPuntos(numero,23,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 24":
			  if (numeroActivo[numero][24]){
			  if (Titulo.equalsIgnoreCase( " American pie")) {respuesta=sumaPuntos(numero,24,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 25":
			  if (numeroActivo[numero][25]){
			  if (Titulo.equalsIgnoreCase( " Brokeback Mountain")) {respuesta=sumaPuntos(numero,25,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  case " 26":
			  if (numeroActivo[numero][26]){
			  if (Titulo.equalsIgnoreCase( " Alien, el octavo pasajero")) {respuesta=sumaPuntos(numero,26,1);}
			  }else{
				  respuesta="Ya la acertaste";
			  }
			  
			  break;
		  default:
			  respuesta="No encontraada";
			  break;
		  
		  }
		  
		  System.out.println("Numero:"+Numero+":\n Titulo:"+Titulo+":");
		  return respuesta;
	  }
	  public static String sumaPuntos(Integer numero,Integer numeroRespuesta,Integer puntos) {
		  numeroActivo[numero][numeroRespuesta]=false;		  
		  itrCivilizaciones = Puntuacion.civilizaciones.iterator();
		  while (itrCivilizaciones.hasNext()) {
				Civilizacion civilizacion =itrCivilizaciones.next();
				if (civilizacion.getNumeros()==numero) {
					
					civilizacion.setPuntos(civilizacion.getPuntos()+puntos);
					Puntuacion.EscribirFichero();
				}
				
			}
		  return "Acertaste, has sumado un pioPunto";
	  }
}
