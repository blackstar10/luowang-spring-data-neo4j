package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.services.HumanService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Create on 2018/7/30 15:37
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RestController
@RequestMapping("/api/human")
public class HumanController extends Controller<Human> {

    private final HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @Override
    public Service<Human> getService() {
        return humanService;
    }

    @RequestMapping("/getByName")
    public Collection<Human> GetHumanByName(@RequestParam(value = "name") String name, final HttpServletResponse response) {
        setHeaders(response);
        return humanService.findByName(name);
    }

    @RequestMapping("/getByIdNumber")
    public Collection<Human> GetHumanByIdNumber(@RequestParam(value = "id") String idNumber, final HttpServletResponse response) {
        setHeaders(response);
        return humanService.findByIdNumber(idNumber);
    }

    @RequestMapping("/getByPhoneNumber")
    public Collection<Human> GetHumanByPhoneNumber(@RequestParam(value = "phoneNumber") String PhoneNumber, final HttpServletResponse response) {
        setHeaders(response);
        return humanService.findBySIMCardNumber(PhoneNumber);
    }

//    @RequestMapping("/save")
//    public Human createHumanByProperties(@RequestParam(value = "name") String name) {
//        return humanService.createHuman(name);
//    }
//
//    @RequestMapping("/update")
//    public Human updateHumanByProperties(@RequestParam(value = "name") String name) {
//        return humanService.createHuman(name);
//    }
//
//    @RequestMapping("/delete")
//    public Human deleteHumanByProperties(@RequestParam(value = "name") String name) {
//        return humanService.createHuman(name);
//    }
}
