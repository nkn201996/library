package repository;

import model.Rack;

import java.util.HashMap;
import java.util.Map;

public class RackRepository {
    Map<String, Rack>rackMap;

    public RackRepository() {
        this.rackMap = new HashMap<>();
    }

    public Map<String, Rack> getRackMap() {
        return rackMap;
    }

    public void setRackMap(Map<String, Rack> rackMap) {
        this.rackMap = rackMap;
    }
}
