package chatbotproject;

public interface Topic {

	boolean isTriggered(String response);

	void startChatting(String response);
	
	String chatFighting(String response);
	
	String chatRPG(String response);

}
