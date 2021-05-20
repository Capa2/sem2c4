package business.services;

import business.entities.Query;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.QueryMapper;

import java.util.ArrayList;

public class QueryFacade {

    QueryMapper queryMapper;

    public QueryFacade(Database database)
    {
        queryMapper = new QueryMapper(database);
    }

    public Query createQuery(int userId, int carportId, String status, String message, String wantBuilder) throws UserException
    {
        Query query = new Query(userId, carportId, status, message, wantBuilder);
        queryMapper.createQuery(query);
        return query;
    }

    public ArrayList getQueries(int userId) throws UserException {

        return (ArrayList) queryMapper.getQuery(userId);
    }

    public ArrayList getAllQueries() throws UserException {

        return (ArrayList) queryMapper.getAllQueries();
    }

    public void updateQueryMessage(String message) {

    }
}
