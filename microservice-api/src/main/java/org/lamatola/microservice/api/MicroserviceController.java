package org.lamatola.microservice.api;

import java.util.List;
import com.lamatola.microservice.http.MicroserviceHttpClient;
import java.util.concurrent.CompletableFuture;
import org.lamatola.microservice.schema.AdCampaign;
import org.lamatola.microservice.schema.AdResponse;
import org.lamatola.microservice.schema.MicroserviceResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController("/supply")
public class MicroserviceController implements MicroserviceHttpClient {

    //    public CompletableFuture<MicroserviceResponse<AdResponse>> getAds() {
    public MicroserviceResponse<AdResponse> getAds() {
        System.out.println("============================= sync ========");
        return
            new MicroserviceResponse<>(
                new AdResponse(List.of(new AdCampaign(List.of("1", "2")))));
    }

    @Override
    public CompletableFuture<MicroserviceResponse<AdResponse>> getAdsAsync() {
        System.out.println("============================= async ====== ");
        MicroserviceResponse<AdResponse> data = new MicroserviceResponse<>(
            new AdResponse(List.of(new AdCampaign(List.of("1", "2")))));

        return CompletableFuture.completedFuture(data);
    }
}