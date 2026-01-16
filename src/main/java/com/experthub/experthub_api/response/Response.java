package com.experthub.experthub_api.response;
import lombok.Data;


@Data
@builder
public class Response<T>  {
    private int statusCode;

    private String message;

    private T data;
}
