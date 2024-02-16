package king.ide.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folders folders;

    private String packagename;

    @OneToMany(mappedBy = "packages")
    private List<Files> filesList;

    public List<Files> getFiles() {
        return filesList;
    }
}