package com.leoCode.SpringBootMaster.infoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "info.app")
public class InfoApp {
    private String name;
    private String description;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "InfoApp{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InfoApp)) return false;
        InfoApp infoApp = (InfoApp) o;
        return name.equals(infoApp.name) && description.equals(infoApp.description) && version.equals(infoApp.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, version);
    }
}
