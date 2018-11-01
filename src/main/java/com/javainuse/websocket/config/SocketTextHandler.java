package com.javainuse.websocket.config;

import java.io.IOException;

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
int i=0;
float max = 600;
float min =100;

	/**
	 * Handles text message
	 * @param session
	 * @param message
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {

		String payload = message.getPayload();/*retireve from object data*/
		JSONObject jsonObject = new JSONObject(payload);
		i=i+1;/*Counter for generating random number*/
		Random rand = new Random();
		double r =Math.round(((Math.random() * ((max - min) + 1)) + min)*100)/100;/* create Random Number */
		session.sendMessage(new TextMessage(" " +r + "" + " "));
	}
	

}