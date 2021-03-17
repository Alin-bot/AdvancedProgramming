package com.optional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private String id;
    private String name;
    private String path; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    public Item(String id, String name, String path) throws InvalidCatalogException {

        if (id == null || id.replaceAll("\\s", "").isEmpty())
            throw new InvalidCatalogException("Error: the id is empty!");
        if (id.matches("[a-zA-Z]+")) throw new InvalidCatalogException("Error: the id must be a number!");
        this.id = id;

        if (name == null || name.replaceAll("\\s", "").isEmpty())
            throw new InvalidCatalogException("Error: the name is empty!");
        this.name = name;

        if (path == null || path.replaceAll("\\s", "").isEmpty())
            throw new InvalidCatalogException("Error: the path is empty!");
        this.path = path;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
