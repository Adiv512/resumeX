package com.resume_builder.entity;

import com.resume_builder.entity.enums.SectionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;

@Entity
@Table(
        name = "resume_sections",
        uniqueConstraints = @UniqueConstraint(columnNames = {"resume_id", "section_type"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeSection extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resume_id", nullable = false)
    private Long resumeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "section_type", nullable = false, length = 50)
    private SectionType sectionType;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder = 0;

    @Column(name = "is_visible")
    private Boolean isVisible = true;

    @Column(name = "content", nullable = false, columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private String content;
}