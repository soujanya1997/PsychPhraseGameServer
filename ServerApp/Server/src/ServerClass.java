
import java.awt.Color;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Vector;

class PlayerInfo{
String name;
int score=0;
int correctAns=0;

    PlayerInfo(String name){
        this.name=name;
        this.score=0;
        this.correctAns=0;
        
    }
    PlayerInfo(String name, int score){
        this.name=name;
        this.score=score;
        this.correctAns=0;
    }
}

class Options{
String name;
String option;

    Options(String name,String option){
        this.name=name;
        this.option=option;
    }
    
    public static void shuffleOptions(Vector<Options> options){
    Random r = new Random();
        for(int i = options.size() - 1; i > 0; i--){
            int rand = r.nextInt(i);
            Options temp = options.get(i);
            options.set(i,options.get(rand));
            options.set(rand,temp);
        }
    }

}
public class ServerClass extends UnicastRemoteObject implements ServerInterface
{
    static String ques[][] = new String[24][2];
    Vector<PlayerInfo> v1 = new Vector<PlayerInfo>();
    Vector<String> v3 = new Vector<String>();
    Vector<ClientInterface> v2 = new Vector<ClientInterface>();
    static int player_count=0,answercount=0,questionViewers=0;
    Vector<Options> options=new Vector<Options>();
    static int limit=0,q ;
    
