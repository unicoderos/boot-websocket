package com.javainuse.websocket.config;

import java.io.IOException;

import com.javainuse.util.NumberUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * This annotation serves as a specialization of @Component,
 * allowing for implementation classes to be autodetected through classpath scanning.
 * It is typically used in combination with annotated handler methods based on the RequestMapping annotation.
 */
@Controller
/**
 * Indicates that an annotated class is a "component". Such classes are considered as candidates
 * for auto-detection when using annotation-based configuration and classpath scanning.
 * Other class-level annotations may be considered as identifying a component as well,
 * typically a special kind of component: e.g. the @Repository annotation or AspectJ's @Aspect annotation.
 */
@Component
public class SocketTextHandler extends TextWebSocketHandler {



    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);

        String userMessage = jsonObject.getString("user").toString().trim();
        Object randomN = NumberUtil.generateRandomNumber(600, 100);
        switch (userMessage){

            case "google":

                 randomN = NumberUtil.generateRandomNumber(600, 100);
                session.sendMessage(new TextMessage("google: " + randomN.toString() + ""));
                break;
            case "hotmail":

                 randomN = NumberUtil.generateRandomNumber(600, 100);
                session.sendMessage(new TextMessage("hotmail:" + ((Double) randomN * -1) + ""));
                break;
            case "yahoo":

                 randomN = NumberUtil.generateRandomNumber(600, 100);
                session.sendMessage(new TextMessage("yahoo:" + ((double) randomN * 10) + ""));
                break;
            case "netflix":

                Object randomN3 = NumberUtil.generateRandomNumber(600, 100);
                session.sendMessage(new TextMessage("netflix:" + ((double) randomN3 / 10) + ""));
                break;
            case "oracle":

                Object randomN4 = NumberUtil.generateRandomNumber(600, 100);
                session.sendMessage(new TextMessage("orcale:" + ((double) randomN4 + 10) + ""));

        }

    }
}


