package Ch3_4;

import java.util.Scanner;

public class Scheduler {

    // OneDayEvent [] onedays = new OneDayEvent [100];
    // DurationEvent [] durations = new DurationEvent [100];
    // DeadlinedEvent [] deadlines = new DeadlinedEvent [100];
   // ->배열을 3개 만들것이 아니라 공통 상위 클래스 event를 만들어
   //  다른 종류의 데이터를 하나의 배열에 다 담아준다 :(다형성)
    private int capacity =10;
   public Event [] events = new Event [capacity];
    public int n = 0;
    private Scanner kb;

    public void processCommand() {
        kb = new Scanner( System.in );
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("addevent")){
                String type = kb.next();
                if(type.equalsIgnoreCase("oneday"))
                    handleAddOneDayEvent();
                else if(type.equalsIgnoreCase("duration"))
                    handleAddDurationEvent();
                else if(type.equalsIgnoreCase("deadline"))
                     handleAddDeadlinedEvent();

            } else if(command.equals("list")){
                handleList();

            } else if(command.equals("show")){
                handleShow();

            } else if(command.equals("exit")){
                break;
            }
        }

        kb.close();
    }
    private void handleShow(){
       String dateString = kb.next();
       MyDate theDate = parseDateString( dateString );
       for(int i =0; i<n; i++){
           //test if events[i] is relaevant to the date, then print it;
           if(events[i].isRelevant( theDate )){
               System.out.println( events[i].toString() );
           }
       }     
    }
    private void handleList(){
        for(int i =0; i<n; i++)
            System.out.println("  "+ events[i].toString() );        
    }

    private void handleAddOneDayEvent(){
        System.out.print(" when: ");
        String dateString = kb.next(); // dateString ="2017/12/3" -> 쪼개기 Tokenizing
        System.out.print(" title: ");
        String title = kb.next();

        MyDate date = parseDateString( dateString );

        OneDayEvent ev = new OneDayEvent(title, date);

        System.out.println( ev.toString() );
        addEvent(ev);
    }

    private void handleAddDurationEvent(){
        
    }

    private void handleAddDeadlinedEvent(){
    
    }
    private void addEvent(OneDayEvent ev){
        if(n >= capacity){
            reallocate();
        }
        events[n++] = ev;  
    }
 //배열 재 할당
    private void reallocate(){
        Event[] tmp = new Event[capacity *2];
        for(int i =0; i<n; i++){
            tmp[i] = events[i];
        }
        events = tmp;
        capacity *=2; 
    }

    private MyDate parseDateString(String dateString){   //dateString ="2017/12/3"
        String [] tokens = dateString.split("/");
        // tokens[0] = "2017";
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);

        MyDate d = new MyDate(year, month, day);
        return d;
    }

    public static void main(String[] args){

        String str ="122-123-45.546.df.sdf";
        String[] tokens = str.split("\\."); // reqular expression, escape character 정규식
        for(int i = 0; i < tokens.length; i++){
            System.out.println( tokens[i] );
        }
            

        Scheduler app = new Scheduler();
       app.processCommand();
    }
    
}
