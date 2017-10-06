package chatbotproject;

public class ChatbotDavid implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private String[] Mobas;
	private String[] Sandboxes;
	private boolean isSandbox;
	private boolean isMoba;
	private boolean chatting;
	private String[] unknownGames = {null, null, null, null};
	private boolean wasLearned1 = false;
	private boolean wasLearned2 = false;
	private boolean wasLearned3 = false;
	private boolean wasLearned0 = false;
	
	public ChatbotDavid() {
		String[] temp2 = {"lol","smite","awesomenauts","dota","heros of the storm","league of legends"};
		String[] temp3 = {"minecraft","terraria","gmod","gta","no man's sky","garrys mod","garry's mod"};
		String[] temp = {"mobas","moba","sandboxes","sand-boxes","sandbox","sand-box"};
		keywords = temp;
		Mobas = temp2;
		Sandboxes = temp3;
		goodbyeWord = "bye";
		secretWord = "wuh?";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length;i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0) {
				if(i > 1) {
					isSandbox = true;
					isMoba = false;
				}
				 else {
					isSandbox = false;
					isMoba = true;
				}
					return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		if(isMoba)
			ChatbotMain.print("Whats your favorite Moba?");
		if(isSandbox)
			ChatbotMain.print("Whats your favorite sandbox game?");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			String favoriteGame = response;
			favoriteGame = favoriteGame.toLowerCase();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) 
				ChatbotMain.print("I'm just as confused?");
			else if(isSandbox)
				sandBoxes(favoriteGame);
			else if(isMoba)
				mobas(favoriteGame);	
			else {
				ChatbotMain.print("Wuh? Repeat please.");
			}
	}
}

	public void sandBoxes(String response) {
			boolean wasFound = false;
		for(int i = 0; i < Sandboxes.length; i++) {
			if(Sandboxes[i].contains(response)) 
			{
				ChatbotMain.print("I love " + response + " too! Whats another Sandbox game do you like?");
				wasFound =true;
			}
			else {
				for(int h = 0; h < Mobas.length; h++)
				{
					if(Mobas[h].contains(response)){
						ChatbotMain.print("Hey! " + response + " is a moba!");
						return;
					}
				}
			
			} 
		}	
		if(!wasFound) 
		{
					for(int j = 0; j < unknownGames.length; j++) 
					{
					/*  Test
					    if(wasLearned) 
						ChatbotMain.print("nice");
						else
							ChatbotMain.print("not nice");
					*/	
						if((wasLearned1 || wasLearned2 || wasLearned3 || wasLearned0) && unknownGames[j] != null && unknownGames[j].contains(response)) 
						{
							ChatbotMain.print("Thanks for teaching me about " + response);
							return;
						}
						
						else if(unknownGames[j] == null) 
						{
							unknownGames[j] = response;
							ChatbotMain.print("I've never heard of that game before.");
							notWasLearned(j);
							return;
						}
							
					}
				if(unknownGames[3] != null)
					ChatbotMain.print("Sorry, I can't remember so many new games!");
				return;
		}
	}

	public void mobas(String response) {
		
	}
	
	private void notWasLearned(int num) {
		if(num == 0)
			wasLearned0 = !wasLearned0;
		if(num == 1)
			wasLearned1 = !wasLearned1;
		if(num == 0)
			wasLearned2 = !wasLearned2;
		if(num == 0)
			wasLearned3 = !wasLearned3;
	}
}