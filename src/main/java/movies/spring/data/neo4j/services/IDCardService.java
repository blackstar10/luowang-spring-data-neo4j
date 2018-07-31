package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.IDCard;

import java.util.Collection;

/**
 * Create on 2018/7/31 17:12
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public interface IDCardService extends Service<IDCard> {
    Collection<IDCard> findByIdNumber(String idNumber);
}
