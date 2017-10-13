package chatbotproject;

public class ChatbotTyler implements Topic {
	private String[] keywords;
	private String goodbyewords;
	private String secretWord;
	private String[] shooters = {"fps", "first person shooter", "shooting", "1st person", "3rd person", "third person", "shooter"};
	private String[] platform = {"platform", "platforming", "sidescroller", "platformer", "side scrolling","jeff dunham"};
	private String[] rShooters = {"Doom", "Quake", "Call of Duty", "Halo", "Gears of War"};
	private String[] rPlat = {"Super Mario Bros","Sonic the Hedgehog", "Rayman", "Super Meat Boy", "Cuphead","Duck Game"};
	private String[] confused = {"I've never heard of that game, are you sure it's the right genre?", "Is that a game or not", "What???", "If that's a game thanks for telling me."};
	private String[] hate = {"Hey I asked you to tell me a game you like, not hate!", "I think you misunderstood the question! Tell me a game you like.", "Please don't tell me a game you hate!"};
	private boolean chatting; 
	private boolean isShoot = false;
	private boolean isPlat = false;
	public ChatbotTyler() {
		goodbyewords = "bye";
		secretWord = "doge";

	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < platform.length;i++) {
			if(ChatbotMain.findKeyword(response, platform[i], 0) >= 0) {
				isPlat = true;
				return true;
			}
		}
		for(int i = 0; i <  shooters.length;i++) {
			if(ChatbotMain.findKeyword(response, shooters[i], 0) >= 0) {
				isShoot = true;
				return true;
			}
		}
		return false;
	}


	public void giveRec(String[] games , String response) {
		int rec = 0;
		int notFound = 0;
		int confuse = 0;
		int hatte = 0;
		for(int i = 0; i < games.length; i++)
		{
			
			String game = "";
			final String[] splitData = response.split(" ");

			 if(ChatbotMain.findKeyword(response,games[i],0) >= 0) 
			{
				rec = (int)(Math.random()*games.length);
				if(response == games[rec]) {
					rec = (int)(Math.random()*games.length);
				}
				else 
				{
					ChatbotMain.print("I like " + response + " too, you should check out " + games[rec]);			
				}
			}
			 else if(response.toLowerCase().contains("hate") || (response.toLowerCase().contains("don't like")) || (response.toLowerCase().contains("stinks"))){
				    game = splitData[splitData.length - 1];
	            }
	            if (!game.isEmpty()) {
	            	hatte = (int)(Math.random()*hate.length);
	            	ChatbotMain.print(hate[hatte]);
	                break;
	            }
	    	if((ChatbotMain.findKeyword(response,games[i],0) == -1) )		{
	    			
	    			notFound++;

	    		}
	    	if(notFound == games.length) {
	    			confuse = (int)(Math.random()*confused.length);
	    			ChatbotMain.print(confused[confuse]);
	    		}
			
					
			}
		

		
	}	
	
	 
	public void startChatting(String response) {
		if (isShoot) {
			ChatbotMain.print("I too like shooters, is there any particular shooter game you're a big fan of?");
		}
		if (isPlat)
		{	
			ChatbotMain.print("I too like platformers, is there any particular platformer game you're a big fan of?");
		}
		chatting = true;
		while (chatting) {
			response = ChatbotMain.getInput();

				/*if (ChatbotMain.findKeyword(response,"hate",0) || ChatbotMain.findKeyword(response,"don't like",0) || ChatbotMain.findKeyword(response,"do not like",0)) {
			ChatbotMain.print("Hey, I didn't ask for a game you don't like, please tell me a game you do like!");	
			}}
			if (ChatbotMain.) */
			 if (ChatbotMain.findKeyword(response,goodbyewords, 0)>=0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				}else if (ChatbotMain.findKeyword(response, secretWord, 0) >=0) {
					ChatbotMain.print("Cool! You guessed my favorite thing ever. We are friends now.");		
				}
				else if(isShoot) {
					giveRec(rShooters, response);
				}
				else if(isPlat) {

				giveRec(rPlat, response);	
				}
				
				else {

					ChatbotMain.print("what");
				}

			}
		}
	}
	 

	

