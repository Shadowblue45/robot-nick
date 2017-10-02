package chatbotproject;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean isSandbox;
	private boolean isMoba
	private boolean chatting;
	
	public ChatbotDavid() {
		String[] temp = {"Mobas","moba","mobas","Moba","sandbox","sand-box"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "wuh?";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length;i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				if(i > 3) {
					isSandbox = true;
					isMoba = false;
				}
				isSandbox = false;
				isMoba = true;
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("So which game in this genre do you want to talk about?");
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
