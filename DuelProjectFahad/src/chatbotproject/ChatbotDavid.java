package chatbotproject;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotDavid() {
		String[] temp = {"Mobas","moba","mobas","Moba"};
		mobas = temp;
		String[] temp = {"sandbox","sand-box"};
		sandboxes = temp;
		goodbyeWord = "bye";
		secretWord = "wuh?";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < mobas.length;i++) {
			if(ChatbotMain.findKeyword(response, mobas[i], 0) >= 0) {
				return true;
			if(ChatbotMain.findKeyword(response, sandboxes[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		if(ChatbotMain.findKeyword(response, mobas[i], 0) >= 0) {
			ChatbotMain.print("What Moba do you like?");
		if(ChatbotMain.findKeyword(response, sandboxes[i], 0) >= 0) {
			ChatbotMain.print("What sandbox you like?");
		}
		ChatbotMain.print("");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("I'm just as confused?");
			} else {
				ChatbotMain.print("Wuh? Repeat please.");
			}
		}
	}

}
