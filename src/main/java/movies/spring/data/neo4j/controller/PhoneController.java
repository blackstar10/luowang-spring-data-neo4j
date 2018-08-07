package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Phone;
import movies.spring.data.neo4j.services.PhoneService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Create on 2018/8/7 14:23
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RestController
@RequestMapping("/api/phone")
public class PhoneController extends Controller<Phone> {
    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @Override
    public Service<Phone> getService() {
        return phoneService;
    }

    @RequestMapping("/getByimei")
    public Phone GetGroupByName(@RequestParam(value = "imei") String imei, final HttpServletResponse response) {
        setHeaders(response);
        return phoneService.findByImei(imei);
    }
}
