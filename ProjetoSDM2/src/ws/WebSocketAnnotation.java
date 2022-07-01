package ws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/ws")
public class WebSocketAnnotation {
    private static final AtomicInteger sequence = new AtomicInteger(1);
    private final String username;
    private Session session;
    private static final Set<WebSocketAnnotation> users = new CopyOnWriteArraySet<>(); // Thread safe
    private int sessionNumber;

    public WebSocketAnnotation() {
        username = "User" + sequence.getAndIncrement();
        sessionNumber = -1;
    }

    @OnOpen
    public void start(Session session) throws IOException {
        this.session = session;
        users.add(this);
        this.session.getBasicRemote().sendText("Olá " + username + " que sessão se deseja conectar? (1-99)");
    }

    @OnClose
    public void end() {
    	// clean up once the WebSocket connection is closed
        users.remove(this);
    }

    @OnMessage
    public void receiveMessage(String message) throws IOException {
		// one should never trust the client, and sensitive HTML
        // characters should be replaced with &lt; &gt; &quot; &amp;
        if(sessionNumber == -1){
            sessionNumber = Integer.parseInt(message);
            this.session.getBasicRemote().sendText("Conectado à sessão: " + sessionNumber);
            message = "*" + username + "* connected.";
            sendMessage(message, sessionNumber);
        }else{
            String upperCaseMessage = message.toUpperCase();
            sendMessage("[" + username + "] " + upperCaseMessage, sessionNumber);
        }
    }
    
    @OnError
    public void handleError(Throwable t) {
    	t.printStackTrace();
    }

    private void sendMessage(String text, int sessionNumber) {
    	// uses *this* object's session to call sendText()
    	for(WebSocketAnnotation i : users) {
            try {
                if(i.sessionNumber == sessionNumber){
                    i.session.getBasicRemote().sendText(text);
                }
            } catch (IOException e) {
                // clean up once the WebSocket connection is closed
                try {
                    i.session.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
