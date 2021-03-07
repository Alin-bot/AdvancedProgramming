package com.optional;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {

    LocalTime getOpeningTime();
    LocalTime getClosingTime();

    default LocalTime makeDefaultOpeningTime() {
        return LocalTime.of(9, 30);
    } // returning default opening hour
    default LocalTime makeDefaultClosingTime() {
        return LocalTime.of(20, 0);
    } // returning default closing hour

    static Duration getVisitedDuration(Location object) {
        return Duration.between(object.openingTime, object.closingTime);
    }
}
