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
    /**
	 *
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
        Object randomN = NumberUtil.generateRandomNumber(600,100);
		session.sendMessage(new TextMessage(" " +randomN.toString() + "" + " "));
	}
	

}