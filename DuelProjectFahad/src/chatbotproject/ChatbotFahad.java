package chatbotproject;

public class ChatbotFahad implements Topic {

	private boolean round = true;
	private boolean fRound = true;
	private boolean rRound = true;
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
				if(round) {
					botFighting = "";
					botRPG = "";
					round = false;
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
				ChatbotMain.print("I happen to know alot of fighting games. Here is a list of some:");
				chatFighting(response);
				System.out.println("My favorite fighter game has to be " + botFighting + "\n" + "What's Yours?");
				fRound = false;
			}
			else {
				guessFight(response);
			}
		}
		if(role) {
			if(rRound) {
				ChatbotMain.print("I happen to know alot of role-play games. Here is a list of some:");
				chatRPG(response);
				System.out.println("My favorite RPG has to be " + botRPG + "\n" + "What's Yours?");
				rRound = false;
			}
			else {
				guessFight(response);
			}
		}
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(fight) {	
				for(int i = 0; i < fighting.length;i++){
					if(ChatbotMain.findKeyword(response,fighting[i],0) >= 0) {
						if(response.equals(botFighting)) {
							System.out.println("Oh wow! We both love the same fighting game. That's amazing");
						}
						else {
							System.out.println("Oh cool. I've heard of that one.");
							userFighting = response;
						}
					}
				}
				for(int j = 0; j < rolePlay.length;j++){
					if(ChatbotMain.findKeyword(response,rolePlay[j],0) >= 0) {
						System.out.println("That's an RPG, not a fighter");
					}
				}
			}
			else if(role) {	
				for(int i = 0; i < rolePlay.length;i++){
					if(ChatbotMain.findKeyword(response,rolePlay[i],0) >= 0) {
						if(response.equals(botRPG)) {
							System.out.println("Oh wow! We both love the same RPG. That's amazing");
						}
						else {
							System.out.println("Oh cool. I've heard of that one.");
							userFighting = response;
						}
					}
				}
				for(int j = 0; j < fighting.length;j++){
					if(ChatbotMain.findKeyword(response,fighting[j],0) >= 0) {
						System.out.println("That's a fighter, not an RPG");
					}
				}
			}	
			else if(ChatbotMain.findKeyword(response,goodbyeWords,0) >= 0) {
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
		int randInt = (int)(Math.random()* fighting.length);
		for(int i = 0;i < fighting.length; i++) {
			result = result + fighting[i] + "\n"; 
		}
		if(botFighting.equals("")) {
			botFighting = fighting[randInt];
		}
		System.out.println(result);
	}

	public void chatRPG(String response) {
		String result = "";
		int randInt = (int)(Math.random()* rolePlay.length);
		for(int i = 0;i < rolePlay.length; i++) {
			result = result + rolePlay[i] + "\n"; 
		}
		if(botRPG.equals("")) {
			botRPG = rolePlay[randInt];
		}
		System.out.println(result);
	}
	
	public void guessFight(String response) {
		if(fight) {
			System.out.println("So you want to talk about fighting games again. Do you remember which was my favorite?");
			if(response.equals(botFighting)) {
				ChatbotMain.print("Hooray! You remembered what it was!");
			}
			else {
				ChatbotMain.print("Ow wow! How do you not remember? It's " + botFighting + ". I still remember that yours is " + userFighting + ".");
			}
		}
		if(role) {
			System.out.println("So you want to talk about RPGs again. Do you remember which was my favorite?");
			if(response.equals(botRPG)) {
				ChatbotMain.print("Hooray! You remembered what it was!");
			}
			else {
				ChatbotMain.print("Ow wow! How do you not remember? It's " + botRPG + ". I still remember that yours is " + userRPG + ".");
			}
		}
	}

}
