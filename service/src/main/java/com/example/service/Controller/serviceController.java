package com.example.service.Controller;





import com.fasterxml.jackson.annotation.JsonValue;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class serviceController {

    @RequestMapping(value = "/cadena", method = RequestMethod.POST)
    public String hola(@Valid @RequestBody String cadenaN) throws JSONException {
        String cadena = cadenaN + " ";
        JSONObject obj = new JSONObject(cadena);
        String cadena1 = obj.getString("cadena") + " ";
        int tamano = cadena1.length();
        int valFinal = (tamano-1);
        int valReal = tamano;
        int valTotal = 0;
        int caja = 0;
        int ronda = 0;
        int cantidad1 = 0;
        int cantidad2 = 0;
        String primerCaracter; //1
        String respuesta = null;


        int posicion = 0;//0 //1
        for(int i = 0; i<cadena1.length(); i++){

            String buscar1 = String.valueOf(cadena1.charAt(posicion));//a //j //no incrementa hasta que termine la cadena
            primerCaracter = String.valueOf(cadena1.charAt(i));//a //j

            if(ronda == 0){
                if(primerCaracter.equals(buscar1)) {
                    cantidad1++;
                }
            }else if(ronda > 0){
                if(primerCaracter.equals(buscar1)) {
                    cantidad2++;
                }
                if(valFinal == i){
                    if(cantidad1 == cantidad2){
                        caja = cantidad1+1;
                        cantidad1 = cantidad2;
                        valTotal = cantidad1;
                       // cantidad2 = 0;
                    } else if(caja == cantidad2){
                        cantidad1 = (caja-1);
                    }else{
                        respuesta = "NO";
                        break;
                    }
                    cantidad2 = 0;
                }

            }


            if(valFinal == i){
                if(posicion < valFinal){
                    posicion++;
                    i=-1;
                    ronda++;
                }

            }

            if(valFinal == ronda){
                if(valTotal == cantidad1){
                    respuesta = "YES";
                    break;
                }
            }
        }

        return respuesta;
    }



}
