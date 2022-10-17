package service;

import model.Category;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client){
        if(validarCampos(client)) {
            if (client.getIdClient() == null) {
                return clientRepository.save(client);
            } else {
                Optional<Client> e = clientRepository.getClient(client.getIdClient());
                if (e.isPresent()) {
                    return client;
                } else {
                    return clientRepository.save(client);
                }
            }
        }
        return  client;
    }

    public Client update(Client client){
        if(validarCampos(client)) {
            if (client.getIdClient() != null) {
                Optional<Client> e = clientRepository.getClient(client.getIdClient());
                if (!e.isEmpty()) {
                    if (client.getName() != null) {
                        e.get().setName(client.getName());
                    }
                    if (client.getEmail() != null) {
                        e.get().setEmail(client.getEmail());
                    }
                    if (client.getAge() != null) {
                        e.get().setAge(client.getAge());
                    }
                    if (client.getPassword() != null) {
                        e.get().setPassword(client.getPassword());
                    }
                    if (client.getMessages() != null) {
                        e.get().setMessages(client.getMessages());
                    }
                    if (client.getReservations() != null) {
                        e.get().setReservations(client.getReservations());
                    }

                }
                clientRepository.save(e.get());
                return e.get();
            } else {
                return client;
            }
        }
        return client;
    }

    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean validarCampos(Client client){
        return (client.getEmail().length()<=45 && client.getPassword().length()<=45
                && client.getName().length() <=250
        );
    }

}
