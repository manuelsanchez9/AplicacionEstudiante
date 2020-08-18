package org.ejemplo.conf;

/**
 *
 * @author juan
 */

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.filter.OncePerRequestFilter;

//@RestController
//@RequestMapping("/se")
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                //para que js procese desde todos los dominios
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type, x-auth-token-id-usuario,X-Auth-Token-usuario, X-Auth-Token-empresa, X-Auth-Token,X-Auth-Token-es-base,X-gtm,X-Auth-Otro");

        response.addHeader("Access-Control-Expose-Headers", "X-Auth-Token-valido");
        response.setHeader("X-Auth-Token-valido", "1");
        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, my-cool-header");
        response.addHeader("Access-Control-Max-Age", "60"); // seconds to cache preflight request --> less OPTIONS traffic
        response.addHeader("Access-Control-Allow-Methods", "GET, POST,PUT, OPTIONS");
        response.addHeader("Access-Control-Allow-Origin", "*");
        //manadar al rest
        filterChain.doFilter(request, response);
//        //para que js procese desde todos los dominios
//        response.addHeader("Access-Control-Max-Age", "3600"); // seconds to cache preflight request --> less OPTIONS traffic
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST,PUT, OPTIONS");
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("X-Auth-Token-valido", "1");
//        //manadar al rest
//        filterChain.doFilter(request, response);
    }

}
