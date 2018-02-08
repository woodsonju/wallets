package io.pax.cryptos.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AELION on 06/02/2018.
 */
@WebServlet("/hello")    //on dit que le chemin de la servlet est hello : ça remplace le web.xml
public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getHeader("User-Agent"));
        response.getOutputStream().print("yoloWF");
    }
}
