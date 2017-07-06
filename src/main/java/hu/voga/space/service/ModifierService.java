package hu.voga.space.service;

import hu.voga.space.entity.Modifier;
import hu.voga.space.entity.Resource;
import hu.voga.space.entity.SolarSystem;
import hu.voga.space.enums.ModifierRule;
import hu.voga.space.enums.ModifierType;
import hu.voga.space.repository.ModifierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModifierService {

    private static final Logger logger = LoggerFactory.getLogger(ModifierService.class);

    @Autowired
    private ModifierRepository modifierRepository;

    @Autowired
    private ResourceService resourceService;

    @Transactional
    public Modifier save(ModifierRule modifierRule, SolarSystem solarSystem){
        Modifier modifier = new Modifier();
        modifier.setSolarSystem(solarSystem);
        modifier.setModType(modifierRule.getModifierType());
        modifier.setModCalcType(modifierRule.getModifierCalcType());
        modifier.setResourceType(modifierRule.getResourceType());
        modifier.setModValue(modifierRule.getValue());

        if(modifierRule.getModifierType().equals(ModifierType.RESOURCE_RATE)){
            Resource resource = resourceService.findResourcesBySystemAndType(modifierRule.getResourceType(), solarSystem);
            resourceService.updateRate(resource,modifierRule.getModifierCalcType(),modifierRule.getValue());
        }

        return modifierRepository.save(modifier);
    }

}
