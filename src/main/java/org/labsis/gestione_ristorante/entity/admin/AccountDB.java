package org.labsis.gestione_ristorante.entity.admin;


import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO: Documentazione
 */

@Entity
@Table(name = "accountdb")
public class AccountDB implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "username", nullable = false)
    private String username;
    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    public AccountDB() {}

    public AccountDB(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public AccountDB(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getEmail() {
        return email;
    }

    @Transient
    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public String getUsername() {
        return this.username;
    }

    @Transient
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equal(getId(), account.getId()) &&
                Objects.equal(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getPassword());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    /*
    @Transient
    public void addRole(OldRole role) {
        roles.add(role);
    }

    @Transient
    public void removeRole(OldRole role) {
        roles.remove(role);
    }

    @Transient
    public boolean removeRoleByName(String roleName) {
        Iterator<OldRole> it = roles.iterator();
        while(it.hasNext()) {
            if(it.next().getOldRole().equals(roleName)){
                it.remove();
                return true;
            }
        }
        return false;
    }
*/


}
