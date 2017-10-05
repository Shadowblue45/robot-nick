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
	private boolean wasLearned = false;
	
	public ChatbotDavid() {
		String[] temp2 = {"LOL","Smite","Awesomenauts","Dota","Heros of the Storm"};
		String[] temp3 = {"Minecraft","Terraria","Gmod","GTA","No Man's Sky"};
		String[] temp = {"Mobas","moba","mobas","Moba","sandboxes","sand-boxes","sandbox","sand-box"};
		keywords = temp;
		Mobas = temp2;
		Sandboxes = temp3;
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
			if(isSandbox)
				sandBoxes(favoriteGame);
			else if(isMoba)
				mobas(favoriteGame);
			else if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("I'm just as confused?");
			} else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				
				}else {
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
						if(wasLearned && unknownGames != null && unknownGames[j].contains(response)) 
						{
							ChatbotMain.print("Thanks for teaching me about" + response);
						}
						
						else if(unknownGames[j] == null) 
						{
							unknownGames[j] = response;
							ChatbotMain.print("I've never heard of that game before.");
							notWasLearned();
							return;
						}
							
					}
				if(unknownGames[3] != null)
					ChatbotMain.print("Sorry, I can't remember so many new games!");
		}
	}

	public void mobas(String response) {
		
	}
	
	private void notWasLearned() {
		wasLearned = !wasLearned;
	}
}