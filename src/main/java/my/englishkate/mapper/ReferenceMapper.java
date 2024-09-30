package my.englishkate.mapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import my.englishkate.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public class ReferenceMapper {
    @Autowired
    private EntityManager entityManager;

    public <T extends BaseEntity> T toEntity(Long id, @TargetType Class<T> entityClass) {
        if (id == null) {
            return null;
        }
        T entity = entityManager.find(entityClass, id);
        if (entity == null) {
            throw new EntityNotFoundException(entityClass.getName() + " id: " + id);
        }
        return entity;
    }
}
