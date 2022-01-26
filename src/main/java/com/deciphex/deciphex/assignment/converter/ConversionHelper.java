package com.deciphex.deciphex.assignment.converter;

import com.deciphex.deciphex.assignment.StudyApplication;
import com.deciphex.deciphex.assignment.entities.Study;
import lombok.AllArgsConstructor;
import org.dozer.Mapper;
import org.hibernate.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConversionHelper {

    private static final Logger log = LoggerFactory.getLogger(StudyApplication.class);

    private final Mapper mapper;

    public Study convertStudyToEntity(com.deciphex.deciphex.assignment.models.Study newStudy) {
        Study study = new Study();
        try {
            mapper.map(newStudy, Study.class);
        } catch (MappingException mappingException) {
            log.error(String.format("Error occurred during mapping process of %s, see exception here for more details: "
                    + mappingException.getLocalizedMessage(), com.deciphex.deciphex.assignment.models.Study.class));
        }

        return study;
    }

    public com.deciphex.deciphex.assignment.models.Study convertEntityToModel(Study studyEntity){
        com.deciphex.deciphex.assignment.models.Study study = new com.deciphex.deciphex.assignment.models.Study();
        try {
            mapper.map(studyEntity, com.deciphex.deciphex.assignment.models.Study.class);
        } catch (MappingException mappingException) {
            log.error(String.format("Error occurred during mapping process of %s, see exception here for more details: "
                    + mappingException.getLocalizedMessage(), com.deciphex.deciphex.assignment.models.Study.class));
        }
        return study;
    }

}
