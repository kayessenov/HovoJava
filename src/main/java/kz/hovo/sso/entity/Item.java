package kz.hovo.sso.entity;

import jakarta.persistence.*;
import kz.hovo.sso.entity.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_item")
@Entity
public class Item extends BaseEntity {
    private String title;
    private String caption;
    private Integer likes;

    @Column
    @ElementCollection(targetClass = String.class)
    private Set<String> likedUsers = new HashSet<>();

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "item", orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();
}
