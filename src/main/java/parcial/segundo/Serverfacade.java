package parcial.segundo;

import static spark.Spark.*;
//https://amazonxxx.x.xxx.x.xxx:{port}/linearsearch?list=10,20,13,40,60&value=13
//https://amazonxxx.x.xxx.x.xxx:{port}/binarysearch?list=10,20,13,40,60&value=13
//http://localhost:5000/binarysearch?list=10,20,13,40,60&value=13

public class Serverfacade {
    static HttpConnetionExample conection = new HttpConnetionExample();

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/static");
        get("/favicon", (req,res) -> "");
        get("/binarysearch", (req,res) ->  {
            System.out.println(req.toString() + "<-----");
            String rest;
            String value = req.queryParamsValues("value")[0];
            String list = req.queryParamsValues("list")[0];
            String[] conString = {"http://localhost:5000/binarysearch?list="+ list +"&value=" + value, "http://localhost:5000/binarysearch?list="+ list +"&value=" + value};
            System.out.println(conString[0]);
            rest = HttpConnetionExample.conect(conString);
            System.out.println(rest + "<-----");
            return rest;
        });
        get("/linearsearch", (req,res) ->  {
            System.out.println(req.toString() + "<-----");
            String rest;
            String list = req.queryParamsValues("list")[0];
            String value = req.queryParamsValues("value")[0];
            String[] conString = {"http://localhost:5000/binarysearch?list="+ list +"&value=" + value, "http://localhost:5000/binarysearch?list="+ list +"&value=" + value};
            rest = HttpConnetionExample.conect(conString);
            System.out.println(rest + "<-----");
            return rest;
        });
    }

  private static int getPort() {
      if (System.getenv("PORT") != null) {
          return Integer.parseInt(System.getenv("PORT"));
      }
      return 4567;
  }
}
