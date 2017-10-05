package chatbotproject;

public class ChatbotTyler implements Topic {
	private String[] keywords;
	private String goodbyewords;
	private String secretWord;
	private String[] shooters = {"fps", "first person shooter", "shooting", "1st person", "3rd person", "third person", "shooter"};
	private String[] platform = {"platform", "platforming", "sidescroller", "platformer", "side scrolling","jeff dunham"};
	private String[] rShooters = {"Doom", "Quake", "Call of Duty", "Halo", "Gears of War"};
	private String[] rPlat = {"Super Mario Bros","Sonic the Hedgehog", "Rayman", "Super Meat Boy", "Cuphead","Duck Game"};
	private String[] negativeWord = {"hate", "don't like", "don't love", "horrible"};
	private boolean chatting; 
	private boolean isShoot = false;
	private boolean isPlat = false;
	public ChatbotTyler() {
		goodbyewords = "jeff";
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
		for(int i = 0; i < games.length; i++)
		{
			if(ChatbotMain.findKeyword(response,games[i],0) >= 0) 
			{
				rec = (int)(Math.random()*games.length);
				
				ChatbotMain.print("I like " + response + " too, you should check out " + games[rec]);
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
			if(isShoot) {
				giveRec(rShooters, response);
			}
			if(isPlat) {

			giveRec(rPlat, response);	
			}
				/*if (ChatbotMain.findKeyword(response,"hate",0) || ChatbotMain.findKeyword(response,"don't like",0) || ChatbotMain.findKeyword(response,"do not like",0)) {
			ChatbotMain.print("Hey, I didn't ask for a game you don't like, please tell me a game you do like!");	
			}}
			if (ChatbotMain.) */
				if (ChatbotMain.findKeyword(response,goodbyewords, 0)>=0) {
					chatting = false;
					ChatbotMain.chatbot.startTalking();
				}else if (ChatbotMain.findKeyword(response, secretWord, 0) >=0) {
					ChatbotMain.print("Cool! You guessed my favorite thing ever. We are friends now.");		
				}else {

					ChatbotMain.print("what");
				}

			}
		}
	}
	

	

