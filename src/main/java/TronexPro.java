import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author denny
 * @create 2021-03-16 上午 05:30
 */
public class TronexPro extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "tronexProBot";
    }

    public String getBotToken() {
        return "1653581863:AAFzKdEClL3KTdZhte7Sqg1SFy47VM_EI40";
    }

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();

        SendMessage message = new SendMessage();


        if (command.equals("/hi")) {
            String a = "";
            float b = 0;
            int g = 0;
            String c = "";
            String d = "";
            long f =40125940586562186L;

            System.out.println("start");

            while (true) {
                    try {

                        String strURL = "https://bscscan.com/address/0x35806cB227F3a2fad27f0828C03608D6f9548A49";
                        URL url = new URL(strURL);
                        System.setProperty("http.agent", "Chrome");
                        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                        httpConn.setRequestProperty("Cookie", "foo=bar");

                        InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");

                        BufferedReader bufReader = new BufferedReader(input);
                        String line = "";
                        StringBuilder contentBuf = new StringBuilder();
                        while ((line = bufReader.readLine()) != null) {
                            contentBuf.append(line);
                        }
                        String buf = contentBuf.toString();
                        int beginIx = buf.indexOf("Balance:", 1);
                        int endIx = buf.indexOf("BNB </div>", 1);

                        String result = buf.substring(beginIx + 45 , endIx-10);


                        a = "0." + result;
                        System.out.println(a);
                        b = Float.parseFloat(a);
                        g++;
                        System.out.println(b + "--" + g);
                        Date currentTime = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        String dateString = formatter.format(currentTime);
                        System.out.println(dateString);


                        if (b > 0.04 ) {
                            System.out.println(a);
                            message.setText(a);
                            message.setChatId(update.getMessage().getChatId());

                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                e.printStackTrace();
                            }
                        }


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                try {
                    Thread.sleep(31000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
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
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

        }
    }







