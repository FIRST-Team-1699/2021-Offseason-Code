package team1699.controllers;

import java.util.Map;
import java.util.HashMap;
import team1699.utils.architecture.Subscriber;
import team1699.utils.architecture.Publisher;
import team1699.utils.architecture.Message;

public class DriveController implements Subscriber{

    private final Publisher portMotorOutputRequestPublisher;
    private final Publisher starMotorOutputRequestPublisher;
    private final Map<String, Message> messages;

    public DriveController(){
        portMotorOutputRequestPublisher = new Publisher("Port Drive Output Request");
        starMotorOutputRequestPublisher = new Publisher("Star Drive Output Request");
        messages = new HashMap<>();
    }

    public void recieveMessage(Message message){
        messages.put(message.getSender(), message);
    }

    public void publishData(){
        //Create Messages
        Message<Double> portMotorOutputMessage = new Message<>(portMotorOutputRequestPublisher.getIdentifier(), 0.0);
        Message<Double> starMotorOutputMessage = new Message<>(starMotorOutputRequestPublisher.getIdentifier(), 0.0);

        //Publish Motor Output Requests
        portMotorOutputRequestPublisher.publishMessage(portMotorOutputMessage);        
        starMotorOutputRequestPublisher.publishMessage(starMotorOutputMessage);        
    }
}
