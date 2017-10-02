package chatbotproject;

public class Chatbot {

		private String userName;
		private Topic fahad;
		private Topic tyler;
		private Topic david;
		private boolean chatting;
		
		
		public Chatbot() {
			fahad = new ChatbotFahad();
			david = new ChatbotDavid();
			tyler = new ChatbotTyler();
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
				else if(david.isTriggered(response)) {
						chatting = false;
						david.startChatting(response);
				}
				else if(tyler.isTriggered(response)) {
					chatting = false;
					tyler.startChatting(response);
				}
				else {
					ChatbotMain.print("I'm sorry. I dont understand what you are talking about?");
				}
			}
		}
}
