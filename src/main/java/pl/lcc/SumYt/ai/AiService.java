package pl.lcc.SumYt.ai;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pl.lcc.SumYt.ai.carrier.Model;
import pl.lcc.SumYt.ai.carrier.ModelList;

@Service
public class AiService {

    String getModelsPath = "https://api.groq.com/openai/v1/models"; //need get with auth

    @Value("${spring.ai.openai.api-key}")
    private String authString;

    RestClient restClient;

    public AiService() {
        System.out.println("Ai Service!");
    }

    @PostConstruct
    void initializeRestClient() {
        restClient = RestClient.builder()
                .baseUrl(getModelsPath)
                .defaultHeader("Authorization", "Bearer " + authString)
                .build();
        System.out.println("restClient initialized");
    }

    public String getModels() {
        var response = restClient.get();
        var result = response.retrieve().body(ModelList.class);
        return result.getFormattedModels();
    }

    public Model getModel(String modelName) {
        var specificRestClient = restClient.mutate().baseUrl(getModelsPath + "/" + modelName).build();
        var response = specificRestClient.get();
        var result = response.retrieve().body(Model.class);
        return result;
    }
}
