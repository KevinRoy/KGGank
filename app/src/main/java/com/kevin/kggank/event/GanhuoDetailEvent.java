package com.kevin.kggank.event;

import java.util.List;

/**
 * Created by kevin on 16/5/22.
 */

public class GanhuoDetailEvent {

    List<String> dates;

    public GanhuoDetailEvent(List<String> dates) {
        this.dates = dates;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }
}
