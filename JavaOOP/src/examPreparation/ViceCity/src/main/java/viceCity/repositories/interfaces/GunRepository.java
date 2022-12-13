package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GunRepository implements Repository<Gun> {

    private List<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }
    @Override
    public List<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        Gun gun = models.stream().filter(g -> g.getName().equals(model.getName())).findFirst().orElse(null);
        if (gun == null) {
            models.add(model);
        }

    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(g -> g.getName().equals(name))
                .findFirst()
                .get();
    }
}
