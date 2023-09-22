package com.example.shiftlabtask;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class CustomInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String IntervalBegin, IntervalEnd, IntervalKind;
    /*public CustomInterval(String start, String end) {
        this.IntervalBegin = start;
        this.IntervalEnd = end;

    }*/

    public CustomInterval() {

    }

    public String getIntervalBegin(){
        return IntervalBegin;
    }

    public String getIntervalEnd(){
        return IntervalEnd;
    }

    public String getIntervalKind(){
        return IntervalKind;
    }

    public void setIntervalKind(String intervalKind){
        this.IntervalKind = intervalKind;
    }
    public void setIntervalBegin(String intervalBegin){
        this.IntervalBegin = intervalBegin;
    }

    public void setIntervalEnd(String intervalEnd){
        this.IntervalEnd = intervalEnd;
    }
}
