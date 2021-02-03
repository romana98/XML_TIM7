package com.project.organ_vlasti.client;

import com.project.organ_vlasti.model.izvestaji.client.getPodaci;
import com.project.organ_vlasti.model.izvestaji.client.getPodaciResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class IzvestajiClient extends WebServiceGatewaySupport {

    public getPodaciResponse getPodaci(getPodaci request) {

        getPodaciResponse response = (getPodaciResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8085/ws/izvestaj", request,
                        new SoapActionCallback(
                                "http://izvestaji/ws/getPodaci"));

        if(response.getResponse().getId().equals("-1")){
            return null;
        }

        return response;
    }
}
