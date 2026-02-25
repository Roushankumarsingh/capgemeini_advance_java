package Task;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Email implements Notification {
	public void sendNotification(String msg) {
		System.out.println("Message is :- " + msg);
	}
}
