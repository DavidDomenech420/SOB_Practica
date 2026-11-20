/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.dto;

import java.util.Date;
import model.entities.Prompt;

/**
 *
 * @author Kei
 */
public class PromptSummaryDTO {
    
    private Long id;
    private String title;
    private String author;
    private Date creationDate;
    
    public PromptSummaryDTO() {
    }
    
    public PromptSummaryDTO(Prompt p){
        this.id = p.getId();
        this.title = p.getTitle();
        this.creationDate = p.getCreationDate();
        this.author = (p.getAuthor() != null) ? p.getAuthor().getUsername() : null;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
}
