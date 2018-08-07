package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Phone;
import movies.spring.data.neo4j.domain.SIMCard;
import movies.spring.data.neo4j.services.SIMCardService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create on 2018/8/7 14:24
 *
 * @author sunqiu@cmss.chinamobile.com
 */


@RestController
@RequestMapping("/api/phone")
public class SIMCardController extends Controller<SIMCard>{
    private final SIMCardService simCardService;

    public SIMCardController(SIMCardService simCardService){
        this.simCardService = simCardService;
    }
    @Override
    public Service<SIMCard> getService() {
        return simCardService;
    }

    @RequestMapping("/getByImsi")
    public SIMCard GetGroupByIMSI(@RequestParam(value = "imsi") String imsi) {
        return simCardService.findByImsi(imsi);
    }

    @RequestMapping("/getByPhoneNumber")
    public SIMCard GetGroupByName(@RequestParam(value = "phoneNumber") String phoneNumber) {
        return simCardService.findBySimCardNumber(phoneNumber);
    }
}
