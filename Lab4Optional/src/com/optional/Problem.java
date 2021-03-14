package com.optional;

import java.util.List;
import java.util.Map;

public class Problem {

    Map<Student, List<School>> stdPrefMap;
    Map<School, List<Student>> schPrefMap;

    public Problem(Map<Student, List<School>> stdPrefMap, Map<School, List<Student>> schPrefMap) {
        this.stdPrefMap = stdPrefMap;
        this.schPrefMap = schPrefMap;
    }

    public Problem() {
    }
}
