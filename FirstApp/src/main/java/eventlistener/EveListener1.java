package eventlistener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class EveListener1 implements HttpSessionListener {
	ServletContext ctx = null;
	static int total = 0, current = 0;

    public void sessionCreated(HttpSessionEvent se)  { 
         total++;
         current++;
         
         ctx = se.getSession().getServletContext();
         ctx.setAttribute("totalusers", total);
         ctx.setAttribute("currentusers", current);
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         current--;
         ctx.setAttribute("totalusers", current);
    }
	
}
