package au.com.healthsutra.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestfulSupport {

    private static final Logger LOG = LoggerFactory.getLogger(RestfulSupport.class);

    protected final ResponseEntity<String> responseWith(HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, status);
    }

    protected final ResponseEntity<String> responseWithHTML(String body, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html");
        return new ResponseEntity<String>(body, headers, status);
    }

    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<String> handlerIOException(IOException exception) {
        LOG.error("Other error : ", exception);
        return responseWith(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException exception) {
        LOG.error("Argument error : ", exception);
        return responseWith(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HSServiceException.class)
    public ResponseEntity<String> handlerDomainServiceException(HSServiceException exception) throws IOException {
        LOG.error("DomainServiceException error : ", exception);

        ObjectMapper objectMapper = new ObjectMapper();
        final Map<String, String> responseException = new HashMap<String, String>();
        responseException.put("errorCode", exception.getErrorCode());
        responseException.put("errorSystemMessage", exception.getErrorSystemMessage());
        String jsonBody = objectMapper.writeValueAsString(responseException);
        return responseWithHTML(jsonBody, HttpStatus.NOT_ACCEPTABLE);
    }

}
