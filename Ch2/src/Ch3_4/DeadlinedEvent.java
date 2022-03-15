package Ch3_4;

public class DeadlinedEvent extends Event {
    public String title;
    public MyDate deadline;

    public DeadlinedEvent( String title, MyDate date ){
        super(title);
        this.title = title;
        this.deadline = date;
    }

    public boolean isRelevant( MyDate date ){
        
        return deadline.compareTo(date) >= 0;
    }

    public String toString(){
        return title +", " + deadline.toString();
    }
}
