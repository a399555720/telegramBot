import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import sun.misc.Unsafe;

import java.io.FilterOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author denny
 * @create 2021-03-16 上午 05:29
 */
public class Main {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {

            redirectToStdOut();


            telegramBotsApi.registerBot(new TronexPro());
            redirectToStdOut();


        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    public static void redirectToStdOut() {
        try {

            // get Unsafe
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            // get Unsafe's methods
            Method getObjectVolatile = unsafeClass.getDeclaredMethod("getObjectVolatile", Object.class, long.class);
            Method putObject = unsafeClass.getDeclaredMethod("putObject", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);
            Method objectFieldOffset = unsafeClass.getDeclaredMethod("objectFieldOffset", Field.class);

            // get information about the global logger instance and warningStream fields
            Class<?> loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Field warningStreamField = loggerClass.getDeclaredField("warningStream");

            Long loggerOffset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            Long warningStreamOffset = (Long) objectFieldOffset.invoke(unsafe, warningStreamField);

            // get the global logger instance
            Object theLogger = getObjectVolatile.invoke(unsafe, loggerClass, loggerOffset);
            // replace the warningStream with System.out
            putObject.invoke(unsafe, theLogger, warningStreamOffset, System.out);
        } catch (Throwable ignored) {
        }
    }

}
