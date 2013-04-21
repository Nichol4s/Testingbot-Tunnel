package com.testingbot.tunnel.proxy;


import org.eclipse.jetty.proxy.ProxyServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TunnelProxyServlet extends ProxyServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        
        Logger.getLogger(TunnelProxyServlet.class.getName()).log(Level.INFO, "<< [{0}] {1} ({2})", new Object[]{request.getMethod(), request.getRequestURL().toString(), response.toString().substring(9, 12)});
        super.service(req, res);
    }
}
