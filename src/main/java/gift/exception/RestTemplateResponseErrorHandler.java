package gift.exception;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().is5xxServerError() ||
            response.getStatusCode().is4xxClientError();
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response)
        throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        String responseBody = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);

        if (statusCode.is5xxServerError()) {
            //Handle SERVER_ERROR
            throw new HttpServerErrorException(response.getStatusCode());
        } else if (statusCode.is4xxClientError()) {
            //Handle CLIENT_ERROR
            if (statusCode == HttpStatus.NOT_FOUND) {
                throw new RuntimeException();
            } else {
                throw new KakaoApiException(responseBody);
            }
        }
    }

}
