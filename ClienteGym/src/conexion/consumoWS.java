package conexion;

import clientegym.POJOS.clientes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class consumoWS {
    
    public void consumoWSPOST(String urlWS, String parametros){
        try {
            URL url = new URL(urlWS);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.getOutputStream().write(parametros.getBytes("UTF-8"));
            if (conn.getResponseCode() != 200) {
                throw 
                    new RuntimeException("Conexión fallida con código: "+conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String respuesta;
            while ((respuesta = br.readLine()) != null) {                
                System.out.println(respuesta);
            }
            conn.disconnect();
        } catch (Exception e) {
            System.err.println("Exception: "+e);
        }
    }
public void consumoWSGET(String urlWS){
        try {
            URL url = new URL(urlWS);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw 
                    new RuntimeException("Conexión fallida con código: "+conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String respuesta;
            String jsonRespuesta = "";
            while ((respuesta = br.readLine()) != null) {  
                jsonRespuesta = respuesta;
                System.out.println(respuesta);
            }
            conn.disconnect();
            
            /* Implementacion GSON para un objeto
            Gson gson = new Gson();
            Catalogo miCatalogoWS = gson.fromJson(jsonRespuesta, Catalogo.class);
            String imprime = 
                    String.format("El catalog se llama %s, con ID %d", 
                            miCatalogoWS.getNombre(), miCatalogoWS.getIdcatalogo());
            System.out.println(imprime); */
            
            // Implementacion GSON para listas
            
            Gson gson = new Gson();
            TypeToken<List<clientes>> tipoListaCat = new TypeToken<List<clientes>>(){};
            ArrayList<clientes> misCatalogos = gson.fromJson(jsonRespuesta, tipoListaCat.getType());
            System.out.println("El tamaño completo del arreglo es: "+misCatalogos.size());
            System.out.println("El nombre del primer catalogo es: "+misCatalogos.get(0).getNombre());
            
        } catch (Exception e) {
            System.err.println("Exception: "+e);
        }
    }    
}
