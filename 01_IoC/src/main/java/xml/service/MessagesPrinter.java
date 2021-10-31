package xml.service;

public class MessagesPrinter {

    public MessagesPrinter() {
        System.out.println("MessagesPrinter");
    }

    public MessagesPrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private MessageService messageService;

    public void printer() {
        System.out.println(messageService.getMessage());
    }

}
