package ig2i.apieventjava.mappers;

import ig2i.apieventjava.dto.Address;
import ig2i.apieventjava.entities.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address AddressEntityToAddress(AddressEntity addressEntity);
    AddressEntity addressToAddressEntity(Address address);
}
