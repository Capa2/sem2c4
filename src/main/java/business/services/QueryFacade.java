package business.services;

import business.entities.Query;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.QueryMapper;
import business.persistence.UserMapper;

public class QueryFacade {

    QueryMapper queryMapper;

    public QueryFacade(Database database)
    {
        queryMapper = new QueryMapper(database);
    }

    public Query createQuery(int userId, int carportId, String status, String message) throws UserException
    {
        Query query = new Query(userId, carportId, status, message);
        queryMapper.createQuery(query);
        return query;
    }

}
