package com.revature.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;

import com.revature.dao.ClientDao;
import com.revature.dao.ClientDaoImpl;
import com.revature.model.ClientInfo;
import com.revature.model.StatusInfo;
import com.revature.utils.PersistentStorage;

public class ClientService implements Service {
    private ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDaoImpl();
    }

    //Old method
    /**
     * Returns a map of all of the clients from the TfClient table as a response
     * object.
     * <p>
     * uses cache mechanism
     *
     * @return A map of TfClients as a Response object
     * @throws IOException
     * @throws HibernateException
     */
    public Set<ClientInfo> getAllClients() throws IOException {

        Set<ClientInfo> clients = PersistentStorage.getStorage().getClients();
        if (clients == null || clients.isEmpty()) {
            execute();
            return PersistentStorage.getStorage().getClients();
        }

        return clients;
    }


    /**
     * same as getAllClients but does not use cache mechanism
     *
     * @return
     * @throws IOException
     */
    public Set<ClientInfo> getClients() throws IOException {
    	try {
    		return clientDao.getAllClientsFromCache();
        } catch (Exception e) {
            throw new IOException("could not get clients", e);
        }
    }
    
    public ClientInfo getClientByID(int id) throws IOException{
    	try {
    		return clientDao.getClientFromCache(id);
    	} catch (Exception e) {
    		throw new IOException("could not get client by ID", e);
    	}
    }
    
//Replaced by getClientByID and getClientByName for versatility
//    /**
//     * Returns a StatusInfo object representing a client's associates and their
//     * statuses.
//     *
//     * @param clientid The id of the client in the TfClient table
//     * @return A StatusInfo object for a specified client
//     */
//    public StatusInfo getClientInfo(String clientName) throws IOException {
//        return clientDao.getClient(clientName);
//    }

    @SuppressWarnings("unchecked")
    private <T> Set<T> getTotals() throws IOException {
        Set<StatusInfo> set = new HashSet<>();
        Set<ClientInfo> ci = PersistentStorage.getStorage().getClients();
        if (ci == null || ci.isEmpty()) {
            execute();
        }
        StatusInfo si = PersistentStorage.getStorage().getTotals();
        set.add(si);
        return (Set<T>) set;
    }

    @Override
    public synchronized void execute() throws IOException {
//        Set<ClientInfo> ci = PersistentStorage.getStorage().getClients();
//        if (ci == null || ci.isEmpty())
//            PersistentStorage.getStorage().setClients(getClients());
    	System.out.println("ClentService.execute not implemented");
    }

    // these are fine and tested
    @SuppressWarnings("unchecked")
    @Override
    public <T> Set<T> read(String... args) throws IOException {
        if (args == null || args.length == 0)
            return (Set<T>) getAllClients();
        return getTotals();
    }
}
