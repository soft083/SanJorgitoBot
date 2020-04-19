package es.ekaternia.telegrambot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.*;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;



public class EchoBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(final Update update) {
		// Esta función se invocará cuando nuestro bot reciba un mensaje

		
		
		
		// Se obtiene el mensaje escrito por el usuario
		//final String messageTextReceived = update.getMessage().getText().toLowerCase();

		
		// Se obtiene el id de chat del usuario
		final long chat_id = update.getMessage().getChatId();

		// Se crea un objeto mensaje
		SendMessage message = new SendMessage().setChatId(chat_id).setText("");
		SendMessage message2 = new SendMessage().setChatId(chat_id).setText("");
		
		/*try {
			// Se envía el mensaje
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}*/
		
        System.out.println((new StringBuilder(String.valueOf(update.getMessage().getFrom().getFirstName()))).append(": ").append(update.getMessage().getText()).toString());
        if(update.hasMessage() && update.getMessage().hasText())
        {
         //   long chat_id = update.getMessage().getChatId().longValue();
            String message_text = update.getMessage().getText().toLowerCase();
            if(message_text.equals("/start"))
            {
            	System.out.println(Long.valueOf(chat_id));
                message = (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText("Bienvenidos al BOT de Pioneros de SDM");
                try
                {
                    execute(message);
                }
                catch(TelegramApiException e)
                {
                    e.printStackTrace();
                }
            } else if(message_text.equals("/alex"))
                {
                    message = (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText("Álex, eres el más guapo de todos");
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                } else if(message_text.startsWith("/musica")){
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Musica.opcion(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/consultanivel")){
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText("Tu nivel todavia es muy bajo, eres un mono");
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/resuelvemoji"))
                {

                  	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(CinePic.respuestas(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if (message_text.startsWith("/visualizaremojis")) {
                	String Foto ="https://img.europapress.es/fotoweb/fotonoticia_20140927141411-652389_800.jpg";
                    SendPhoto messagePhoto = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto(Foto)
                            .setCaption("Adivina las peliculas");
                    try {
                        sendPhoto(messagePhoto); // Call method to send the photo
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }else if(message_text.equals("/escribir")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Puntuacion.EscribirFichero());
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/verpuntos")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Puntuacion.devolverTodaPuntuacion(chat_id));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/puntuacion")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Puntuacion.devolverPuntuacion(chat_id));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/sumapuntos")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Puntuacion.sumarPuntos(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/visualizarahorcado")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Ahorcado.visualizarAhorcado(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/resuelveahorcado")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Ahorcado.ResuelveAhorcado(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/iniciacine")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(CinePic.inicializaCine(chat_id,message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/iniciahorcado")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Ahorcado.inicializaAhorcado(chat_id));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/iniciaitem")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(ObtenerItem.inicializaItem(chat_id, message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/obteneritem")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(ObtenerItem.compraItem(chat_id, message_text));
                	message2 =  (new SendMessage()).setChatId(Long.valueOf(-462274624)).setText("**** AVISO "+ message.getText()+" ****");
                    try
                    {
                        execute(message);
                        execute(message2);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                    
                }else if(message_text.startsWith("/veritems")) {
                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(ObtenerItem.visualizarItem(chat_id, message_text));
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }else if(message_text.startsWith("/iniciatodo")) {
                	String respuesta= " "+
                	Puntuacion.devolverTodaPuntuacion(chat_id)+"\n "+
                	CinePic.inicializaCine(chat_id,message_text)+" "+ 
                	Ahorcado.inicializaAhorcado(chat_id)+" "+
                	ObtenerItem.inicializaItem(chat_id, message_text)+" "+
                	ObtenerItem.visualizarItem(chat_id, message_text)+" "
                	;

                	
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(respuesta);
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                else if(message_text.equals("/ayuda")) {
                	String Mensajetexto=""+
                "Lista de comando disponibles\n"+
                "/start \n"+
                "/musica \n"+
                "/cinemoji \n"+
                "/cinepic nº: titulo \n"+
                "/verpuntos \n";
                	message =  (new SendMessage()).setChatId(Long.valueOf(chat_id)).setText(Mensajetexto);
                    try
                    {
                        execute(message);
                    }
                    catch(TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
                }
            
                  
        }		
		
	}

	@Override
	public String getBotUsername() {
		// Se devuelve el nombre que dimos al bot al crearlo con el BotFather
		return "EchoBot";
	}

	@Override
	public String getBotToken() {
		// Se devuelve el token que nos generó el BotFather de nuestro bot
		return "1247325747:AAGisiw3J0Osr_86KkXE7BqxQxoqHz9-tzE";
	}
}