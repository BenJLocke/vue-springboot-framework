package cn.benlocke.webservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_menu_item")
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String index;
    private String title;

    private Integer level;
    private Long parentId;
}
