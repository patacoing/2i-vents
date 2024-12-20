package ig2i.apieventjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Setter
@Getter
@AllArgsConstructor
@Table("event")
public class EventEntity {
    @Id
    private UUID id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    private String address;


    //@Convert(converter = StringToListConverter.class)

    @Column("participants")
    private List<String> participants;
    @Column("organizers")
    private List<String>  organizers;
    private LocalDate date;
    private LocalTime time;
    @Column
    private List<String> themes;


}
