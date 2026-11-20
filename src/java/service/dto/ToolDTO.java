/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.dto;

import java.util.Date;
import model.entities.Tool;

/**
 *
 * @author Kei
 */
public class ToolDTO {
    private Long id;
    private String name;
    private String language;
    private String code;
    private String version;
    private Date creationDate;
    private boolean isPrivate;
    private String author;

    public ToolDTO() {
    }
    
    public ToolDTO(Tool t) {
    this.id = t.getId();
    this.name = t.getName();
    this.language = t.getLanguage();
    this.code = t.getCode();
    this.version = t.getVersion();
    this.creationDate = t.getCreationDate();
    this.isPrivate = t.isIsPrivate();
    this.author = (t.getAuthor() != null) ? t.getAuthor().getUsername() : null;
}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getCode() {
        return code;
    }

    public String getVersion() {
        return version;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    
}
