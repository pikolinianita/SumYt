package pl.lcc.SumYt.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import pl.lcc.SumYt.ai.carrier.Model;
import pl.lcc.SumYt.ai.carrier.ModelList;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class AiServiceTest {
    String oneModel = """
            {"id":"llama-3.2-90b-text-preview","object":"model","created":1727285716,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null}""";


    String models = """
            {"object":"list","data":[{"id":"llama-3.2-1b-preview","object":"model","created":1727224268,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.1-70b-versatile","object":"model","created":1693721698,"owned_by":"Meta","active":true,"context_window":32768,"public_apps":null},{"id":"gemma2-9b-it","object":"model","created":1693721698,"owned_by":"Google","active":true,"context_window":8192,"public_apps":null},{"id":"distil-whisper-large-v3-en","object":"model","created":1693721698,"owned_by":"Hugging Face","active":true,"context_window":448,"public_apps":null},{"id":"llama-3.2-11b-vision-preview","object":"model","created":1727226869,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.2-3b-preview","object":"model","created":1727224290,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"whisper-large-v3-turbo","object":"model","created":1728413088,"owned_by":"OpenAI","active":true,"context_window":448,"public_apps":null},{"id":"whisper-large-v3","object":"model","created":1693721698,"owned_by":"OpenAI","active":true,"context_window":448,"public_apps":null},{"id":"mixtral-8x7b-32768","object":"model","created":1693721698,"owned_by":"Mistral AI","active":true,"context_window":32768,"public_apps":null},{"id":"llama3-groq-70b-8192-tool-use-preview","object":"model","created":1693721698,"owned_by":"Groq","active":true,"context_window":8192,"public_apps":null},{"id":"llama3-70b-8192","object":"model","created":1693721698,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.2-90b-vision-preview","object":"model","created":1727226914,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llava-v1.5-7b-4096-preview","object":"model","created":1725402373,"owned_by":"Other","active":true,"context_window":4096,"public_apps":null},{"id":"llama-guard-3-8b","object":"model","created":1693721698,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama3-8b-8192","object":"model","created":1693721698,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.2-11b-text-preview","object":"model","created":1727283005,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.2-90b-text-preview","object":"model","created":1727285716,"owned_by":"Meta","active":true,"context_window":8192,"public_apps":null},{"id":"llama3-groq-8b-8192-tool-use-preview","object":"model","created":1693721698,"owned_by":"Groq","active":true,"context_window":8192,"public_apps":null},{"id":"llama-3.1-8b-instant","object":"model","created":1693721698,"owned_by":"Meta","active":true,"context_window":131072,"public_apps":null},{"id":"gemma-7b-it","object":"model","created":1693721698,"owned_by":"Google","active":true,"context_window":8192,"public_apps":null}]}
            """;

    String shrt = """
            {"object":"list"}""";
    @Autowired
    ObjectMapper objectMapper;

    @Test
void testModelDeserialisation() throws JsonProcessingException {

    var result = objectMapper.readValue(oneModel, Model.class);
        System.out.println(result);
    assertThat(result).hasFieldOrPropertyWithValue("id", "llama-3.2-90b-text-preview");
}

    @Test
    void testModelsDeserialisation() throws JsonProcessingException {

        var result = objectMapper.readValue(models, ModelList.class);
        System.out.println(result);
        assertThat(result.getData()).hasSizeGreaterThan(4);
    }

}