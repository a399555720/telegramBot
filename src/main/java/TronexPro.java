import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author denny
 * @create 2021-03-16 上午 05:30
 */
public class TronexPro extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "tronexProBot";
    }

    public String getBotToken() {
        return "1653581863:AAHJElJeOGY7P_k59ui306E7R7etrmlm8AQ";
    }

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();


        if (command.equals("/hi")) {
            String a = "";
            String b = "";
            String c = "";
            String d = "";

//                while (true) {
//                    try {
//                        b = a;
//                        d = c;
//                        String strURL = "https://tronex.pro/";
//                        URL url = new URL(strURL);
//                        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//                        httpConn.setRequestProperty("Cookie", "foo=bar");
//                        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
//
//                        BufferedReader bufReader = new BufferedReader(input);
//                        String line = "";
//                        StringBuilder contentBuf = new StringBuilder();
//                        while ((line = bufReader.readLine()) != null) {
//                            contentBuf.append(line);
//                        }
//                        String buf = contentBuf.toString();
//                        int beginIx = buf.indexOf("Last deposits", 1);
//                        int endIx = buf.indexOf(" TRX</span>", 1);
//                        String result = buf.substring(beginIx + 255, endIx);
//                        int beginIx1 = buf.indexOf("TRX</span>", 1);
//                        int endIx1 = buf.indexOf("<span><a href=", 1);
//                        String result1 = buf.substring(beginIx + 44, endIx - 35);
//
//                        a = result;
//                        c = result1;
//                        if (!(a.equals(b)) || !(c.equals(d))) {
//                            System.out.println(result);
//                            message.setText(result);
//                            message.setChatId(update.getMessage().getChatId());
//
//                            try {
//                                execute(message);
//                            } catch (TelegramApiException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    } catch (Exception ex) {
//
//                    }
//
//                }
//            while (true) {
//                message.setText("HI");
//                message.setChatId(update.getMessage().getChatId());
//
//                try {
//                    execute(message);
//                } catch (TelegramApiException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }
    }
}




