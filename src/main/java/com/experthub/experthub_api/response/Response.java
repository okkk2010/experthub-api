package com.experthub.experthub_api.response;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class Response<T>  {
    private int statusCode;

    private String message;

    private T data;
}
