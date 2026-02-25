package Task;

import org.springframework.stereotype.Component;

@Component
public class Sms {
	public void sendNotification(String msg) {
		System.out.println("Message is :- " + msg);
	}
}
