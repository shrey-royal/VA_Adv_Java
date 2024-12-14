package eventlistener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoggingFilter Initialized");
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("Client IP: " + req.getRemoteAddr());
		System.out.println("Requested URI: " + req.getLocalName());

		chain.doFilter(req, res);
	}
	
	public void destroy() {
		System.out.println("LoggingFilter destroyed");
	}

}
