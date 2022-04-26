package com.thiertant.ecommerce.service;

import com.thiertant.ecommerce.exception.ResourceNotFoundException;
import model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("clients")
public class ClientServiceImpl implements ClientService{

    private final List<Client> allClient = new ArrayList<>();

    @Override
    public List<Client> getAllClient() {
        return allClient;
    }

    @Override
    public Client getClientById(Long clientId) {
        boolean clientNotFound = true;
        try {
            for (Client client : allClient) {
                if (Objects.equals(client.getId(), clientId)) {
                    clientNotFound = false;
                    return client;
                }
            }
            throw new ResourceNotFoundException();
        }
        catch(ResourceNotFoundException e) {
            System.out.println(e);
        }

        return allClient.get(1); // return void ?
    }

    @Override
    public Client save(Client client) {
        allClient.add(client);
        return client;
    }
}
