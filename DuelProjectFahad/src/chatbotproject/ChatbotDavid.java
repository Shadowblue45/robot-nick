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
	private String[] unknownSanboxGames = {null, null, null, null};
	private String[] unknownMobaGames = {null, null, null, null};
	private boolean wasLearnedSanbox1 = false;
	private boolean wasLearnedSanbox2 = false;
	private boolean wasLearnedSanbox3 = false;
	private boolean wasLearnedSanbox0 = false;
	private boolean wasLearnedMoba1 = false;
	private boolean wasLearnedMoba2 = false;
	private boolean wasLearnedMoba3 = false;
	private boolean wasLearnedMoba0 = false;
	
	public ChatbotDavid() {
		String[] temp2 = {"lol","smite","awesomenauts","dota","hos"};
		String[] temp3 = {"minecraft","terraria","gmod","gta","nms","garrys mod","garry's mod"};
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
					for(int j = 0; j < unknownSanboxGames.length; j++) 
					{
					/*  Test
					    if(wasLearned) 
						ChatbotMain.print("nice");
						else
							ChatbotMain.print("not nice");
					*/	
						if((wasLearnedSanbox1 || wasLearnedSanbox2 || wasLearnedSanbox3 || wasLearnedSanbox0) && unknownSanboxGames[j] != null && unknownSanboxGames[j].contains(response)) 
						{
							ChatbotMain.print("Thanks for teaching me about " + response);
							return;
						}
						
						else if(unknownSanboxGames[j] == null) 
						{
							unknownSanboxGames[j] = response;
							ChatbotMain.print("I've never heard of that game before.");
							notWasLearnedSandbox(j);
							return;
						}
							
					}
				if(unknownSanboxGames[3] != null)
					ChatbotMain.print("Sorry, I can't remember so many new games!");
				return;
		}
	}

	public void mobas(String response) {
		boolean wasFound = false;
		for(int i = 0; i < Mobas.length; i++) {
			if(Mobas[i].contains(response)) 
			{
				ChatbotMain.print("I love " + response + " too! Whats another Moba game do you like?");
				wasFound =true;
			}
			else {
				for(int h = 0; h < Sandboxes.length; h++)
				{
					if(Sandboxes[h].contains(response)){
						ChatbotMain.print("Hey! " + response + " is a sandbox!");
						ChatbotMain.print("Sorry, I can't remember so many new games! Would you like to talk about fighters or RPGs?");
						response = ChatbotMain.getInput();
						if(response.equals("yes") || response.equals("sure") || response.equals("ok")) {
							ChatbotMain.print("Fighters or RPGs?");
							response = ChatbotMain.getInput();
							Topic fahad = ChatbotMain.chatbot.getChatbotFahad();
								if(fahad.isTriggered(response)) {
									chatting = false;
									fahad.startChatting(response);
								}	
								else if(response.equals("fighters") || response.equals("rpgs")) {
									chatting = false;
									fahad.startChatting(response);
								}
								else {
									ChatbotMain.print("What is you're favorite Sandbox game?");
								}
						return;
					}
				}
			
			} 
		}	
		if(!wasFound) 
		{
					for(int j = 0; j < unknownMobaGames.length; j++) 
					{
					/*  Test
					    if(wasLearned) 
						ChatbotMain.print("nice");
						else
							ChatbotMain.print("not nice");
					*/	
						if((wasLearnedMoba1 || wasLearnedMoba2 || wasLearnedMoba3 || wasLearnedMoba0) && unknownMobaGames[j] != null && unknownMobaGames[j].contains(response)) 
						{
							ChatbotMain.print("Thanks for teaching me about " + response);
							return;
						}
						
						else if(unknownMobaGames[j] == null) 
						{
							unknownMobaGames[j] = response;
							ChatbotMain.print("I've never heard of that game before.");
							notWasLearnedMoba(j);
							return;
						}
							
					}
				if(unknownMobaGames[3] != null)
					ChatbotMain.print("Sorry, I can't remember so many new games! Would you like to talk about fighters or RPGs?");
				response = ChatbotMain.getInput();
				if(response.equals("yes") || response.equals("sure") || response.equals("ok")) {
					ChatbotMain.print("Fighters or RPGs?");
					response = ChatbotMain.getInput();
					Topic fahad = ChatbotMain.chatbot.getChatbotFahad();
						if(fahad.isTriggered(response)) {
							chatting = false;
							fahad.startChatting(response);
						}	
						else if(response.equals("fighters") || response.equals("rpgs")) {
							chatting = false;
							fahad.startChatting(response);
						}
						else {
							ChatbotMain.print("What is you're favorite Moba?");
						}
				}
					
				return;
		}
	}
}
	
	private void notWasLearnedSandbox(int num) {
		if(num == 0)
			wasLearnedSanbox0 = !wasLearnedSanbox0;
		if(num == 1)
			wasLearnedSanbox1 = !wasLearnedSanbox1;
		if(num == 2)
			wasLearnedSanbox2 = !wasLearnedSanbox2;
		if(num == 3)
			wasLearnedSanbox3 = !wasLearnedSanbox3;
	}
	private void notWasLearnedMoba(int num) {
		if(num == 0)
			wasLearnedMoba0 = !wasLearnedMoba0;
		if(num == 1)
			wasLearnedMoba1 = !wasLearnedMoba1;
		if(num == 2)
			wasLearnedMoba2 = !wasLearnedMoba2;
		if(num == 3)
			wasLearnedMoba3 = !wasLearnedMoba3;
	}
}