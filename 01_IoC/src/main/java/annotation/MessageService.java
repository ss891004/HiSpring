package annotation;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    public MessageService() {
        System.out.printf("MessageService ");
    }

    public String getMessage() {
        return "MessageService-getMessage";

    }
}
