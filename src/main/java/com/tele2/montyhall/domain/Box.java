package com.tele2.montyhall.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Box {

    @JsonProperty
    private  final int id;
    @JsonProperty
    private  boolean containsMoney;
    @JsonIgnore
    private BoxState boxState;

    public  enum  BoxState{
        OPENED, CLOSED

    }

    Box(int id) {
        this.id = id;
        this.containsMoney = false;
        this.boxState = BoxState.CLOSED;


    }

    int getId() {
        return id;
    }


    public boolean containsMoney() {
        return containsMoney;
    }

    void setContainsMoney(boolean containsMoney) {
        this.containsMoney = containsMoney;
    }

    BoxState getBoxState() {
        return boxState;
    }

    void setBoxState(BoxState boxState) {
        this.boxState = boxState;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return getId() == box.getId() &&
                containsMoney() == box.containsMoney();
    }



    @Override
    public int hashCode() {
        return Objects.hash(getId(), containsMoney());
    }

    @Override
    public String toString() {
        return "Box{" +
                "id=" + id +
                ", containsMoney=" + containsMoney +
                ", boxState=" + boxState +
                '}';
    }
}
