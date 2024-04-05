package parcial.segundo;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.List;
//http://localhost:4567/binarysearch?list=10,20,13,40,60&value=13
public class MathService {
    public static void main(String... args){

        port(getPort());
        
        get("/linearsearch", (req,res) -> {
            String list = req.queryParamsValues("list")[0];
            String value = req.queryParamsValues("value")[0];
            List<Integer> listaEnteros = new ArrayList<>();
            String[] numeros = list.split(",");
            for (String n : numeros) {listaEnteros.add(Integer.parseInt(n));}
            System.out.println(value);
            return Search.lineal( listaEnteros,Integer.parseInt(value));
        });

        get("/binarysearch", (req,res) -> {
            String list = req.queryParamsValues("list")[0];
            String value = req.queryParamsValues("value")[0];
            List<Integer> listaEnteros = new ArrayList<>();
            String[] numeros = list.split(",");
            for (String n : numeros) {listaEnteros.add(Integer.parseInt(n));}
            System.out.println(value);
            return Search.binari( listaEnteros,Integer.parseInt(value));
        });
  }

  private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 5000;
  }
}
