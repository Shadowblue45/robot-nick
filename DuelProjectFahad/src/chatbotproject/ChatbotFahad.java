package chatbotproject;

public class ChatbotFahad implements Topic {

	private String[] keywords;
	private String goodbyeWords;
	private String secretWord;
	private String[] fighting = {"Guilty Gear", "King of Fighters", "Skull Girls", "Mortal Kombat", "Injustice"};
	private String[] rolePlay = {"The Witcher", "Skyrim", "Devil May Cry", "Pokemon","Just Cause"};
	public boolean chatting;

	public ChatbotFahad() {
		String[] temp = {"RPG","fighting","fighter","role-play games","role play games"};
		keywords = temp;
		String temp2 ="stop";
		goodbyeWords = temp2;
		secretWord = "pug";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length;i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >=0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Hey! It sounds like you and i have common interests! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response,goodbyeWords,0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord,0) >= 0) {
				ChatbotMain.print("Oh my goodness! you guessed my favorite thing ever!");
			}
			else {
				ChatbotMain.print("Nani did you say to watashi?");
			}
		}
	}

}
