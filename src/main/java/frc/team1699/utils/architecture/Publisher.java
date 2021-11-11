package team1699.utils.architecture;

import java.util.ArrayList;

public class Publisher{

    private final String identifier;
    private final ArrayList<Subscriber> subscribers;

    public Publisher(String identifier){
        this.identifier = identifier;
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber sub){
        subscribers.add(sub);
    }

    public String getIdentifier(){
        return identifier;
    }

    public void publishMessage(Message msg){
        for(Subscriber sub : subscribers){
            sub.recieveMessage(msg);
        }
    }
}
