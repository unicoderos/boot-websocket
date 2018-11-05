package com.javainuse.websocket.config;

import java.io.IOException;

import com.javainuse.util.NumberUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Random;
import java.lang.Math;

@Controller
@Component
public class SocketTextHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);

        if (jsonObject.get("user").toString().matches("google")) {


            Object randomN = NumberUtil.generateRandomNumber(600, 100);
            session.sendMessage(new TextMessage("google: " + randomN.toString() + ""));

        }
        if (jsonObject.get("user").toString().matches("hotmail")) {


            Object randomN = NumberUtil.generateRandomNumber(600, 100);

            session.sendMessage(new TextMessage("hotmail:" + ((Double) randomN * -1) + ""));


        }
        if (jsonObject.get("user").toString().matches("yahoo")) {


            Object randomN = NumberUtil.generateRandomNumber(600, 100);

            session.sendMessage(new TextMessage("yahoo:" + ((double) randomN * 10) + ""));


        }
        if (jsonObject.get("user").toString().matches("netflix")) {


            Object randomN = NumberUtil.generateRandomNumber(600, 100);

            session.sendMessage(new TextMessage("netflix:" + ((double) randomN / 10) + ""));


        }
        if (jsonObject.get("user").toString().matches("orcale")) {


            Object randomN = NumberUtil.generateRandomNumber(600, 100);

            session.sendMessage(new TextMessage("orcale:" + ((double) randomN + 10) + ""));

        }

    }
}


