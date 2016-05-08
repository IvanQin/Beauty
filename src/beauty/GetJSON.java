package beauty;
//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetJSON {
	public String getJSON (String expr,String attributes,int count){
     HttpClient httpclient = HttpClients.createDefault();

     try{
         URIBuilder builder = new URIBuilder("https://oxfordhk.azure-api.net/academic/v1.0/evaluate");

         builder.setParameter("expr", expr);
         //builder.setParameter("model", "latest");
         builder.setParameter("attributes", attributes);
         builder.setParameter("count",""+count);
         //builder.setParameter("offset", "0");
         builder.setParameter("subscription-key", "f7cc29509a8443c5b3a5e56b0e38b5a6");
         URI uri = builder.build();
         HttpGet request = new HttpGet(uri);
         //request.setHeader("Ocp-Apim-Subscription-Key", "f7cc29509a8443c5b3a5e56b0e38b5a6");


         // Request body
         //StringEntity reqEntity = new StringEntity("{body}");
         //request.setEntity(reqEntity);
         HttpResponse response = httpclient.execute(request);
         HttpEntity entity = response.getEntity();
         return EntityUtils.toString(entity);
         
         /*if (entity != null) 
         {
             System.out.println(EntityUtils.toString(entity));
         }*/
     }
     catch (Exception e)
     {
         System.out.println(e.getMessage());
     }
     return null;
 }
}

