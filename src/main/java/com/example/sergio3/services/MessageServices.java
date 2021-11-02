package com.example.sergio3.services;

import com.example.sergio3.crud.MessageRepository;
import com.example.sergio3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServices {
    @Autowired
    private MessageRepository MessageCrudRepository;

    public List<Message> getAll(){
        return MessageCrudRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return  MessageCrudRepository.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return  MessageCrudRepository.save(message);
        }else{
            Optional<Message> e=  MessageCrudRepository.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return  MessageCrudRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e=  MessageCrudRepository.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                MessageCrudRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            MessageCrudRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}

