package com.capgemini.bankaccount.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/login")
public class CookiesIsEnabledFilter implements Filter {

    public CookiesIsEnabledFilter() {
        // TODO Auto-generated constructor stub
    }
    public void init(FilterConfig fConfig) throws ServletException {

	}
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// HttpSession session = ((HttpServletRequest)request).getSession(false);
		HttpServletRequest req = (HttpServletRequest) request;
		if(null == req.getCookies())
		{
			//PrintWriter out = response.getWriter();
			request.getRequestDispatcher("enableCookie.jsp").include(request, response);
		}else {
			chain.doFilter(request, response);
		}
		
		
	}
	public void destroy() {
	}
	

}
