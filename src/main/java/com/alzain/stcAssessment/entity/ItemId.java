package com.alzain.stcAssessment.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ItemId  implements Serializable {

    @Column(name = "space", nullable = false)
    private String space ;

    @Column(name = "folder")
    private String folder;

    @Column(name = "file")
    private String file ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        ItemId itemId = (ItemId) o;
        return Objects.equals(space, itemId.space) && Objects.equals(folder, itemId.folder) && Objects.equals(file, itemId.file);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (getFile() == null ? 0 : this.getFile().hashCode());
        result = 37 * result + (getSpace() == null ? 0 : this.getSpace().hashCode());
        result = 37 * result + (getFolder() == null ? 0 : this.getFolder().hashCode());

        return result;
    }
}
