package chatbotproject;

public class ChatbotFahad implements Topic  {

	private boolean round = true;
	private boolean fRound = true;
	private boolean rRound = true;
	private boolean wordRPG;
	private boolean wordFight;
	private String[] keywords;
	private String goodbyeWords;
	private String secretWord;
	private boolean fight = false;
	private boolean role = false;
	private String botRPG = "";
	private String userRPG = "";
	private String botFighting = "";
	private String userFighting = "";
	private String[] fighting = {"Guilty Gear", "King of Fighters", "Skull Girls", "Mortal Kombat", "Injustice"};
	private String[] rolePlay = {"The Witcher", "Skyrim", "Devil May Cry", "Pokemon","Just Cause"};
	public boolean chatting;

	public ChatbotFahad() {
		String[] temp = {"fighting","fighter","RPG","role-play games","role play games"};
		keywords = temp;
		String temp2 ="stop";
		goodbyeWords = temp2;
		secretWord = "Destiny";
	}

	@Override
	public boolean isTriggered(String response) {
		if(round) {
			round = false;
			botFighting = "";
			botRPG = "";
		}
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
			if(fRound) {
				chatFighting(response);
			}
			else {
				System.out.println("So you want to talk about fighting games again. Do you remember which was my favorite?");
			}
		}
		else if(role) {
			if(rRound) {
				chatRPG(response);
			}
			else {
				System.out.println("So you want to talk about RPGs again. Do you remember which was my favorite?");
			}
		}
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.chatbot.getChatbotDavid().isTriggered(response)) {
				chatting = false;
				ChatbotMain.chatbot.getChatbotDavid().startChatting(response);
			}
			else if(ChatbotMain.findKeyword(response,goodbyeWords,0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}
			else if(ChatbotMain.findKeyword(response, secretWord,0) >= 0) {
				ChatbotMain.print("Yes! That is my favorite game to play with friends. I love pwning all the n00bs in PvP.");
			}
			else if(fight && fRound) {	
				for(int i = 0; i < fighting.length;i++){
					if(ChatbotMain.findKeyword(response,fighting[i],0) >= 0) {
						wordFight = true;
						wordRPG = false;
					}
				}
				for(int j = 0; j < rolePlay.length;j++){
					if(ChatbotMain.findKeyword(response,rolePlay[j],0) >= 0) {
						wordFight = false;
						wordRPG = true;
					}
				}
				if(wordFight) {
					for(int i = 0; i < fighting.length;i++){
						if(ChatbotMain.findKeyword(response,fighting[i],0) >= 0) {
							if(fighting[i].equals(botFighting)) {
								ChatbotMain.print("Oh wow! We both love the same fighting game. That's amazing");
								userFighting = response;
							}
							else {
								ChatbotMain.print("Oh cool. I've heard of that one.");
								userFighting = response;
							}
						}
						fRound = false;
					}
				}
				else if(wordRPG){
					ChatbotMain.print("That's an RPG, not a fighter");
				}
			}
			else if(role && rRound) {	
				for(int i = 0; i < rolePlay.length;i++){
					if(ChatbotMain.findKeyword(response,rolePlay[i],0) >= 0) {
						wordFight = false;
						wordRPG = true;
					}
				}
				for(int j = 0; j < fighting.length;j++){
					if(ChatbotMain.findKeyword(response,fighting[j],0) >= 0) {
						wordFight = true;
						wordRPG = false;
					}
				}
				if(wordRPG) {
					for(int i = 0; i < rolePlay.length;i++){
						if(ChatbotMain.findKeyword(response,rolePlay[i],0) >= 0) {
							if(rolePlay[i].equals(botRPG)) {
								ChatbotMain.print("Oh wow! We both love the same RPG. That's amazing");
								userRPG = response;
							}
							else {
								ChatbotMain.print("Oh cool. I've heard of that one.");
								userRPG = response;
							}
						}
						rRound = false;
					}
				}
				else if(wordFight){
					ChatbotMain.print("That's a fighter, not an RPG");
				}
			}
			else if(!fRound && fight) {
				guessFav(response);
			}
			else if(role && !rRound) {
				guessFav(response);
			}
			else {
				ChatbotMain.print("Nani did you say to watashi?");
			}
		}
	}

	public void chatFighting(String response) {
		String result = "";
		int randInt = (int)(Math.random()* fighting.length);
		ChatbotMain.print("I happen to know alot of fighting games. Here is a list of some:");
		for(int i = 0;i < fighting.length; i++) {
			result = result + fighting[i] + "\n"; 
		}
		if(botFighting.equals("")) {
			botFighting = fighting[randInt];
		}
		System.out.println(result);
		System.out.println("My favorite fighter game has to be " + botFighting + "\n" + "What's Yours?");
	}

	public void chatRPG(String response) {
		String result = "";
		int randInt = (int)(Math.random()* rolePlay.length);
		ChatbotMain.print("I happen to know alot of role-play games. Here is a list of some:");
		for(int i = 0;i < rolePlay.length; i++) {
			result = result + rolePlay[i] + "\n"; 
		}
		if(botRPG.equals("")) {
			botRPG = rolePlay[randInt];
		}
		System.out.println(result);
		System.out.println("My favorite RPG has to be " + botRPG + "\n" + "What's Yours?");
	}
	
	public void guessFav(String response) {
		if(fight) {
			if(response.toLowerCase().equals(botFighting.toLowerCase())) {
				ChatbotMain.print("Hooray! You remembered what it was!");
			}
			else {
				ChatbotMain.print("Ow wow! How do you not remember? It's " + botFighting + ". I still remember that yours is " + userFighting + ".");
			}
		}
		else if(role) {
			if(response.toLowerCase().equals(botRPG.toLowerCase())) {
				ChatbotMain.print("Hooray! You remembered what it was!");
			}
			else {
				ChatbotMain.print("Ow wow! How do you not remember? It's " + botRPG + ". I still remember that yours is " + userRPG + ".");
			}
		}
	}

}
