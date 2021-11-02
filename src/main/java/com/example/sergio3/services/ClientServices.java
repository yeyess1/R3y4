package com.example.sergio3.services;

import com.example.sergio3.crud.ClientRepository;
import com.example.sergio3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {
        @Autowired
        private ClientRepository ClientCrudRepository;

        public List<Client> getAll(){
            return  ClientCrudRepository.getAll();
        }

        public Optional<Client> getClient(int clientId) {
            return  ClientCrudRepository.getClient(clientId);
        }

        public Client save(Client client){
            if(client.getIdClient()==null){
                return  ClientCrudRepository.save(client);
            }else{
                Optional<Client> e=  ClientCrudRepository.getClient(client.getIdClient());
                if(e.isEmpty()){
                    return  ClientCrudRepository.save(client);
                }else{
                    return client;
                }
            }
        }

        public Client update(Client client){
            if(client.getIdClient()!=null){
                Optional<Client> e=  ClientCrudRepository.getClient(client.getIdClient());
                if(!e.isEmpty()){
                    if(client.getName()!=null){
                        e.get().setName(client.getName());
                    }
                    if(client.getAge()!=null){
                        e.get().setAge(client.getAge());
                    }
                    if(client.getPassword()!=null){
                        e.get().setPassword(client.getPassword());
                    }
                    ClientCrudRepository.save(e.get());
                    return e.get();
                }else{
                    return client;
                }
            }else{
                return client;
            }
        }

        public boolean deleteClient(int clientId) {
            Boolean aBoolean = getClient(clientId).map(client -> {
                ClientCrudRepository.delete(client);
                return true;
            }).orElse(false);
            return aBoolean;
        }

    }