    public static void initialiseQues(int type){
        
    
    if(type==3){
    
        limit = 23 ;
    ques[0][0]="Who is the 'Bharat Ka Veer Putra Aaccording to the title of a 2013 TV Series ?\n";
    ques[0][1]="maharana Pratap\n";

    ques[1][0]="In 2013, where did the natural calamity known as Himalayan tsunami occur?\n";
    ques[1][1]="uttrakhand\n";


    ques[2][0]="Which film is this song from ? one two three four get on the dance floor \n";
    ques[2][1]="chennai Express\n";


    ques[3][0]="Which of these sounds would you associate with the heart ?\n";
    ques[3][1]="Dhak Dhak\n";

    ques[4][0]="In the Ramayana, Which demon impersonated Rama's voice, screaming, Lakshman! Help me?\n";
    ques[4][1]="Maricha\n";


    ques[5][0]="Douglas Engelbert, who passed away in 2013, is credited as the inventor of which of these products ?\n";
    ques[5][1]="Computer Mouse\n";

    ques[6][0]="Who is the only leader to be elected Prime Minister of Pakistan three times ?\n";
    ques[6][1]="Nawaz Sharif\n";

    ques[7][0]="The black widow, which eats the male counterpart after mating, as a female species of which animal ?\n";
    ques[7][1]="Spider\n";

    ques[8][0]="OCD is common in\n";
    ques[8][1]="Teens and Young Adults\n";

    ques[9][0]="In 1850, the first experimental electric telegraph line in India was set up between Calcutta and which place ?\n";
    ques[9][1]="Diamond Harbour\n";

    ques[10][0]="The chief constituent of gobar gas is\n" ;
    ques[10][1]="methane\n" ;

    ques[11][0]="The Enron project is a\n" ;
    ques[11][1]="gas-fired power project\n" ;

    ques[12][0]="The chief purpose of crop rotation is to check the loss of top soil\n" ;
    ques[12][1]="of its mineral content\n" ;

    ques[13][0]="Entomology is the science that studies\n" ;
    ques[13][1]="Insects\n" ;

    ques[14][0]="Eritrea, which became the 182nd member of the UN in 1993, is in the continent of\n" ;
    ques[14][1]="Africa\n" ;

    ques[15][0]="Garampani sanctuary is located at\n" ;
    ques[15][1]="Diphu, Assam\n" ;

    ques[16][0]="Hitler party which came into power in 1933 is known as\n" ;
    ques[16][1]="Nazi Party\n" ;

    ques[17][0]="FFC stands for\n" ;
    ques[17][1]="Film Finance Corporation\n" ;

    ques[18][0]="The least multiple of 7, which leaves a remainder of 4, when divided by 6, 9, 15 and 18 is:\n" ;
    ques[18][1]="364\n" ;

    ques[19][0]="The greatest number which on dividing 1657 and 2037 leaves remainders 6 and 5 respectively, is:\n" ;
    ques[19][1]="127\n" ;

    ques[20][0]="Seats for Mathematics, Physics and Biology in a school are in the ratio 5 : 7 : 8. There is a proposal to increase these seats by 40%, 50% and 75% respectively. What will be the ratio of increased seats?\n" ;
    ques[20][1]="2 : 3 : 4\n" ;

    ques[21][0]="If a quarter kg of potato costs 60 paise, how many paise will 200 gm cost? \n" ;
    ques[21][1]="48 paise\n" ;

    ques[22][0]="Sakshi can do a piece of work in 20 days. Tanya is 25% more efficient than Sakshi. The number of days taken by Tanya to do the same piece of work is:\n" ;
    ques[22][1]="16\n" ;

    }
    else if(type==2){
        
    limit = 20 ;  
    
    ques[0][0]="What type of animal is the Disney character Pluto?\n";
    ques[0][1]="dog\n";

    ques[1][0]="Which Disney movie does the Cheshire Cat appear in?\n";
    ques[1][1]="Alice in Wonderland\n";


    ques[2][0]="What colour are Mickey Mouse’s shoes?\n";
    ques[2][1]="Yellow\n";


    ques[3][0]="Which creatures are known by the names of Dave, Stuart, Jerry, Jorge, Tim, Mark, Phil and Kevin?\n";
    ques[3][1]="Minions\n";

    ques[4][0]="What are the names of the three famous chipmunks?\n";
    ques[4][1]="Alvin Simon Theodore\n";


    ques[5][0]="Which Smurf falls over a lot and accidentally breaks things?\n";
    ques[5][1]="Clumsy Smurf\n";

    ques[6][0]="What colour were Dorothy's shoes in The Wizard of Oz Disney movie?\n";
    ques[6][1]="Red\n";

    ques[7][0]="From which Disney movie does the character Ariel originate? \n";
    ques[7][1]="Little Mermaid\n";

    ques[8][0]="From which movie did the song 'A spoon full of sugar' orginate?\n";
    ques[8][1]="Mary Poppins \n";

    ques[9][0]="What happens to Pinocchio every time he tells a lie?\n";
    ques[9][1]="his nose grows longer\n";

    ques[10][0]="From which movie do the characters Sully and Mike come from?\n" ;
    ques[10][1]="Monsters Inc.\n" ;

    ques[11][0]="Which fairytale character spins straw into gold?\n" ;
    ques[11][1]="Rumpelstiltskin\n" ;

    ques[12][0]="How did the witch try to kill Snow White?\n" ;
    ques[12][1]="Poisoned Apple\n" ;

    ques[13][0]="Who is the voice of Woody in the Toy Story trilogy?\n" ;
    ques[13][1]="Tom Hanks\n" ;

    ques[14][0]="Who plays Cinderella in the 2015 movie?\n" ;
    ques[14][1]="Lily James \n" ;

    ques[15][0]="Unscramble the following word to reveal the Mistress of All Evil: ELAMTNECIF\n" ;
    ques[15][1]="Maleficent \n" ;
    
    ques[16][0]="Which American actress has done voiceovers in A Bugs Life, Cars and Monster's Inc?\n" ;
    ques[16][1]="Bonnie Hunt\n" ;

    ques[17][0]="How many eyes does Stuart the Minion have?\n" ;
    ques[17][1]="Two\n" ;

    ques[18][0]="What colour is Tinkerbell's dress?\n" ;
    ques[18][1]="Green\n" ;

    ques[19][0]="In which Disney movie is a princess, who is about to be wed, sent to New York by a wicked queen?\n" ;
    ques[19][1]="Enchanted\n" ;
    }
    else if(type==1){
        
    limit = 15 ;  
        
    ques[0][0]="What are the three types of most important fuels?\n";
    ques[0][1]="Coal oil natural gas\n";

    ques[1][0]="What is the strongest muscle in the human body?\n";
    ques[1][1]="tongue\n";


    ques[2][0]="Which gas do plants absorb from the atmosphere?\n";
    ques[2][1]="Carbon Dioxide\n";


    ques[3][0]="Which element is graphite composed of?\n";
    ques[3][1]="Carbon\n";

    ques[4][0]="What is the name given to the study of plants?\n";
    ques[4][1]="Botany\n";


    ques[5][0]="Where is the largest bone in the human body?\n";
    ques[5][1]="In leg\n";

    ques[6][0]="What kind of plant has no roots, stem or leaves?\n";
    ques[6][1]="fungus\n";

    ques[7][0]="Who invented the hovercraft?\n";
    ques[7][1]="Christopher Cockerell\n";

    ques[8][0]="What are gum trees better known as?\n";
    ques[8][1]="Eucalyptus trees\n";

    ques[9][0]="Where are red blood cells made?\n";
    ques[9][1]="In bone marrow\n";

    ques[10][0]="Which two metals have to be combined to make bronze?\n" ;
    ques[10][1]="Copper and tin\n" ;

    ques[11][0]="Who invented the telephone?\n" ;
    ques[11][1]="Alexander Graham Bell\n" ;

    ques[12][0]="What is the fermented juice of apples better known as?\n" ;
    ques[12][1]="Cider\n" ;

    ques[13][0]="What is the largest artery in the body?\n" ;
    ques[13][1]="Aorta\n" ;

    ques[14][0]="Which tree produces acorns?\n" ;
    ques[14][1]="oak tree\n" ;

    }
}
    
    
ServerClass()throws RemoteException{
    super();
}
    
public void objectToString(){
    v3.clear();
    Vector<PlayerInfo> v4=new Vector();
    v4.clear();
    for(int i=0;i<v1.size();i++){
        v4.add(new PlayerInfo(v1.get(i).name,v1.get(i).score));
    }
    sortAccordingToScore(v4);
    
    for(int i=0;i<v4.size();i++){
        v3.add(v4.get(i).name+"   "+v4.get(i).score);
    }
}

/*void swap(PlayerInfo p1,PlayerInfo p2){
    PlayerInfo temp;
    temp=p1;
    p1=p2;
    p2=temp;
}
*/
public void sortAccordingToScore(Vector<PlayerInfo> v){
    int i, j;
    for (i = 0; i < v.size(); i++)
        for (j = 0; j < v.size()-i-1; j++) 
           if (v.get(j).score < v.get(j+1).score) {
                System.out.println(v.get(j).name + " " + v.get(j).score+" "+v.get(j+1).name + " "+v.get(j+1).score);
                String name1 = v.get(j).name;
                String name2 = v.get(j+1).name;
                int score1 = v.get(j).score;
                int score2 = v.get(j+1).score;
                v.get(j).name = name2;
                v.get(j).score = score2;
                v.get(j+1).score = score1;
                v.get(j+1).name = name1;
                System.out.println(v.get(j).name + " " + v.get(j).score+" "+v.get(j+1).name + " "+v.get(j+1).score);
           }
    System.out.println("Score Sorted");
}

@Override
public void registerUser(ClientInterface ci,String name) throws RemoteException {
    for(int i=0;i<v1.size();i++){
        if(v1.get(i).name.equals(name)){
            throw new RemoteException("Name already in use!");
        }
    }
    v1.add(new PlayerInfo(name));
    v2.add(ci);
    System.out.println(v1.get(v1.size()-1).name+ " added in list");
    objectToString();
    System.out.println("object to string done");
    for(int i=0;i<v2.size();i++)
    {
        ClientInterface c = v2.get(i);
        c.refreshList(v3);
    }
}
@Override
public void removeUser(String name) throws RemoteException {
    
    for(int i=0;i<v1.size();i++){
        if(v1.get(i).name.equals(name)){
            v1.remove(i);
            objectToString();
            
            for(int j=0;j<v2.size();j++){
                ClientInterface c=v2.get(j);
                c.refreshList(v3);
            }
            ClientInterface c1=v2.get(i);
            c1.disableButton("all");
            v2.remove(i);
        }
    }

}

public  void mainMethod(String ip,int type){  
    try {
        System.setProperty("java.rmi.server.hostname",ip ) ;
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        System.out.println("RMI registry ready with ip " + ip);
    } 
    catch (Exception e) {
        System.out.println("Exception starting RMI registry:");
        e.printStackTrace();
    }

    try{
        initialiseQues(type);
        ServerClass ser=new ServerClass();
        Naming.rebind("chat", ser);
        System.out.println("Server Registered!!!");
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
    
@Override
public void sendMessage(String msg) throws RemoteException {
    
    if(msg.equals("1")){
        player_count=0;
        answercount = 0 ;

        Random rand=new Random();
        q=rand.nextInt(limit);
        options.clear();
        System.out.println("options cleared");
        ques[q][1] = ques[q][1].toLowerCase() ;
        options.add(new Options("server",ques[q][1]));
        System.out.println("server optiion added");
        for(int i=0;i<v2.size();i++)
        {   
            System.out.println("inside loop");
            ClientInterface c=v2.get(i);
         System.out.println("ci fetched");
            c.setArea("---------------------------------------------------------\n" + ques[q][0]);
            System.out.println("set area done for" + i + "th player");
            c.setFontColor(Color.BLACK);
            c.disableButton("question");

        }
        /*for(int i=0;i<v2.size();i++){
            ClientInterface c=v2.get(i);
            c.disableButton("question");
        }*/
        questionViewers=v1.size();
    }
    
    else if(msg.charAt(0) == '4' ){
        answercount++;
        msg=msg.substring(1);
        
        String ans[]=msg.split(":");
        int op=Integer.parseInt(ans[1]);
        
        String gotTrickedBy = options.get(op-1).name ;
        
        if(gotTrickedBy.equals("server")){
            
            for(int i=0;i<v1.size();i++){
                
                if(v1.get(i).name.equals(ans[0])){
                    v1.get(i).score++;
                    v1.get(i).correctAns++;
                    ClientInterface c1=v2.get(i);
                    c1.answerStatus("\nCongratulations! You answered right!\n\n");
                    c1.setFontColor(new Color(0,153,76));
                }
            }
        }
        else{
            for(int i=0;i<v1.size();i++){
                
                if(v1.get(i).name.equals(gotTrickedBy)){
     
                    if(gotTrickedBy.equals(ans[0])){
                        v1.get(i).score--;
                        ClientInterface c1=v2.get(i);
                        c1.answerStatus("\nYou got tricked by yourself and lost a mark\n\n");
                        c1.setFontColor(new Color(204,0,0));
                    }
                    
                    else{
                        System.out.println("Checking name of trickers") ;
                        v1.get(i).score++;
                        ClientInterface c1=v2.get(i);
                        c1.answerStatus("\n"+ans[0]+ " got tricked by you\n\n");

                        for(int m=0;m<v1.size();m++){
                            if(v1.get(m).name.equals(ans[0])){
                                ClientInterface c2=v2.get(m);
                                c2.answerStatus("\nWrong answer, You got tricked by "+v1.get(i).name+ "\n\n");
                                c2.setFontColor(new Color(204,0,0));
                            }
                        }
                    }    
                }
            }
            
        }
        objectToString();
        System.out.println("object to string done");
        
        for(int i=0;i<v2.size();i++)
        {
            ClientInterface c=v2.get(i);
            c.refreshList(v3);
            System.out.println("score updated for "+v1.get(i).name);
        } 

        if(answercount==player_count){
        for(int i=0;i<v2.size();i++)
           {   
               ClientInterface c=v2.get(i);
               c.disableButton("answers_done");

           }
        }
    }
    else if(msg.charAt(0) == '3') {
        player_count++;
        System.out.println("playercount" + player_count);
        msg = msg.substring(1) ;
        String opt[]=msg.split(":");
        options.add(new Options(opt[0],opt[1]));
        
        if(player_count == questionViewers){
            System.out.println("in condition of checking tricks done");
            Options.shuffleOptions(options);
            String opts = "" ;
            opts+="OPTIONS:\n\n";
           // System.out.println("options are");
            for(int z=0;z<options.size();z++){
            opts+= z+1 + ")" + options.get(z).option;
            }
            System.out.println("options are"+ opts);
            for(int i=0;i<v2.size();i++)
            {   
                ClientInterface c=v2.get(i);
                System.out.println("Inside loop of printing tricks");
                c.refreshArea(opts);
                System.out.println("refreshArea done");
                
                c.disableButton("tricks_done");
            }
        }
    }
}

    @Override
    public void sendMessageLive(String msg) throws RemoteException {
       for(int i=0;i<v2.size();i++){
        ClientInterface c=v2.get(i);
        c.refreshArea2(msg);
       }  
    }
    
    @Override
    public void sendEnd() throws RemoteException {
        for(int i=0;i<v2.size();i++){
        ClientInterface c=v2.get(i);
        c.enableExit();
       }
    }

    @Override
    public int getUsersCount() throws RemoteException{
        return player_count;
    }
    
    @Override
    public int getCorrectCount(String name) throws RemoteException{
        for(int i=0;i<v1.size();i++){
            String playerName=v1.get(i).name;
            if(playerName.equals(name)){
                return v1.get(i).correctAns;
            }
        }
        return 0;
    }
    @Override
    public String getCorrectAns() throws RemoteException{
        return ques[q][1];
    }
    
}
