package business.services;

import business.entities.Query;
import business.entities.Response;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.QueryMapper;
import business.persistence.ResponseMapper;

import java.util.ArrayList;

public class ResponseFacade {

    ResponseMapper responseMapper;

    public ResponseFacade(Database database) {
        responseMapper = new ResponseMapper(database);
    }

    public Response createResponse(int queryId, int userId, String message) {

        Response response = new Response(queryId, userId, message);

        return responseMapper.createResponse(response);
    }
}