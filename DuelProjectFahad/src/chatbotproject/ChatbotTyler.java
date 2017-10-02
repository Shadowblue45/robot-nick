package chatbotproject;

public class ChatbotTyler implements Topic {
	private String[] keywords;
	private String goodbyewords;
	private String secretWord;
	private String[] shooters = {"Doom", "Quake", "Call of Duty", "Halo", "Gears of War"};
	private String[] platformers = {"Super Mario Bros","Sonic the Hedgehog", "Rayman", "Super Meat Boy", "Cuphead"};
	private boolean chatting; 
	
	public ChatbotTyler() {
		String[] temp = {"","","",""};
		keywords = temp;
		String temp2 = "jeff";
		goodbyewords = temp2;
		secretWord = "doge";
		
	}
	
	public boolean isTriggered(String response) {
		for (int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0)>= 0)
				return true;
		}
		return false;	
	}
	
	
	public void startChatting(String response) {
		ChatbotMain.print("Suh dude! It sounds like we have something in common!");
		chatting = true;
		while (chatting) {
			 response = ChatbotMain.getInput();
			if (ChatbotMain.findKeyword(response,goodbyewords, 0)>=0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if (ChatbotMain.findKeyword(response, secretWord, 0) >=0) {
				ChatbotMain.print("Cool! You guessed my favorite thing ever. We are friends now.");		
			}else {
				
				ChatbotMain.print("what");
			}
			
		}
	}
}
