package movies.spring.data.neo4j.services.impl;

import movies.spring.data.neo4j.domain.SIMCard;
import movies.spring.data.neo4j.repositories.SIMCardRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.SIMCardService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

/**
 * Create on 2018/8/7 14:11
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Service("simCardService")
public class SIMCardServiceImpl extends GenericService<SIMCard> implements SIMCardService {
    private final SIMCardRepository simCardRepository;

    public SIMCardServiceImpl(SIMCardRepository simCardRepository) {
        this.simCardRepository = simCardRepository;
    }

    @Override
    public Neo4jRepository<SIMCard, Long> getRepository() {
        return simCardRepository;
    }

    @Override
    public SIMCard findByImsi(String imsi) {
        return simCardRepository.findByImsi(imsi);
    }

    @Override
    public SIMCard findBySimCardNumber(String simCardNumber) {
        return simCardRepository.findBySimCardNumber(simCardNumber);
    }
}
