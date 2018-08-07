package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.IDCard;
import movies.spring.data.neo4j.domain.Phone;
import movies.spring.data.neo4j.services.IDCardService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Create on 2018/7/31 17:28
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RestController
@RequestMapping("/api/idcard")
public class IDCardController extends Controller<IDCard> {

    private final IDCardService idCardService;

    public IDCardController(IDCardService idCardService) {
        this.idCardService = idCardService;
    }

    @Override
    public Service<IDCard> getService() {
        return idCardService;
    }

    @RequestMapping("/getByIdNumber")
    public Collection<IDCard> GetHumanByIdNumber(@RequestParam(value = "id") String idNumber) {
        return idCardService.findByIdNumber(idNumber);
    }
}
