package com.resume_builder.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "resume_versions",
        uniqueConstraints = @UniqueConstraint(columnNames = {"resume_id", "version_number"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resume_id", nullable = false)
    private Long resumeId;

    @Column(name = "version_number", nullable = false)
    private Integer versionNumber;

    @Column(name = "version_name", length = 100)
    private String versionName;

    @Column(name = "snapshot", nullable = false, columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private String snapshot;

    @Column(name = "change_description", columnDefinition = "TEXT")
    private String changeDescription;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}