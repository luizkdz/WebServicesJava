package com.example.webServiceRestfulSpringJPA.DomainorEntities;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class DetalheErro implements Serializable {
    
    private Integer statusCode;

    private String statusMessage;

    private String httpMethod;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String erro;

    private String path;

    private String detalhe;



    public static Builder builder(){
        return new Builder();
    }
    
    public static class Builder{
        private DetalheErro erro;

        Builder(){
            this.erro = new DetalheErro();
        }

        public Builder addStatus(HttpStatus status){
            this.erro.statusCode = status.value();
            this.erro.statusMessage = status.getReasonPhrase();
            return this;
        }
        public Builder addErro(String erro){
            this.erro.erro = erro;
            return this;
        }
        public Builder addDetalhe(String detalhe){
            this.erro.detalhe = detalhe;
            return this;
        }
        public Builder addPath(String path){
            this.erro.path = path;
            return this;
  
        }
        
    public DetalheErro build(){
        return this.erro;
    }
    }


}


