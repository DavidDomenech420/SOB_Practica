/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import authn.Credentials;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;

@XmlRootElement
@Entity
public class Prompt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Prompt_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Prompt_Gen") 
    private Long id;
    @NotNull(message="Title can't be null")
    private String title;
    private String description;
    @NotNull(message="Template can't be null")
    private String template;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    private boolean isPrivate;
    @ElementCollection
    private List<String> tags;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Customer author;
    @ManyToMany
    @JoinTable(
            name = "PROMPT_TOOL",
            joinColumns = @JoinColumn(name = "prompt_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_id")
    )
    private List<Tool> tools;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTemplate() {
        return template;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setAuthor(Customer author) {
        this.author = author;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public List<String> getTags() {
        return tags;
    }

    public Customer getAuthor() {
        return author;
    }

    public List<Tool> getTools() {
        return tools;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prompt)) {
            return false;
        }
        Prompt other = (Prompt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Prompt[ id=" + id + " ]";
    }
    
}
