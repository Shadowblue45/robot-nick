package chatbotproject;

public class Chatbot {

		private String userName;
		private Topic fahad;
		private boolean chatting;
		
		
		public Chatbot() {
			fahad = new ChatbotFahad();
			userName = "unknown user";
		}
		
		public void startTalking() {
			ChatbotMain.print("Welcome to our chatbot! What is your name?");
			userName = ChatbotMain.getInput();
			chatting = true;
			while(chatting) {
				ChatbotMain.print("What do you want to talk about?");
				String response = ChatbotMain.getInput();
				if(fahad.isTriggered(response)) {
					chatting = false;
					fahad.startChatting(response);
		
				}
				else {
					ChatbotMain.print("I'm sorry. I dont understand what you are talking about?");
				}
			}
		}
}
