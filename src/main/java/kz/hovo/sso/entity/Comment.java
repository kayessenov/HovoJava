package kz.hovo.sso.entity;

import jakarta.persistence.*;
import kz.hovo.sso.entity.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comment")
@Entity
public class Comment extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Long userId;
    @Column(columnDefinition = "text", nullable = false)
    private String message;
}
