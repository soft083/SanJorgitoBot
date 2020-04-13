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
		final String messageTextReceived = update.getMessage().getText();

		
		// Se obtiene el id de chat del usuario
		final long chatId = update.getMessage().getChatId();

		// Se crea un objeto mensaje
		SendMessage message = new SendMessage().setChatId(chatId).setText(messageTextReceived);
		
		try {
			// Se envía el mensaje
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		
        System.out.println((new StringBuilder(String.valueOf(update.getMessage().getFrom().getFirstName()))).append(": ").append(update.getMessage().getText()).toString());
        if(update.hasMessage() && update.getMessage().hasText())
        {
            long chat_id = update.getMessage().getChatId().longValue();
            String message_text = update.getMessage().getText();
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
            } else if(message_text.equals("/Alex"))
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
                }else if (message_text.equals("/imagen")) {
                    SendPhoto messagePhoto = new SendPhoto()
                            .setChatId(chat_id)
                            .setPhoto("https://pbs.twimg.com/profile_images/513094919246737408/Dp_FWNa1_400x400.jpeg")
                            .setCaption("Photo");
                    try {
                        sendPhoto(messagePhoto); // Call method to send the photo
                    } catch (TelegramApiException e) {
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
                }else if (message_text.equals("/markup")) {
                    message = new SendMessage() // Create a message object object
                            .setChatId(chat_id)
                            .setText("Here is your keyboard");
                    // Create ReplyKeyboardMarkup object
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    // Create the keyboard (list of keyboard rows)
                    List<KeyboardRow> keyboard = new ArrayList<>();
                    // Create a keyboard row
                    KeyboardRow row = new KeyboardRow();
                    // Set each button, you can also use KeyboardButton objects if you need something else than text
                    row.add(0,"POCOYO 1");
                    row.add(1,"Mostrar Torre");
                    row.add(2,"Row 1 Button 3");
                  
                    // Add the first row to the keyboard
                    keyboard.add(row);
                    // Create another keyboard row
                    row = new KeyboardRow();
                    // Set each button for the second line
                    row.add("Row 2 Button 1");
                    row.add("Row 2 Button 2");
                    row.add("Row 2 Button 3");
                    // Add the second row to the keyboard
                    keyboard.add(row);
                    // Set the keyboard to the markup
                    keyboardMarkup.setKeyboard(keyboard);
                    // Add it to the message
                    message.setReplyMarkup(keyboardMarkup);
                    
                    
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (message_text.equals("/quitar")) {
                    //message = new SendMessage() // Create a message object object
                        //    .setChatId(chat_id)
                         //   .setText("Here is your keyboard");
                    // Create ReplyKeyboardMarkup object
                    ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
                    // Create the keyboard (list of keyboard rows)

                    // Add it to the message
                    message.setReplyMarkup(keyboardMarkup);
                    
                    
                    try {
                        execute(message); // Sending our message object to user
                    } catch (TelegramApiException e) {
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
                }else if (message_text.startsWith("/visualizarEmojis")) {
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