package api.clients;

import config.Config;
import io.restassured.response.Response;

public class WebApiClient {

    HttpSession session;

public WebApiClient(HttpSession session){
  this.session = session;
}

  public Response getDashboardItems(){
      String dashboardUrl = Config.getInstance().getRegisteredValue("BASE_URL").toString()
              +Config.getInstance().getRegisteredValue("ENDPOINT_DASHBOARD").toString();

      return session.get(dashboardUrl);
    }
}
