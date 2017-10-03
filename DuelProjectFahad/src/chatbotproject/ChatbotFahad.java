package chatbotproject;

public class ChatbotFahad implements Topic {

	private String[] keywords;
	private String goodbyeWords;
	private String secretWord;
	private boolean fight = false;
	private boolean role = false;
	private String[] fighting = {"Guilty Gear", "King of Fighters", "Skull Girls", "Mortal Kombat", "Injustice"};
	private String[] rolePlay = {"The Witcher", "Skyrim", "Devil May Cry", "Pokemon","Just Cause"};
	public boolean chatting;

	public ChatbotFahad() {
		String[] temp = {"fighting","fighter","RPG","role-play games","role play games"};
		keywords = temp;
		String temp2 ="stop";
		goodbyeWords = temp2;
		secretWord = "pug";
	}

	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length;i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >=0) {
				if(i < 2) {
					fight = true;
					role = false;
				}
				else {
					role = true;
					fight = false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		if(fight) {
			ChatbotMain.print("I happen to know alot of fighting games. Here is a list of some:");
			chatFighting(response);
		}
		if(role) {
			ChatbotMain.print("I happen to know alot of role-play games. Here is a list of some:");
			chatRPG(response);
		}
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

	public void chatFighting(String response) {
		String result = "";
		for(int i = 0;i < fighting.length; i++) {
			result = result + fighting[i] + "\n"; 
		}
		System.out.println(result);
	}

	public void chatRPG(String response) {
		String result = "";
		for(int i = 0;i < rolePlay.length; i++) {
			result = result + rolePlay[i] + "\n"; 
		}
		System.out.println(result);
	}

}
