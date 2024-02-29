package com.rp.section11.assignment;

import java.util.function.Consumer;

public class SlackMember {

    private String name;
    private Consumer<String> messageConsumer;
    public SlackMember(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }

    void receives(String message){
        System.out.println("receive message : "+message);
    }

    public void says(String message){
        this.messageConsumer.accept(message);
    }


}
