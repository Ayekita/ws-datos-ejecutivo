package cl.cnsv.integracion.datosejecutivo.rest;

import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;


public class LogInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        Logger logger = Logger.getLogger(ctx.getTarget().getClass().getName());
        logger.debug("ENTRANDO : "+ctx.getMethod().getName() + ",  Params" + Arrays.toString(ctx.getParameters()));
        long start = System.currentTimeMillis();
        Object returnMe = ctx.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.debug("SALIENDO : "+ctx.getMethod().getName()+":"+executionTime+"ms" + " respuesta:" + returnMe);

        return returnMe;
    }
}
