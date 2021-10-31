package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagesPrinter {

    public MessagesPrinter() {
        System.out.printf("MessagesPrinter");
    }

    public MessagesPrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    //管理对象之间的关系
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    private MessageService messageService;

    public void printer() {
        System.out.printf(messageService.getMessage());
    }

}
