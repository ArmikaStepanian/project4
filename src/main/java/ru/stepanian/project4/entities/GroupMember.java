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

    @Column
    private String username;

    @Column(name = "GROUP_ID")
    private Long group = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }
}
