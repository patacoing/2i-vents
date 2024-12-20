package ig2i.apieventjava.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@Table("address")
public class AddressEntity {
    @Id()
    private UUID id;

    @Column("name")
    private String name;

    @Column("city")
    private String city;

    @Column("zip_code")
    private String zipCode;

    @Column("street_name")
    private String streetName;

    @Column("street_number")
    private String streetNumber;
}
