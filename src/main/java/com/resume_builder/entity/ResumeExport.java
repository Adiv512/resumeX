package com.resume_builder.entity;

import com.resume_builder.entity.enums.ExportFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resume_exports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeExport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resume_id", nullable = false)
    private Long resumeId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "file_path", length = 500)
    private String filePath;

    @Column(name = "file_name", length = 255)
    private String fileName;

    @Enumerated(EnumType.STRING)
    @Column(name = "export_format", length = 20)
    private ExportFormat exportFormat = ExportFormat.PDF;

    @Column(name = "file_size_kb")
    private Integer fileSizeKb;

    @Column(name = "exported_at", nullable = false)
    private LocalDateTime exportedAt;

    @PrePersist
    protected void onCreate() {
        exportedAt = LocalDateTime.now();
    }
}