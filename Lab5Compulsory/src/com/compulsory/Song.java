package com.compulsory;

import java.io.Serializable;
import java.nio.file.Path;

public class Song extends Item {

    public Song(String name, Path path) {
        super(name, path);
    }
}
