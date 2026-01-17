package com.resume_builder.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "template_id")
    private Long templateId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "font_family", length = 100)
    private String fontFamily = "Arial";

    @Column(name = "font_size")
    private Integer fontSize = 12;

    @Column(name = "color_scheme", length = 50)
    private String colorScheme = "default";

    @Column(name = "line_spacing", precision = 3, scale = 1)
    private BigDecimal lineSpacing = new BigDecimal("1.5");

    @Column(name = "margin_top")
    private Integer marginTop = 20;

    @Column(name = "margin_bottom")
    private Integer marginBottom = 20;

    @Column(name = "margin_left")
    private Integer marginLeft = 20;

    @Column(name = "margin_right")
    private Integer marginRight = 20;
}