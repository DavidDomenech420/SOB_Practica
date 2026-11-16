/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import authn.Credentials;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement
@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="Customer_Gen", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_Gen") 
    private Long id;
    @Column(unique=true)
    @NotNull(message="Username can't be null")
    private String username;
    private String email;
    private String fullName;
    @OneToOne
    private Credentials credentials;
    
    @OneToMany(
    mappedBy = "author",
    fetch = FetchType.LAZY
    )
    private List<Prompt> prompts;
            
    @OneToMany(
    mappedBy = "author",
    fetch = FetchType.LAZY
    )
    private List<Tool> tools;

    @XmlTransient
    @JsonbTransient
    public List<Prompt> getPrompts() {
        return prompts;
    }

    @XmlTransient
    @JsonbTransient
    public List<Tool> getTools() {
        return tools;
    }

    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @XmlTransient
    @JsonbTransient
    public Credentials getCredentials() {
        return credentials;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Customer[ id=" + id + " ]";
    }
    
}
