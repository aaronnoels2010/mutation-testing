package com.example.exception;

import com.example.dto.error.ErrorMessage;
import io.quarkus.logging.Log;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Arrays;
import java.util.stream.Collectors;

@Provider
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException exception) {
        Log.warn(exception.getMessage());
        Log.warn(Arrays.stream(exception.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.joining("\n")));
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage("We will look into the issue soon", exception.getClass().toString()))
                .build();
    }
}
