package ru.stepanian.project4.entities;

import javax.persistence.*;

/**
 * Created by Stepanian on 23.04.2016.
 */

@Entity
@Table(name = "GROUP_MEMBERS")
public class GroupMember {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column (name = "USERNAME")
    private String login;

    @Column(name = "GROUP_ID")
    private Byte groupID = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Byte getGroupID() {
        return groupID;
    }

    public void setGroupID(Byte groupID) {
        this.groupID = groupID;
    }
}
