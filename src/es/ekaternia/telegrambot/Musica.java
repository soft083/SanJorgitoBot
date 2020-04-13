package es.ekaternia.telegrambot;

public class Musica {

	public Musica() {
		// TODO Auto-generated constructor stub
	}
	  public static String opcion(long chat_id, String opcion)
	    {
	        String Respuesta = "vacio";
	        if(opcion.contains("spotify"))
	            Respuesta = musicaSpotify(chat_id);
	        else {
	            Respuesta = musica(chat_id);
	        }
	        return Respuesta;
	    }
	  
	    public static String musicaSpotify(long chat_id)
	    {
	        String Mensaje = "";
	        Mensaje = (new StringBuilder(String.valueOf(Mensaje))).append("Muchas gracias por la colaboracion \n").toString();
	        Mensaje = (new StringBuilder(String.valueOf(Mensaje))).append("Cancion añadida a Spotify \n").toString();
	        
	        return Mensaje;
	    }
	    public static String musica(long chat_id)
	    {
	        String Mensaje = "";
	        Mensaje = (new StringBuilder(String.valueOf(Mensaje))).append("Muchas gracias por la colaboracion \n").toString();
	        Mensaje = (new StringBuilder(String.valueOf(Mensaje))).append("Cancion añadida a lista normal \n").toString();
	        
	        return Mensaje;
	    }
}
