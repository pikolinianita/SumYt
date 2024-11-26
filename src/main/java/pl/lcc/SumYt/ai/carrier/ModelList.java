package pl.lcc.SumYt.ai.carrier;

import java.util.List;
import java.util.stream.Collectors;

public class ModelList {

    List<Model> data;
    String object;

    public String getFormattedModels(){
        return data.stream()
                .map(m -> m.getId())
                .collect(Collectors.joining("\n "));
    }

    @Override
    public String toString() {
        return "ModelList{" +
                "data=" + data.toString() +
                ", object='" + object + '\'' +
                '}';
    }

    public List<Model> getData() {
        return data;
    }

    public void setData(List<Model> data) {
        this.data = data;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
