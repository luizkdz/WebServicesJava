package exception;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.webServiceRestfulSpringJPA.DomainorEntities.DetalheErro;
import com.example.webServiceRestfulSpringJPA.exception.NaoExisteDaoException;

import jakarta.persistence.ExcludeDefaultListeners;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> contrainstViolada(ConstraintViolationException ex, WebRequest request){
        return handleExceptionInternal(ex, DetalheErro.builder()
        .addDetalhe("Já existe no banco de dados" + ex.getConstraintName())
        .addErro(ex.getMessage())
        .addPath(getPath(request))
        .addStatus(HttpStatus.CONFLICT)
        .addHttpMethod(getHttpMethod(request))
        .build(),
        new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


    @ExceptionHandler({PropertyValueException.class})
    public ResponseEntity<Object> propriedadeNaoEncontrada(PropertyValueException ex, WebRequest request){
        return handleExceptionInternal(ex, DetalheErro.builder()
        .addDetalhe("A propriedade não pode ser nula")
        .addErro(ex.getMessage())
        .addPath(getPath(request))
        .addStatus(HttpStatus.BAD_REQUEST)
        .addHttpMethod(getHttpMethod(request))
        .build(),
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    
    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> serverException(RuntimeException ex, WebRequest request){

        return handleExceptionInternal(ex, DetalheErro.builder()
        .addDetalhe("Uma exceção foi lançada")
        .addErro(ex.getMessage())
        .addPath(getPath(request))
        .addStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        .addHttpMethod(getHttpMethod(request))
        .build(),
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({NaoExisteDaoException.class})
    public ResponseEntity<Object> entidadeNaoEncontrada(RuntimeException ex, WebRequest request){
        return handleExceptionInternal(ex, DetalheErro.builder()
        .addDetalhe("Id não encontrado na base de dados")
        .addErro(ex.getMessage())
        .addPath(getPath(request))
        .addStatus(HttpStatus.NOT_FOUND)
        .addHttpMethod(getHttpMethod(request))
        .build(),
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

public String getPath(WebRequest request){
    return ((ServletWebRequest) request ).getRequest().getRequestURI();

}

public String getHttpMethod(WebRequest request){
    return ((ServletWebRequest) request).getRequest().getMethod();
}






}
