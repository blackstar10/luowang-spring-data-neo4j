package movies.spring.data.neo4j.services.impl;

import movies.spring.data.neo4j.domain.Phone;
import movies.spring.data.neo4j.repositories.PhoneRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.PhoneService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

/**
 * Create on 2018/8/7 14:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Service("phoneService")
public class PhoneServiceImpl extends GenericService<Phone> implements PhoneService{
    private final PhoneRepository phoneRepository;

    public PhoneServiceImpl(PhoneRepository phoneRepository){
        this.phoneRepository = phoneRepository;
    }
    @Override
    public Neo4jRepository<Phone, Long> getRepository() {
        return phoneRepository;
    }

    @Override
    public Phone findByImei(String imei) {
        return phoneRepository.findByImei(imei);
    }
}
