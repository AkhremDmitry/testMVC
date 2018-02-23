package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ModelSingl {
    private static ModelSingl instance = new ModelSingl();

    private List<User> model;

    public static ModelSingl getInstance(){
        return instance;
    }

    private ModelSingl(){
        model = new ArrayList<>();
    }

    public void add(User user){
        model.add(user);
    }

    public List<String> list(){
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
