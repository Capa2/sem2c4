package business.services;

import business.entities.Address;
import business.entities.PostalCode;
import business.entities.Town;
import business.entities.User;
import business.persistence.AddressMapper;
import business.persistence.Database;
import business.exceptions.UserException;

public class AddressFacade
{
    AddressMapper addressMapper;

    public AddressFacade(Database database)
    {
        addressMapper = new AddressMapper(database);
    }

    public Address createAddress(String name) throws UserException
    {
        Address address = new Address(name);
        addressMapper.createAddress(address);
        return address;
    }

    public Town createTown(String name) throws UserException
    {
        Town town = new Town(name);
        addressMapper.createTown(town);
        return town;
    }

//    public PostalCode createPostalCode(String name) throws UserException
//    {
//        PostalCode postalCode = new PostalCode(name);
//        addressMapper.createPostalCode(townId);
//        return PostalCode;
//    }
}