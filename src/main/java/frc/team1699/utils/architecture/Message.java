package team1699.utils.architecture;

public class Message<T> {
    private final T message;
    private final String sender;

    public Message (final String sender, final T message){
        this.sender = sender;
        this.message = message;
    }

    public String getSender(){
        return sender;
    }

    public T getMessage(){
        return message;
    }

}
