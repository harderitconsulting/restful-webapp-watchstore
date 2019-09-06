package de.harderitconsulting.resource.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Watch {
    private long id;
    private String manufacturer;
    private String model;

    public Watch() {

    }

    public Watch(long id, String manufacturer, String model) {
        super();
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}