package chatbotproject;

public class ChatbotTyler implements Topic {
	private String[] keywords;
	private String goodbyewords;
	private String secretWord;
	private String[] rshooters = {"Doom", "Quake", "Call of Duty", "Halo", "Gears of War"};
	private String[] rplatformers = {"Super Mario Bros","Sonic the Hedgehog", "Rayman", "Super Meat Boy", "Cuphead","Duck Game"};
	private boolean chatting; 
	
	public ChatbotTyler() {
		String[] temp = {"platformer","shooter","fps","third person", "platforming"};
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
		ChatbotMain.print("Suh dude! I'm a fan of that game genre as well!");
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
