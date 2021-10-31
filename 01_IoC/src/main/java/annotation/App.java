package annotation;

public class App {

    //原先主动创建对象
    public static void main(String[] args) {
        MessageService ms =new MessageService();
        MessagesPrinter mp =new MessagesPrinter();
        mp.setMessageService(ms);
        mp.printer();

    }
}
