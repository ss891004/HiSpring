package org.example;

public class App {

    public static void main(String[] args) {
        MessageService ms =new MessageService();
        MessagesPrinter mp =new MessagesPrinter();
        mp.setMessageService(ms);
        mp.printer();

    }
}
