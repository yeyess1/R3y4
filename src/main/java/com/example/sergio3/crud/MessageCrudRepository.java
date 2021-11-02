package com.example.sergio3.crud;



import com.example.sergio3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{

}
