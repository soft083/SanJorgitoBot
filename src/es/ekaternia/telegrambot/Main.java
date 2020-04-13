/**
 * 
 */
package es.ekaternia.telegrambot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


/**
 * @author n220605
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try
        {
        	System.out.println("Arrancando");
            botsApi.registerBot(new EchoBot());
        }
        catch(TelegramApiRequestException e)
        {
            e.printStackTrace();
        }
	}

}
