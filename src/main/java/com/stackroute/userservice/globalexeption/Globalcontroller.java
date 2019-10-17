package com.stackroute.userservice.globalexeption;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.ILoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice

public class Globalcontroller {

private Log logger= LogFactory.getLog(Globalcontroller.class);
@ExceptionHandler(value=Exception.class)
    public String handleError(HttpServletRequest req, Exception exception)
{
logger.error("Request:" + req.getRequestURL() + "raised" + exception );

return "error";
}

}
