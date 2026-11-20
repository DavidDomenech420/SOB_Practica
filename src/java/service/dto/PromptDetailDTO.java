/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.entities.Prompt;
import model.entities.Tool;

/**
 *
 * @author Kei
 */
public class PromptDetailDTO {
    private Long id;
    private String title;
    private String description;
    private String template;
    private String author;
    private List<String> tags;
    private Date creationDate;
    private boolean isPrivate;
    private List<ToolDTO> tools;

    public PromptDetailDTO() {
    }
    
    public PromptDetailDTO(Prompt p){
        this.id = p.getId();
        this.title = p.getTitle();
        this.description = p.getDescription();
        this.template = p.getTemplate();
        this.creationDate = p.getCreationDate();
        this.isPrivate = p.isIsPrivate();
        this.author = (p.getAuthor() != null) ? p.getAuthor().getUsername() : null;
        this.tags = (p.getTags() != null) ? new ArrayList<>(p.getTags()) : new ArrayList<>();
        this.tools = new ArrayList<>();
        if (p.getTools() != null) {
            for (Tool t : p.getTools()) {
                this.tools.add(new ToolDTO(t));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<ToolDTO> getTools() {
        return tools;
    }

    public void setTools(List<ToolDTO> tools) {
        this.tools = tools;
    }
    
    
}
