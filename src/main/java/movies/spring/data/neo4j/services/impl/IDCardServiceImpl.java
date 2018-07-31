package movies.spring.data.neo4j.services.impl;

import movies.spring.data.neo4j.domain.IDCard;
import movies.spring.data.neo4j.repositories.IDCardRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.IDCardService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Create on 2018/7/31 17:27
 *
 * @author sunqiu@cmss.chinamobile.com
 */


@Service("iDCardService")
public class IDCardServiceImpl extends GenericService<IDCard> implements IDCardService {

    private final IDCardRepository idCardRepository;

    public IDCardServiceImpl(IDCardRepository idCardRepository) {
        this.idCardRepository = idCardRepository;
    }

    @Override
    @Transactional
    public Collection<IDCard> findByIdNumber(String idNumber) {
        return idCardRepository.findIDCardByIdNumber(idNumber);
    }

    @Override
    public Neo4jRepository<IDCard, Long> getRepository() {
        return idCardRepository;
    }

}
