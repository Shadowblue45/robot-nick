package chatbotproject;

public class Chatbot {

		private String userName;
		private Topic fahad;
		private Topic tyler;
		private Topic david;
		private boolean chatting;
		private boolean first = true;
		private String previousResponse = "";
		private int botFrustration = 0;
		
		
		public Chatbot() {
			fahad = new ChatbotFahad();
			david = new ChatbotDavid();
			tyler = new ChatbotTyler();
			userName = "unknown user";
		}
		
		public Topic getChatbotFahad() {
			return fahad;
		}
		
		public Topic getChatbotDavid() {
			return david;
		}
		
		public void startTalking() {
			ChatbotMain.print("Welcome to Gamebot-nick, the bot dedicated to video games. What is your name?");
			userName = ChatbotMain.getInput();
			chatting = true;
			while(chatting) {
				if(first) {
					ChatbotMain.print("Hello " + userName + ". What game genre do you want to talk about?");
					first = false;
				}
				else {
					ChatbotMain.print("What genre do you want to talk about?");
				}
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
				else if(previousResponse.equals(response)) {
					if(botFrustration <= 2) {
						ChatbotMain.print("Sorry, you already said that.");
					}
					if(botFrustration > 2 && botFrustration <= 4) {
						ChatbotMain.print("You keep repeating yourself.");
					}
					if(botFrustration > 4 && botFrustration <= 6) {
						ChatbotMain.print("Can you stop reapeating yourself already?");
					}
					if(botFrustration > 6 && botFrustration <= 8) {
						ChatbotMain.print("STOP REPEATING YOURSELF!!!");
					}
					if(botFrustration > 8) {
						ChatbotMain.print("I'VE HAD ENOUGH!!! GOODBYE FOREVER!!!");
					}
					while(botFrustration > 8) {
						
					}
					botFrustration++;
				}
				else {
					ChatbotMain.print("I'm sorry. I dont understand what you are talking about?");
				}
				previousResponse = response;
			}
		}
}
