package com.telecom.project.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HttpRestFormUrlFilter
 */
public class HttpRestFormUrlFilter implements Filter {

	private String encoding;
    /**
     * Default constructor. 
     */
    public HttpRestFormUrlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest wrapper = new HttpRestFormUrlRequestWrapper(req, encoding);
		chain.doFilter(wrapper, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = fConfig.getInitParameter("encoding");
	}

	
	
	private static class HttpRestFormUrlRequestWrapper extends HttpServletRequestWrapper {

		private HttpServletRequest request;
		private String encoding;
		public HttpRestFormUrlRequestWrapper(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		
		public HttpRestFormUrlRequestWrapper(HttpServletRequest request,String encoding) {
			super(request);
			this.request = request;
			this.encoding = encoding;
		}
		
		@Override
		public String getServletPath() {
			// TODO Auto-generated method stub
			String servletPath = request.getServletPath();
			try {
				//Spring MVC 是基于Servlet，在Http请求到达Servlet解析之前，
				//GET过来的URL已经被Tomcat先做了一次URLDecode.decode(str,"iso-8859-1");
				//Tomcat对GET方式默认的URL解码结果是iso-8859-1而不是UTF-8！
				//在构造HTTP请求|响应消息时，需要把中文字符再转成iso-8859-1。
				servletPath = new String(servletPath.getBytes("iso-8859-1"),encoding);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return servletPath;
		}
	}
	
	
	
	
}
