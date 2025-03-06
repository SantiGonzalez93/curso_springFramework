package curso.santi.springboot.app_interceptors.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {


    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: pretHandler() entrando... " + controller.getMethod().getName());
        Long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        HandlerMethod controller = ((HandlerMethod) handler);
        Long end = System.currentTimeMillis();
        Long start = (Long) request.getAttribute("start");
        Long result = end - start;
        logger.info("Tiempo transcurrido: " + result + " milisegundos");
        logger.info("LoadingTimeInterceptor: postHandler() saliendo... " + controller.getMethod().getName());
    }

}
