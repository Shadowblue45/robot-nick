package chatbotproject;

public class ChatbotTyler implements Topic {
	private String[] keywords;
	private String goodbyewords;
	private String secretWord;
	private String[] shooters = {"fps", "first person shooter", "shooting", "1st person", "3rd person", "third person"};
	private String[] platform = {"platform", "platforming", "sidescroller", "platformer", "side scrolling"};
	private String[] rshooters = {"Doom", "Quake", "Call of Duty", "Halo", "Gears of War"};
	private String[] rplatformers = {"Super Mario Bros","Sonic the Hedgehog", "Rayman", "Super Meat Boy", "Cuphead","Duck Game"};
	private boolean chatting; 
	
	public ChatbotTyler() {
		goodbyewords = "jeff";
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
		ChatbotMain.print("I too like shooters, is there any particular shooter game you're a big fan of?");
		
		/* 	ChatbotMain.print("I too like platformers, is there any particular platformer game you're a big fan of?");
		*/
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
