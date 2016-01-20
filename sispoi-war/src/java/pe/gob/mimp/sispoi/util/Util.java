package pe.gob.mimp.sispoi.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Util {

    private static Util instance = null;
	
    protected Util() {

    }

    public static Util obtener() {
        if(instance == null) {
            instance = new Util();
        }
        
        return instance;
    }
	
    public static String obtenerNombreCliente() throws UnknownHostException
    {
        String host = "";

        InetAddress IP=InetAddress.getLocalHost();

        host = IP.getHostName();

        return host;
    }
	
    public static String obtenerIPCliente() throws UnknownHostException
    {
        String ip = "";

        InetAddress IP=InetAddress.getLocalHost();

        ip = IP.getHostAddress();

        return ip;
    }
    
    public static String obtenerIPPublicaCliente() throws UnknownHostException
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ip = "";
        
        ip = request.getHeader("X-FORWARDED-FOR");
        
        if (ip == null) 
        { 
            ip = request.getRemoteAddr();
        }
        
        System.out.println("ipAddress:" + ip);
        
        return ip;
    }
}
