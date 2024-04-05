package parcial.segundo;

import static spark.Spark.*;

public class Serverfacade {
    static HttpConnetionExample conection = new HttpConnetionExample();

    public static void main(String... args){
        port(getPort());
        staticFiles.location("/static");
        get("/favicon", (req,res) -> "");
        get("/binarysearch", (req,res) ->  {
            String rest;
            String value = req.queryParamsValues("value")[0];
            String list = req.queryParamsValues("list")[0];
            String[] conString = {"http://ec2-user@ec2-3-90-110-121.compute-1.amazonaws.com:5000/binarysearch?list="+ list +"&value=" + value, "http://ec2-user@ec2-107-21-15-250.compute-1.amazonaws.com:5000/binarysearch?list="+ list +"&value=" + value};
            rest = HttpConnetionExample.conect(conString);
            return rest;
        });
        get("/linearsearch", (req,res) ->  {
            String rest;
            String list = req.queryParamsValues("list")[0];
            String value = req.queryParamsValues("value")[0];
            String[] conString = {"http://ec2-user@ec2-3-90-110-121.compute-1.amazonaws.com:5000/binarysearch?list="+ list +"&value=" + value, "http://ec2-user@ec2-107-21-15-250.compute-1.amazonaws.com:5000/binarysearch?list="+ list +"&value=" + value};
            rest = HttpConnetionExample.conect(conString);
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
