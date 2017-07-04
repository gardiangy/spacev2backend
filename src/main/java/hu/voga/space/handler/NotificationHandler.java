package hu.voga.space.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import hu.voga.space.util.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class NotificationHandler extends TextWebSocketHandler {

    private WebSocketSession session;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendNotification(Notification notification) {
        System.out.println("Trying to send:" + notification);
        if (session != null && session.isOpen()) {
            try {
                System.out.println("Now sending:" + notification);
                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(notification)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Don't have open session to send:" + notification);
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established");
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
            System.out.println("Received:" + message.getPayload());
        }
    }
}
